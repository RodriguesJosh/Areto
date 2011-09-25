package com.netty.game.model.entity.object;

import com.netty.game.Client;
import com.netty.game.model.Model;
import com.netty.net.cache.MemoryCache;
import com.netty.net.cache.OnDemandFetcher;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;
import com.netty.stuff.Animation;
import com.netty.stuff.VarBit;

public class ObjectDef {

	public static ObjectDef forID(int i) {
		for (int j = 0; j < 20; j++) {
			if (ObjectDef.cache[j].type == i) {
				return ObjectDef.cache[j];
			}
		}
		ObjectDef.cacheIndex = (ObjectDef.cacheIndex + 1) % 20;
		ObjectDef class46 = ObjectDef.cache[ObjectDef.cacheIndex];
		ObjectDef.packet.setPosition(ObjectDef.streamIndices[i]);
		class46.type = i;
		class46.setDefaults();
		class46.readValues(ObjectDef.packet);
		return class46;
	}

	private void setDefaults() {
		this.objectModelIDs = null;
		this.anIntArray776 = null;
		this.name = null;
		this.description = null;
		this.modifiedModelColors = null;
		this.originalModelColors = null;
		this.sizeX = 1;
		this.sizeY = 1;
		this.isUnwalkable = true;
		this.aBoolean757 = true;
		this.hasActions = false;
		this.isModelSolid = false;
		this.nonFlatShading = false;
		this.aBoolean764 = false;
		this.animationID = -1;
		this.anInt775 = 16;
		this.brightness = 0;
		this.contrast = 0;
		this.actions = null;
		this.mapFunctionID = -1;
		this.mapSceneID = -1;
		this.aBoolean751 = false;
		this.aBoolean779 = true;
		this.modelSizeX = 128;
		this.modelSizeH = 128;
		this.modelSizeY = 128;
		this.anInt768 = 0;
		this.offsetX = 0;
		this.offsetH = 0;
		this.offsetY = 0;
		this.aBoolean736 = false;
		this.isSolidObject = false;
		this.anInt760 = -1;
		this.configID1 = -1;
		this.configID = -1;
		this.childrenIDs = null;
	}

	public void method574(OnDemandFetcher class42_sub1) {
		if (this.objectModelIDs == null) {
			return;
		}
		for (int j = 0; j < this.objectModelIDs.length; j++) {
			class42_sub1.method560(this.objectModelIDs[j] & 0xffff, 0);
		}
	}

	public static void nullLoader() {
		ObjectDef.modelCache = null;
		ObjectDef.modelCache2 = null;
		ObjectDef.streamIndices = null;
		ObjectDef.cache = null;
		ObjectDef.packet = null;
	}

	public static void unpackConfig(JagexArchive jagexArchive) {
		ObjectDef.packet = new Packet(jagexArchive.getDataForName("loc.dat"));
		Packet packet = new Packet(jagexArchive.getDataForName("loc.idx"));
		int totalObjects = packet.getUnsignedShort();
		ObjectDef.streamIndices = new int[totalObjects];
		int i = 2;
		for (int j = 0; j < totalObjects; j++) {
			ObjectDef.streamIndices[j] = i;
			i += packet.getUnsignedShort();
		}
		ObjectDef.cache = new ObjectDef[20];
		for (int k = 0; k < 20; k++) {
			ObjectDef.cache[k] = new ObjectDef();
		}
	}

	public boolean method577(int i) {
		if (this.anIntArray776 == null) {
			if (this.objectModelIDs == null) {
				return true;
			}
			if (i != 10) {
				return true;
			}
			boolean flag1 = true;
			for (int k = 0; k < this.objectModelIDs.length; k++) {
				flag1 &= Model.method463(this.objectModelIDs[k] & 0xffff);
			}

			return flag1;
		}
		for (int j = 0; j < this.anIntArray776.length; j++) {
			if (this.anIntArray776[j] == i) {
				return Model.method463(this.objectModelIDs[j] & 0xffff);
			}
		}
		return true;
	}

