package com.netty.stuff;

import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class Sequence {

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet packet = new Packet(jagexArchive.getDataForName("seq.dat"));
		int length = packet.getUnsignedShort();
		if (Sequence.anims == null) {
			Sequence.anims = new Sequence[length];
		}
		for (int j = 0; j < length; j++) {
			if (Sequence.anims[j] == null) {
				Sequence.anims[j] = new Sequence();
			}
			Sequence.anims[j].readValues(packet);
		}
	}

	public int method258(int i) {
		int j = this.frameLengths[i];
		if (j == 0) {
			Animation animation = Animation.method531(this.frame2IDS[i]);
			if (animation != null) {
				j = this.frameLengths[i] = animation.displayLength;
			}
		}
		if (j == 0) {
			j = 1;
		}
		return j;
	}

	private void readValues(Packet packet) {
		do {
			int i = packet.getUnsignedByte();
			if (i == 0) {
				break;
			}
			if (i == 1) {
				this.frameCount = packet.getUnsignedByte();
				this.frame2IDS = new int[this.frameCount];
				this.frame1IDS = new int[this.frameCount];
				this.frameLengths = new int[this.frameCount];
				for (int j = 0; j < this.frameCount; j++) {
					this.frame2IDS[j] = packet.getUnsignedShort();
					this.frame1IDS[j] = packet.getUnsignedShort();
					if (this.frame1IDS[j] == 65535) {
						this.frame1IDS[j] = -1;
					}
					this.frameLengths[j] = packet.getUnsignedShort();
				}
			} else if (i == 2) {
				this.frameStep = packet.getUnsignedShort();
			} else if (i == 3) {
				int k = packet.getUnsignedByte();
				this.animationFlowControl = new int[k + 1];
				for (int l = 0; l < k; l++) {
					this.animationFlowControl[l] = packet.getUnsignedByte();
				}
				this.animationFlowControl[k] = 0x98967f;
			} else if (i == 4) {
				this.aBoolean358 = true;
			} else if (i == 5) {
				this.anInt359 = packet.getUnsignedByte();
			} else if (i == 6) {
				this.anInt360 = packet.getUnsignedShort();
			} else if (i == 7) {
				this.anInt361 = packet.getUnsignedShort();
			} else if (i == 8) {
				this.anInt362 = packet.getUnsignedByte();
			} else if (i == 9) {
				this.anInt363 = packet.getUnsignedByte();
			} else if (i == 10) {
				this.priority = packet.getUnsignedByte();
			} else if (i == 11) {
				this.anInt365 = packet.getUnsignedByte();
			} else if (i == 12) {
				packet.getInt();
			} else {
				System.out.println("Error unrecognised seq config code: " + i);
			}
		} while (true);
		if (this.frameCount == 0) {
			this.frameCount = 1;
			this.frame2IDS = new int[1];
			this.frame2IDS[0] = -1;
			this.frame1IDS = new int[1];
			this.frame1IDS[0] = -1;
			this.frameLengths = new int[1];
			this.frameLengths[0] = -1;
		}
		if (this.anInt363 == -1) {
			if (this.animationFlowControl != null) {
				this.anInt363 = 2;
			} else {
				this.anInt363 = 0;
			}
		}
		if (this.priority == -1) {
			if (this.animationFlowControl != null) {
				this.priority = 2;
				return;
			}
			this.priority = 0;
		}
	}

	private Sequence() {
		this.frameStep = -1;
		this.aBoolean358 = false;
		this.anInt359 = 5;
		this.anInt360 = -1;
		this.anInt361 = -1;
		this.anInt362 = 99;
		this.anInt363 = -1;
		this.priority = -1;
		this.anInt365 = 2;
	}

	public static Sequence anims[];
	public int frameCount;
	public int frame2IDS[];
	public int frame1IDS[];
	private int[] frameLengths;
	public int frameStep;
	public int animationFlowControl[];
	public boolean aBoolean358;
	public int anInt359;
	public int anInt360;
	public int anInt361;
	public int anInt362;
	public int anInt363;
	public int priority;
	public int anInt365;
	public static int anInt367;
}