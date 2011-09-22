package com.netty.game.model.entity.player;

import com.netty.game.model.Model;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class IdentityKit {

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet packet = new Packet(jagexArchive.getDataForName("idk.dat"));
		IdentityKit.length = packet.getUnsignedShort();
		if (IdentityKit.cache == null) {
			IdentityKit.cache = new IdentityKit[IdentityKit.length];
		}
		for (int j = 0; j < IdentityKit.length; j++) {
			if (IdentityKit.cache[j] == null) {
				IdentityKit.cache[j] = new IdentityKit();
			}
			IdentityKit.cache[j].readValues(packet);
		}
	}

	private void readValues(Packet packet) {
		do {
			int i = packet.getUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				this.bodyPartID = packet.getUnsignedByte();
			} else if (i == 2) {
				int j = packet.getUnsignedByte();
				this.bodyModelIDs = new int[j];
				for (int k = 0; k < j; k++) {
					this.bodyModelIDs[k] = packet.getUnsignedShort();
				}

			} else if (i == 3) {
				this.notSelectable = true;
			} else if ((i >= 40) && (i < 50)) {
				this.recolourOriginal[i - 40] = packet.getUnsignedShort();
			} else if ((i >= 50) && (i < 60)) {
				this.recolourTarget[i - 50] = packet.getUnsignedShort();
			} else if ((i >= 60) && (i < 70)) {
				this.headModelIDs [i - 60] = packet.getUnsignedShort();
			} else {
				System.out.println("Error unrecognised config code: " + i);
			}
		} while (true);
	}

	public boolean isBodyDownloaded() {
		if (this.bodyModelIDs == null) {
			return true;
		}
		boolean flag = true;
		for (int j = 0; j < this.bodyModelIDs.length; j++) {
			if (!Model.method463(this.bodyModelIDs[j])) {
				flag = false;
			}
		}
		return flag;
	}

	public Model getBodyModel() {
		if (this.bodyModelIDs == null) {
			return null;
		}
		Model aclass30_sub2_sub4_sub6s[] = new Model[this.bodyModelIDs.length];
		for (int i = 0; i < this.bodyModelIDs.length; i++) {
			aclass30_sub2_sub4_sub6s[i] = Model.method462(this.bodyModelIDs[i]);
		}
		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1) {
			model = aclass30_sub2_sub4_sub6s[0];
		} else {
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
		}
		for (int j = 0; j < 6; j++) {
			if (this.recolourOriginal[j] == 0) {
				break;
			}
			model.method476(this.recolourOriginal[j], this.recolourTarget[j]);
		}
		return model;
	}

	public boolean isHeadDownloaded() {
		boolean flag1 = true;
		for (int i = 0; i < 5; i++) {
			if ((this.headModelIDs [i] != -1) && !Model.method463(this.headModelIDs [i])) {
				flag1 = false;
			}
		}
		return flag1;
	}

	public Model getHeadModel() {
		Model aclass30_sub2_sub4_sub6s[] = new Model[5];
		int j = 0;
		for (int k = 0; k < 5; k++) {
			if (this.headModelIDs [k] != -1) {
				aclass30_sub2_sub4_sub6s[j++] = Model.method462(this.headModelIDs [k]);
			}
		}
		Model model = new Model(j, aclass30_sub2_sub4_sub6s);
		for (int l = 0; l < 6; l++) {
			if (this.recolourOriginal[l] == 0) {
				break;
			}
			model.method476(this.recolourOriginal[l], this.recolourTarget[l]);
		}
		return model;
	}

	private IdentityKit() {
		this.bodyPartID = -1;
		this.recolourOriginal = new int[6];
		this.recolourTarget = new int[6];
		this.notSelectable = false;
	}

	public static int length;
	public static IdentityKit cache[];
	public int bodyPartID;
	private int[] bodyModelIDs;
	private int[] recolourOriginal;
	private int[] recolourTarget;
	private int[] headModelIDs  = {
			-1, -1, -1, -1, -1
	};
	public boolean notSelectable;
}