	public Model method578(int i, int j, int k, int l, int i1, int j1, int k1) {
		Model model = this.method581(i, k1, j);
		if (model == null) {
			return null;
		}
		if (this.isModelSolid || this.nonFlatShading) {
			model = new Model(this.isModelSolid, this.nonFlatShading, model);
		}
		if (this.isModelSolid) {
			int l1 = (k + l + i1 + j1) / 4;
			for (int i2 = 0; i2 < model.vertexCount; i2++) {
				int j2 = model.vertexX[i2];
				int k2 = model.vertexZ[i2];
				int l2 = k + (((l - k) * (j2 + 64)) / 128);
				int i3 = j1 + (((i1 - j1) * (j2 + 64)) / 128);
				int j3 = l2 + (((i3 - l2) * (k2 + 64)) / 128);
				model.vertexY[i2] += j3 - l1;
			}
			model.method467();
		}
		return model;
	}

	public boolean method579() {
		if (this.objectModelIDs == null) {
			return true;
		}
		boolean flag1 = true;
		for (int i = 0; i < this.objectModelIDs.length; i++) {
			flag1 &= Model.method463(this.objectModelIDs[i] & 0xffff);
		}
		return flag1;
	}

	public ObjectDef method580() {
		int i = -1;
		if (this.configID1 != -1) {
			VarBit varBit = VarBit.cache[this.configID1];
			@SuppressWarnings("unused")
			int j = varBit.configID;
			@SuppressWarnings("unused")
			int k = varBit.leastSignificantBit;
			@SuppressWarnings("unused")
			int l = varBit.mostSignificantBit;
			// int i1 = Client.anIntArray1232[l - k];
			// i = (ObjectDef.clientInstance.variousSettings[j] >> k) & i1;
		} else if (this.configID != -1) {
			// i = ObjectDef.clientInstance.variousSettings[this.configID];
		}
		if ((i < 0) || (i >= this.childrenIDs.length) || (this.childrenIDs[i] == -1)) {
			return null;
		} else {
			return ObjectDef.forID(this.childrenIDs[i]);
		}
	}

	private Model method581(int j, int k, int l) {
		Model model = null;
		long l1;
		if (this.anIntArray776 == null) {
			if (j != 10) {
				return null;
			}
			l1 = ((this.type << 6) + l) + ((long)(k + 1) << 32);
			Model model_1 = (Model) ObjectDef.modelCache2.insertFromCache(l1);
			if (model_1 != null) {
				return model_1;
			}
			if (this.objectModelIDs == null) {
				return null;
			}
			boolean flag1 = this.aBoolean751 ^ (l > 3);
			int k1 = this.objectModelIDs.length;
			for (int i2 = 0; i2 < k1; i2++) {
				int l2 = this.objectModelIDs[i2];
				if (flag1) {
					l2 += 0x10000;
				}
				model = (Model) ObjectDef.modelCache.insertFromCache(l2);
				if (model == null) {
					model = Model.method462(l2 & 0xffff);
					if (model == null) {
						return null;
					}
					if (flag1) {
						model.method477();
					}
					ObjectDef.modelCache.removeFromCache(model, l2);
				}
				if (k1 > 1) {
					ObjectDef.aModelArray741s[i2] = model;
				}
			}
			if (k1 > 1) {
				model = new Model(k1, ObjectDef.aModelArray741s);
			}
		} else {
			int i1 = -1;
			for (int j1 = 0; j1 < this.anIntArray776.length; j1++) {
				if (this.anIntArray776[j1] != j) {
					continue;
				}
				i1 = j1;
				break;
			}
			if (i1 == -1) {
				return null;
			}
			l1 = ((this.type << 6) + (i1 << 3) + l) + ((long) (k + 1) << 32);
			Model model_2 = (Model) ObjectDef.modelCache2.insertFromCache(l1);
			if (model_2 != null) {
				return model_2;
			}
			int j2 = this.objectModelIDs[i1];
			boolean flag3 = this.aBoolean751 ^ (l > 3);
			if (flag3) {
				j2 += 0x10000;
			}
			model = (Model) ObjectDef.modelCache.insertFromCache(j2);
			if (model == null) {
				model = Model.method462(j2 & 0xffff);
				if (model == null) {
					return null;
				}
				if (flag3) {
					model.method477();
				}
				ObjectDef.modelCache.removeFromCache(model, j2);
			}
		}
		boolean flag;
		flag = (this.modelSizeX != 128) || (this.modelSizeH != 128) || (this.modelSizeY != 128);
		boolean flag2;
		flag2 = (this.offsetX != 0) || (this.offsetH != 0) || (this.offsetY != 0);
		Model model_3 = new Model(this.modifiedModelColors == null, Animation.method532(k), (l == 0) && (k == -1) && !flag && !flag2, model);
		if (k != -1) {
			model_3.method469();
			model_3.method470(k);
			model_3.triangleSkin = null;
			model_3.vertexSkin = null;
		}
		while (l-- > 0) {
			model_3.method473();
		}
		if (this.modifiedModelColors != null) {
			for (int k2 = 0; k2 < this.modifiedModelColors.length; k2++) {
				model_3.method476(this.modifiedModelColors[k2], this.originalModelColors[k2]);
			}
		}
		if (flag) {
			model_3.method478(this.modelSizeX, this.modelSizeY, this.modelSizeH);
		}
		if (flag2) {
			model_3.method475(this.offsetX, this.offsetH, this.offsetY);
		}
		model_3.method479(64 + this.brightness, 768 + (this.contrast * 5), -50, -10, -50, !this.nonFlatShading);
		if (this.anInt760 == 1) {
			model_3.anInt1654 = model_3.modelHeight;
		}
		ObjectDef.modelCache2.removeFromCache(model_3, l1);
		return model_3;
	}

