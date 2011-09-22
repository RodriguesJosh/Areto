package com.netty.game.model.entity;

import com.netty.game.Client;
import com.netty.game.model.Model;
import com.netty.net.cache.MemoryCache;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;
import com.netty.stuff.Animation;
import com.netty.stuff.VarBit;

public class EntityDef {

	public static EntityDef forID(int i) {
		for (int j = 0; j < 20; j++) {
			if (EntityDef.cache[j].type == i) {
				return EntityDef.cache[j];
			}
		}
		EntityDef.cacheIndex = (EntityDef.cacheIndex + 1) % 20;
		EntityDef entityDef = EntityDef.cache[EntityDef.cacheIndex] = new EntityDef();
		EntityDef.packet.setPosition(EntityDef.streamIndices[i]);
		entityDef.type = i;
		entityDef.readValues(EntityDef.packet);
		return entityDef;
	}

	public Model getHeadModel() {
		if (this.childrenIDs != null) {
			EntityDef entityDef = this.method161();
			if (entityDef == null) {
				return null;
			}
			return entityDef.getHeadModel();
		}
		if (this.aditionalModels == null) {
			return null;
		}
		boolean modelMissing = false;
		for (int i = 0; i < this.aditionalModels.length; i++) {
			if (!Model.method463(this.aditionalModels[i])) {
				modelMissing = true;
			}
		}
		if (modelMissing) {
			return null;
		}
		Model additionalModels[] = new Model[this.aditionalModels.length];
		for (int j = 0; j < this.aditionalModels.length; j++) {
			additionalModels[j] = Model.method462(this.aditionalModels[j]);
		}
		Model model;
		if (additionalModels.length == 1) {
			model = additionalModels[0];
		} else {
			model = new Model(additionalModels.length, additionalModels);
		}
		if (this.recolourOriginal != null) {
			for (int k = 0; k < this.recolourOriginal.length; k++) {
				model.method476(this.recolourOriginal[k], this.recolourTarget[k]);
			}
		}
		return model;
	}

	public EntityDef method161() {
		int j = -1;
		if (this.varBitID != -1) {
			VarBit varBit = VarBit.cache[this.varBitID];
			@SuppressWarnings("unused")
			int k = varBit.configID;
			@SuppressWarnings("unused")
			int l = varBit.leastSignificantBit;
			@SuppressWarnings("unused")
			int i1 = varBit.mostSignificantBit;
			// int j1 = Client.anIntArray1232[i1 - l];
			// j = (EntityDef.clientInstance.variousSettings[k] >> l) & j1;
		} else if (this.sessionSettingID != -1) {
			// j = EntityDef.clientInstance.variousSettings[this.sessionSettingID];
		}
		if ((j < 0) || (j >= this.childrenIDs.length) || (this.childrenIDs[j] == -1)) {
			return null;
		}
		return EntityDef.forID(this.childrenIDs[j]);
	}

	public static void unpackConfig(JagexArchive jagexArchive) {
		EntityDef.packet = new Packet(jagexArchive.getDataForName("npc.dat"));
		Packet stream2 = new Packet(jagexArchive.getDataForName("npc.idx"));
		int totalNPCs = stream2.getUnsignedShort();
		EntityDef.streamIndices = new int[totalNPCs];
		int i = 2;
		for (int j = 0; j < totalNPCs; j++) {
			EntityDef.streamIndices[j] = i;
			i += stream2.getUnsignedShort();
		}
		EntityDef.cache = new EntityDef[20];
		for (int k = 0; k < 20; k++) {
			EntityDef.cache[k] = new EntityDef();
		}
	}

	public static void nullLoader() {
		EntityDef.modelCache = null;
		EntityDef.streamIndices = null;
		EntityDef.cache = null;
		EntityDef.packet = null;
	}

