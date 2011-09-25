package com.netty.stuff;

import com.netty.game.model.Model;
import com.netty.net.cache.MemoryCache;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class SpotAnim {

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet packet = new Packet(jagexArchive.getDataForName("spotanim.dat"));
		int length = packet.getUnsignedShort();
		if (SpotAnim.cache == null) {
			SpotAnim.cache = new SpotAnim[length];
		}
		for (int j = 0; j < length; j++) {
			if (SpotAnim.cache[j] == null) {
				SpotAnim.cache[j] = new SpotAnim();
			}
			SpotAnim.cache[j].id = j;
			SpotAnim.cache[j].readValues(packet);
		}
	}

	private void readValues(Packet packet) {
		do {
			int i = packet.getUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				this.modelID = packet.getUnsignedShort();
			} else if (i == 2) {
				this.animationID = packet.getUnsignedShort();
				if (Sequence.anims != null) {
					this.animationSequence = Sequence.anims[this.animationID];
				}
			} else if (i == 4) {
				this.resizeXY = packet.getUnsignedShort();
			} else if (i == 5) {
				this.resizeZ = packet.getUnsignedShort();
			} else if (i == 6) {
				this.rotation = packet.getUnsignedShort();
			} else if (i == 7) {
				this.modelBrightness = packet.getUnsignedByte();
			} else if (i == 8) {
				this.modelShadow = packet.getUnsignedByte();
			} else if ((i >= 40) && (i < 50)) {
				this.originalModelColours[i - 40] = packet.getUnsignedShort();
			} else if ((i >= 50) && (i < 60)) {
				this.modifiedModelColours[i - 50] = packet.getUnsignedShort();
			} else {
				System.out.println("Error unrecognised spotanim config code: " + i);
			}
		} while (true);
	}

	public Model getModel() {
		Model model = (Model) SpotAnim.memoryCache.insertFromCache(this.id);
		if (model != null) {
			return model;
		}
		model = Model.method462(this.modelID);
		if (model == null) {
			return null;
		}
		for (int i = 0; i < 6; i++) {
			if (this.originalModelColours[0] != 0) {
				model.method476(this.originalModelColours[i], this.modifiedModelColours[i]);
			}
		}
		SpotAnim.memoryCache.removeFromCache(model, this.id);
		return model;
	}

	private SpotAnim() {
		this.anInt400 = 9;
		this.animationID = -1;
		this.originalModelColours = new int[6];
		this.modifiedModelColours = new int[6];
		this.resizeXY = 128;
		this.resizeZ = 128;
	}

	@SuppressWarnings("unused")
	private int anInt400;
	public static SpotAnim cache[];
	private int id;
	private int modelID;
	private int animationID;
	public Sequence animationSequence;
	private int[] originalModelColours;
	private int[] modifiedModelColours;
	public int resizeXY;
	public int resizeZ;
	public int rotation;
	public int modelBrightness;
	public int modelShadow;
	public static MemoryCache memoryCache = new MemoryCache(30);
}