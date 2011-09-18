package com.netty.stuff;

import com.netty.net.packet.Packet;

public class Animation {

	public static void method528(int i) {
		Animation.aClass36Array635 = new Animation[i + 1];
		Animation.aBooleanArray643 = new boolean[i + 1];
		for (int j = 0; j < (i + 1); j++) {
			Animation.aBooleanArray643[j] = true;
		}
	}

	public static void method529(byte abyte0[]) {
		Packet packet = new Packet(abyte0);
		packet.setPosition(abyte0.length - 8);
		int i = packet.getUnsignedShort();
		int j = packet.getUnsignedShort();
		int k = packet.getUnsignedShort();
		int l = packet.getUnsignedShort();
		int i1 = 0;
		Packet stream_1 = new Packet(abyte0);
		stream_1.setPosition(i1);
		i1 += i + 2;
		Packet stream_2 = new Packet(abyte0);
		stream_2.setPosition(i1);
		i1 += j;
		Packet stream_3 = new Packet(abyte0);
		stream_3.setPosition(i1);
		i1 += k;
		Packet stream_4 = new Packet(abyte0);
		stream_4.setPosition(i1);
		i1 += l;
		Packet stream_5 = new Packet(abyte0);
		stream_5.setPosition(i1);
		ModelTransform modelTransform = new ModelTransform(stream_5);
		int k1 = stream_1.getUnsignedShort();
		int ai[] = new int[500];
		int ai1[] = new int[500];
		int ai2[] = new int[500];
		int ai3[] = new int[500];
		for (int l1 = 0; l1 < k1; l1++) {
			int i2 = stream_1.getUnsignedShort();
			Animation animation = Animation.aClass36Array635[i2] = new Animation();
			animation.displayLength = stream_4.getUnsignedByte();
			animation.myModelTransform = modelTransform;
			int j2 = stream_1.getUnsignedByte();
			int k2 = -1;
			int l2 = 0;
			for (int i3 = 0; i3 < j2; i3++) {
				int j3 = stream_2.getUnsignedByte();
				if (j3 > 0) {
					if (modelTransform.opcodes[i3] != 0) {
						for (int l3 = i3 - 1; l3 > k2; l3--) {
							if (modelTransform.opcodes[l3] != 0) {
								continue;
							}
							ai[l2] = l3;
							ai1[l2] = 0;
							ai2[l2] = 0;
							ai3[l2] = 0;
							l2++;
							break;
						}
					}
					ai[l2] = i3;
					char c = '\0';
					if (modelTransform.opcodes[i3] == 3) {
						c = '\200';
					}
					if ((j3 & 1) != 0) {
						ai1[l2] = stream_3.method421();
					} else {
						ai1[l2] = c;
					}
					if ((j3 & 2) != 0) {
						ai2[l2] = stream_3.method421();
					} else {
						ai2[l2] = c;
					}
					if ((j3 & 4) != 0) {
						ai3[l2] = stream_3.method421();
					} else {
						ai3[l2] = c;
					}
					k2 = i3;
					l2++;
					if(modelTransform.opcodes[i3] == 5) {
						Animation.aBooleanArray643[i2] = false;
					}
				}
			}
			animation.stepCount = l2;
			animation.opcodeLinkTable = new int[l2];
			animation.modifier1 = new int[l2];
			animation.modifier2 = new int[l2];
			animation.modifier3 = new int[l2];
			for (int k3 = 0; k3 < l2; k3++) {
				animation.opcodeLinkTable[k3] = ai[k3];
				animation.modifier1[k3] = ai1[k3];
				animation.modifier2[k3] = ai2[k3];
				animation.modifier3[k3] = ai3[k3];
			}
		}
	}

	public static void nullLoader() {
		Animation.aClass36Array635 = null;
	}

	public static Animation method531(int j) {
		if (Animation.aClass36Array635 == null) {
			return null;
		}
		return Animation.aClass36Array635[j];
	}

	public static boolean method532(int i) {
		return i == -1;
	}

	private Animation() {}

	private static Animation[] aClass36Array635;
	public int displayLength;
	public ModelTransform myModelTransform;
	public int stepCount;
	public int opcodeLinkTable[];
	public int modifier1[];
	public int modifier2[];
	public int modifier3[];
	private static boolean[] aBooleanArray643;
}