	public Model method164(int j, int k, int ai[]) {
		if (this.childrenIDs != null) {
			EntityDef entityDef = this.method161();
			if (entityDef == null) {
				return null;
			}
			return entityDef.method164(j, k, ai);
		}
		Model model = (Model) EntityDef.modelCache.insertFromCache(this.type);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < this.npcModels.length; i1++) {
				if (!Model.method463(this.npcModels[i1])) {
					flag = true;
				}
			}
			if (flag) {
				return null;
			}
			Model aclass30_sub2_sub4_sub6s[] = new Model[this.npcModels.length];
			for (int j1 = 0; j1 < this.npcModels.length; j1++) {
				aclass30_sub2_sub4_sub6s[j1] = Model.method462(this.npcModels[j1]);
			}
			if (aclass30_sub2_sub4_sub6s.length == 1) {
				model = aclass30_sub2_sub4_sub6s[0];
			} else {
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			}
			if (this.recolourOriginal != null) {
				for (int k1 = 0; k1 < this.recolourOriginal.length; k1++) {
					model.method476(this.recolourOriginal[k1], this.recolourTarget[k1]);
				}
			}
			model.method469();
			model.method479(64 + this.lightModifier, 850 + this.shadowModifier, -30, -50, -30, true);
			EntityDef.modelCache.removeFromCache(model, this.type);
		}
		Model model_1 = Model.aModel_1621;
		model_1.method464(model, Animation.method532(k) & Animation.method532(j));
		if ((k != -1) && (j != -1)) {
			model_1.method471(ai, j, k);
		} else if (k != -1) {
			model_1.method470(k);
		}
		if ((this.scaleXZ != 128) || (this.scaleY != 128)) {
			model_1.method478(this.scaleXZ, this.scaleXZ, this.scaleY);
		}
		model_1.method466();
		model_1.triangleSkin = null;
		model_1.vertexSkin = null;
		if (this.boundDim == 1) {
			model_1.oneSquareModel = true;
		}
		return model_1;
	}

	private void readValues(Packet packet) {
		do {
			int i = packet.getUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				int j = packet.getUnsignedByte();
				this.npcModels = new int[j];
				for (int j1 = 0; j1 < j; j1++) {
					this.npcModels[j1] = packet.getUnsignedShort();
				}
			} else if (i == 2) {
				this.name = packet.getString();
			} else if (i == 3) {
				this.description = packet.getBytes();
			} else if (i == 12) {
				this.boundDim = packet.getByte();
			} else if (i == 13) {
				this.idleAnimation = packet.getUnsignedShort();
			} else if (i == 14) {
				this.walkAnimIndex = packet.getUnsignedShort();
			} else if (i == 17) {
				this.walkAnimIndex = packet.getUnsignedShort();
				this.turn180AnimIndex = packet.getUnsignedShort();
				this.turn90CWAnimIndex = packet.getUnsignedShort();
				this.turn90CCWAnimIndex = packet.getUnsignedShort();
			} else if ((i >= 30) && (i < 40)) {
				if (this.actions == null) {
					this.actions = new String[5];
				}
				this.actions[i - 30] = packet.getString();
				if (this.actions[i - 30].equalsIgnoreCase("hidden")) {
					this.actions[i - 30] = null;
				}
			} else if (i == 40) {
				int k = packet.getUnsignedByte();
				this.recolourOriginal = new int[k];
				this.recolourTarget = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					this.recolourOriginal[k1] = packet.getUnsignedShort();
					this.recolourTarget[k1] = packet.getUnsignedShort();
				}
			} else if (i == 60) {
				int l = packet.getUnsignedByte();
				this.aditionalModels = new int[l];
				for (int l1 = 0; l1 < l; l1++) {
					this.aditionalModels[l1] = packet.getUnsignedShort();
				}
			} else if (i == 90) {
				packet.getUnsignedShort();
			} else if (i == 91) {
				packet.getUnsignedShort();
			} else if (i == 92) {
				packet.getUnsignedShort();
			} else if (i == 93) {
				this.drawMinimapDot = false;
			} else if (i == 95) {
				this.combatLevel = packet.getUnsignedShort();
			} else if (i == 97) {
				this.scaleXZ = packet.getUnsignedShort();
			} else if (i == 98) {
				this.scaleY = packet.getUnsignedShort();
			} else if (i == 99) {
				this.aBoolean93 = true;
			} else if (i == 100) {
				this.lightModifier = packet.getByte();
			} else if (i == 101) {
				this.shadowModifier = packet.getByte() * 5;
			} else if (i == 102) {
				this.headIcon = packet.getUnsignedShort();
			} else if (i == 103) {
				this.degreesToTurn = packet.getUnsignedShort();
			} else if (i == 106) {
				this.varBitID = packet.getUnsignedShort();
				if (this.varBitID == 65535) {
					this.varBitID = -1;
				}
				this.sessionSettingID = packet.getUnsignedShort();
				if (this.sessionSettingID == 65535) {
					this.sessionSettingID = -1;
				}
				int i1 = packet.getUnsignedByte();
				this.childrenIDs = new int[i1 + 1];
				for (int i2 = 0; i2 <= i1; i2++) {
					this.childrenIDs[i2] = packet.getUnsignedShort();
					if (this.childrenIDs[i2] == 65535) {
						this.childrenIDs[i2] = -1;
					}
				}
			} else if (i == 107) {
				this.clickable = false;
			}
		} while (true);
	}

	private EntityDef() {
		this.turn90CCWAnimIndex = -1;
		this.varBitID = -1;
		this.turn180AnimIndex = -1;
		this.sessionSettingID = -1;
		this.combatLevel = -1;
		this.walkAnimIndex = -1;
		this.boundDim = 1;
		this.headIcon = -1;
		this.idleAnimation = -1;
		this.type = -1L;
		this.degreesToTurn = 32;
		this.turn90CWAnimIndex = -1;
		this.clickable = true;
		this.scaleY = 128;
		this.drawMinimapDot = true;
		this.scaleXZ = 128;
		this.aBoolean93 = false;
	}

	public int turn90CCWAnimIndex;
	private static int cacheIndex;
	private int varBitID;
	public int turn180AnimIndex;
	private int sessionSettingID;
	private static Packet packet;
	public int combatLevel;
	public String name;
	public String actions[];
	public int walkAnimIndex;
	public byte boundDim;
	private int[] recolourTarget;
	private static int[] streamIndices;
	private int[] aditionalModels;
	public int headIcon;
	private int[] recolourOriginal;
	public int idleAnimation;
	public long type;
	public int degreesToTurn;
	private static EntityDef[] cache;
	public static Client clientInstance;
	public int turn90CWAnimIndex;
	public boolean clickable;
	private int lightModifier;
	private int scaleY;
	public boolean drawMinimapDot;
	public int childrenIDs[];
	public byte description[];
	private int scaleXZ;
	private int shadowModifier;
	public boolean aBoolean93;
	private int[] npcModels;
	public static MemoryCache modelCache = new MemoryCache(30);
}