	private void readValues(Packet packet) {
		int i = -1;
		label0:
			do {
				int j;
				do {
					j = packet.getUnsignedByte();
					if (j == 0) {
						break label0;
					}
					if (j == 1) {
						int k = packet.getUnsignedByte();
						if (k > 0) {
							if ((this.objectModelIDs == null) || ObjectDef.lowMem) {
								this.anIntArray776 = new int[k];
								this.objectModelIDs = new int[k];
								for (int k1 = 0; k1 < k; k1++) {
									this.objectModelIDs[k1] = packet.getUnsignedShort();
									this.anIntArray776[k1] = packet.getUnsignedByte();
								}
							} else {
								int position = packet.getPosition();
								position = position + (k * 3);
							}
						}
					} else if (j == 2) {
						this.name = packet.getString();
					} else if (j == 3) {
						this.description = packet.getBytes();
					} else if (j == 5) {
						int l = packet.getUnsignedByte();
						if (l > 0) {
							if ((this.objectModelIDs == null) || ObjectDef.lowMem) {
								this.anIntArray776 = null;
								this.objectModelIDs = new int[l];
								for (int l1 = 0; l1 < l; l1++) {
									this.objectModelIDs[l1] = packet.getUnsignedShort();
								}
							} else {
								int position = packet.getPosition();
								position = position + (l * 2);
							}
						}
					} else if (j == 14) {
						this.sizeX = packet.getUnsignedByte();
					} else if (j == 15) {
						this.sizeY = packet.getUnsignedByte();
					} else if (j == 17) {
						this.isUnwalkable = false;
					} else if (j == 18) {
						this.aBoolean757 = false;
					} else if (j == 19) {
						i = packet.getUnsignedByte();
						if (i == 1) {
							this.hasActions = true;
						}
					} else if (j == 21) {
						this.isModelSolid = true;
					} else if (j == 22) {
						this.nonFlatShading = true;
					} else if (j == 23) {
						this.aBoolean764 = true;
					} else if (j == 24) {
						this.animationID = packet.getUnsignedShort();
						if (this.animationID == 65535) {
							this.animationID = -1;
						}
					} else if (j == 28) {
						this.anInt775 = packet.getUnsignedByte();
					} else if (j == 29) {
						this.brightness = packet.getByte();
					} else if (j == 39) {
						this.contrast = packet.getByte();
					} else if ((j >= 30) && (j < 39)) {
						if (this.actions == null) {
							this.actions = new String[5];
						}
						this.actions[j - 30] = packet.getString();
						if (this.actions[j - 30].equalsIgnoreCase("hidden")) {
							this.actions[j - 30] = null;
						}
					} else if(j == 40) {
						int i1 = packet.getUnsignedByte();
						this.modifiedModelColors = new int[i1];
						this.originalModelColors = new int[i1];
						for (int i2 = 0; i2 < i1; i2++) {
							this.modifiedModelColors[i2] = packet.getUnsignedShort();
							this.originalModelColors[i2] = packet.getUnsignedShort();
						}
					} else if (j == 60) {
						this.mapFunctionID = packet.getUnsignedShort();
					} else if (j == 62) {
						this.aBoolean751 = true;
					} else if (j == 64) {
						this.aBoolean779 = false;
					} else if (j == 65) {
						this.modelSizeX = packet.getUnsignedShort();
					} else if (j == 66) {
						this.modelSizeH = packet.getUnsignedShort();
					} else if (j == 67) {
						this.modelSizeY = packet.getUnsignedShort();
					} else if (j == 68) {
						this.mapSceneID = packet.getUnsignedShort();
					} else if (j == 69) {
						this.anInt768 = packet.getUnsignedByte();
					} else if (j == 70) {
						this.offsetX = packet.getShort();
					} else if (j == 71) {
						this.offsetH = packet.getShort();
					} else if (j == 72) {
						this.offsetY = packet.getShort();
					} else if (j == 73) {
						this.aBoolean736 = true;
					} else if (j == 74) {
						this.isSolidObject = true;
					} else {
						if (j != 75) {
							continue;
						}
						this.anInt760 = packet.getUnsignedByte();
					}
					continue label0;
				} while (j != 77);
				this.configID1 = packet.getUnsignedShort();
				if (this.configID1 == 65535) {
					this.configID1 = -1;
				}
				this.configID = packet.getUnsignedShort();
				if (this.configID == 65535) {
					this.configID = -1;
				}
				int j1 = packet.getUnsignedByte();
				this.childrenIDs = new int[j1 + 1];
				for (int j2 = 0; j2 <= j1; j2++) {
					this.childrenIDs[j2] = packet.getUnsignedShort();
					if (this.childrenIDs[j2] == 65535) {
						this.childrenIDs[j2] = -1;
					}
				}
			} while (true);
		if (i == -1) {
			this.hasActions = (this.objectModelIDs != null) && ((this.anIntArray776 == null) || (this.anIntArray776[0] == 10));
			if (this.actions != null) {
				this.hasActions = true;
			}
		}
		if (this.isSolidObject) {
			this.isUnwalkable = false;
			this.aBoolean757 = false;
		}
		if (this.anInt760 == -1) {
			this.anInt760 = this.isUnwalkable ? 1 : 0;
		}
	}

	private ObjectDef() {
		this.type = -1;
	}

	public boolean aBoolean736;
	private byte brightness;
	private int offsetX;
	public String name;
	private int modelSizeY;
	private static Model[] aModelArray741s = new Model[4];
	private byte contrast;
	public int sizeX;
	private int offsetH;
	public int mapFunctionID;
	private int[] originalModelColors;
	private int modelSizeX;
	public int configID;
	private boolean aBoolean751;
	public static boolean lowMem;
	private static Packet packet;
	public int type;
	private static int[] streamIndices;
	public boolean aBoolean757;
	public int mapSceneID;
	public int childrenIDs[];
	private int anInt760;
	public int sizeY;
	public boolean isModelSolid;
	public boolean aBoolean764;
	public static Client clientInstance;
	private boolean isSolidObject;
	public boolean isUnwalkable;
	public int anInt768;
	private boolean nonFlatShading;
	private static int cacheIndex;
	private int modelSizeH;
	private int[] objectModelIDs;
	public int configID1;
	public int anInt775;
	private int[] anIntArray776;
	public byte description[];
	public boolean hasActions;
	public boolean aBoolean779;
	public static MemoryCache modelCache2 = new MemoryCache(30);
	public int animationID;
	private static ObjectDef[] cache;
	private int offsetY;
	private int[] modifiedModelColors;
	public static MemoryCache modelCache = new MemoryCache(500);
	public String actions[];
}