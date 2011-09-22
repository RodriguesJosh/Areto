package com.netty.stuff;

import com.netty.net.packet.Packet;

public class SoundTrack {

	public static void method166() {
		SoundTrack.noise = new int[32768];
		for (int i = 0; i < 32768; i++) {
			if (Math.random() > 0.5D) {
				SoundTrack.noise[i] = 1;
			} else {
				SoundTrack.noise[i] = -1;
			}
		}
		SoundTrack.sineTable = new int[32768];
		for (int j = 0; j < 32768; j++) {
			SoundTrack.sineTable[j] = (int)(Math.sin(j / 5215.1903000000002D) * 16384D);
		}
		SoundTrack.sampleBuffer = new int[0x35d54];
	}

	public int[] method167(int i, int j) {
		for (int k = 0; k < i; k++) {
			SoundTrack.sampleBuffer[k] = 0;
		}
		if (j < 10) {
			return SoundTrack.sampleBuffer;
		}
		double d = i / (j + 0.0D);
		this.samp1.resetValues();
		this.samp2.resetValues();
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		if (this.samp3 != null) {
			this.samp3.resetValues();
			this.samp4.resetValues();
			l = (int) (((this.samp3.anInt539 - this.samp3.anInt538) * 32.768000000000001D) / d);
			i1 = (int) ((this.samp3.anInt538 * 32.768000000000001D) / d);
		}
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		if (this.samp5 != null) {
			this.samp5.resetValues();
			this.samp6.resetValues();
			k1 = (int) (((this.samp5.anInt539 - this.samp5.anInt538) * 32.768000000000001D) / d);
			l1 = (int) ((this.samp5.anInt538 * 32.768000000000001D) / d);
		}
		for (int j2 = 0; j2 < 5; j2++) {
			if (this.anIntArray106[j2] != 0) {
				SoundTrack.phase[j2] = 0;
				SoundTrack.anIntArray119[j2] = (int) (this.anIntArray108[j2] * d);
				SoundTrack.anIntArray120[j2] = (this.anIntArray106[j2] << 14) / 100;
				SoundTrack.anIntArray121[j2] = (int) (((this.samp1.anInt539 - this.samp1.anInt538) * 32.768000000000001D * Math.pow(1.0057929410678534D, this.anIntArray107[j2])) / d);
				SoundTrack.anIntArray122[j2] = (int) ((this.samp1.anInt538 * 32.768000000000001D) / d);
			}
		}
		for (int k2 = 0; k2 < i; k2++) {
			int l2 = this.samp1.method328(i);
			int j4 = this.samp2.method328(i);
			if (this.samp3 != null) {
				int j5 = this.samp3.method328(i);
				int j6 = this.samp4.method328(i);
				l2 += this.method168(j6, j1, this.samp3.form) >> 1;
		j1 += ((j5 * l) >> 16) + i1;
			}
			if (this.samp5 != null) {
				int k5 = this.samp5.method328(i);
				int k6 = this.samp6.method328(i);
				j4 = (j4 * ((this.method168(k6, i2, this.samp5.form) >> 1) + 32768)) >> 15;
		i2 += ((k5 * k1) >> 16) + l1;
			}
			for (int l5 = 0; l5 < 5; l5++) {
				if (this.anIntArray106[l5] != 0) {
					int l6 = k2 + SoundTrack.anIntArray119[l5];
					if (l6 < i) {
						SoundTrack.sampleBuffer[l6] += this.method168((j4 * SoundTrack.anIntArray120[l5]) >> 15, SoundTrack.phase[l5], this.samp1.form);
						SoundTrack.phase[l5] += ((l2 * SoundTrack.anIntArray121[l5]) >> 16) + SoundTrack.anIntArray122[l5];
					}
				}
			}
		}
		if (this.aClass29_104 != null) {
			this.aClass29_104.resetValues();
			this.aClass29_105.resetValues();
			int i3 = 0;
			boolean flag1 = true;
			for (int i7 = 0; i7 < i; i7++) {
				int k7 = this.aClass29_104.method328(i);
				int i8 = this.aClass29_105.method328(i);
				int k4;
				if (flag1) {
					k4 = this.aClass29_104.anInt538 + (((this.aClass29_104.anInt539 - this.aClass29_104.anInt538) * k7) >> 8);
				} else {
					k4 = this.aClass29_104.anInt538 + (((this.aClass29_104.anInt539 - this.aClass29_104.anInt538) * i8) >> 8);
				}
				if ((i3 += 256) >= k4) {
					i3 = 0;
					flag1 = !flag1;
				}
				if (flag1) {
					SoundTrack.sampleBuffer[i7] = 0;
				}
			}
		}
		if ((this.anInt109 > 0) && (this.gain > 0)) {
			int j3 = (int)(this.anInt109 * d);
			for (int l4 = j3; l4 < i; l4++) {
				SoundTrack.sampleBuffer[l4] += (SoundTrack.sampleBuffer[l4 - j3] * this.gain) / 100;
			}
		}
		if ((this.aClass39_111.anIntArray665[0] > 0) || (this.aClass39_111.anIntArray665[1] > 0)) {
			this.aClass29_112.resetValues();
			int k3 = this.aClass29_112.method328(i + 1);
			int i5 = this.aClass39_111.method544(0, k3 / 65536F);
			int i6 = this.aClass39_111.method544(1, k3 / 65536F);
			if (i >= (i5 + i6)) {
				int j7 = 0;
				int l7 = i6;
				if (l7 > (i - i5)) {
					l7 = i - i5;
				}
				for (; j7 < l7; j7++) {
					int j8 = (int) (((long) SoundTrack.sampleBuffer[j7 + i5] * FrequencyGenerator.anInt672) >> 16);
					for (int k8 = 0; k8 < i5; k8++) {
						j8 += (int) (((long) SoundTrack.sampleBuffer[(j7 + i5) - 1 - k8] * FrequencyGenerator.anIntArrayArray670[0][k8]) >> 16);
					}
					for (int j9 = 0; j9 < j7; j9++) {
						j8 -= (int) (((long) SoundTrack.sampleBuffer[j7 - 1 - j9] * FrequencyGenerator.anIntArrayArray670[1][j9]) >> 16);
					}
					SoundTrack.sampleBuffer[j7] = j8;
					k3 = this.aClass29_112.method328(i + 1);
				}
				char c = '\200';
				l7 = c;
				do {
					if (l7 > (i - i5)) {
						l7 = i - i5;
					}
					for (; j7 < l7; j7++) {
						int l8 = (int) (((long) SoundTrack.sampleBuffer[j7 + i5] * FrequencyGenerator.anInt672) >> 16);
						for (int k9 = 0; k9 < i5; k9++) {
							l8 += (int) (((long) SoundTrack.sampleBuffer[(j7 + i5) - 1 - k9] * FrequencyGenerator.anIntArrayArray670[0][k9]) >> 16);
						}
						for (int i10 = 0; i10 < i6; i10++) {
							l8 -= (int) (((long) SoundTrack.sampleBuffer[j7 - 1 - i10] * FrequencyGenerator.anIntArrayArray670[1][i10]) >> 16);
						}
						SoundTrack.sampleBuffer[j7] = l8;
						k3 = this.aClass29_112.method328(i + 1);
					}
					if (j7 >= (i - i5)) {
						break;
					}
					i5 = this.aClass39_111.method544(0, k3 / 65536F);
					i6 = this.aClass39_111.method544(1, k3 / 65536F);
					l7 += c;
				} while (true);
				for (; j7 < i; j7++) {
					int i9 = 0;
					for(int l9 = (j7 + i5) - i; l9 < i5; l9++) {
						i9 += (int) (((long)SoundTrack.sampleBuffer[(j7 + i5) - 1 - l9] * FrequencyGenerator.anIntArrayArray670[0][l9]) >> 16);
					}

					for (int j10 = 0; j10 < i6; j10++) {
						i9 -= (int) (((long)SoundTrack.sampleBuffer[j7 - 1 - j10] * FrequencyGenerator.anIntArrayArray670[1][j10]) >> 16);
					}
					SoundTrack.sampleBuffer[j7] = i9;
				}
			}
		}
		for (int i4 = 0; i4 < i; i4++) {
			if (SoundTrack.sampleBuffer[i4] < -32768) {
				SoundTrack.sampleBuffer[i4] = -32768;
			}
			if (SoundTrack.sampleBuffer[i4] > 32767) {
				SoundTrack.sampleBuffer[i4] = 32767;
			}
		}
		return SoundTrack.sampleBuffer;
	}

	private int method168(int i, int k, int l) {
		if (l == 1) {
			if ((k & 0x7fff) < 16384) {
				return i;
			} else {
				return -i;
			}
		}
		if (l == 2) {
			return (SoundTrack.sineTable[k & 0x7fff] * i) >> 14;
		}
		if (l == 3) {
			return (((k & 0x7fff) * i) >> 14) - i;
		}
		if (l == 4) {
			return SoundTrack.noise[(k / 2607) & 0x7fff] * i;
		} else {
			return 0;
		}
	}

	public void method169(Packet packet) {
		this.samp1 = new AmplitudeEnvelope();
		this.samp1.method325(packet);
		this.samp2 = new AmplitudeEnvelope();
		this.samp2.method325(packet);
		int i = packet.getUnsignedByte();
		int position = packet.getPosition();
		if (i != 0) {
			position--;
			this.samp3 = new AmplitudeEnvelope();
			this.samp3.method325(packet);
			this.samp4 = new AmplitudeEnvelope();
			this.samp4.method325(packet);
		}
		i = packet.getUnsignedByte();
		if (i != 0) {
			position--;
			this.samp5 = new AmplitudeEnvelope();
			this.samp5.method325(packet);
			this.samp6 = new AmplitudeEnvelope();
			this.samp6.method325(packet);
		}
		i = packet.getUnsignedByte();
		if (i != 0) {
			position--;
			this.aClass29_104 = new AmplitudeEnvelope();
			this.aClass29_104.method325(packet);
			this.aClass29_105 = new AmplitudeEnvelope();
			this.aClass29_105.method325(packet);
		}
		for (int j = 0; j < 10; j++) {
			int k = packet.method422();
			if (k == 0) {
				break;
			}
			this.anIntArray106[j] = k;
			this.anIntArray107[j] = packet.method421();
			this.anIntArray108[j] = packet.method422();
		}
		this.anInt109 = packet.method422();
		this.gain = packet.method422();
		this.msLength = packet.getUnsignedShort();
		this.anInt114 = packet.getUnsignedShort();
		this.aClass39_111 = new FrequencyGenerator();
		this.aClass29_112 = new AmplitudeEnvelope();
		this.aClass39_111.method545(packet, this.aClass29_112);
	}

	public SoundTrack() {
		this.anIntArray106 = new int[5];
		this.anIntArray107 = new int[5];
		this.anIntArray108 = new int[5];
		this.gain = 100;
		this.msLength = 500;
	}

	private AmplitudeEnvelope samp1;
	private AmplitudeEnvelope samp2;
	private AmplitudeEnvelope samp3;
	private AmplitudeEnvelope samp4;
	private AmplitudeEnvelope samp5;
	private AmplitudeEnvelope samp6;
	private AmplitudeEnvelope aClass29_104;
	private AmplitudeEnvelope aClass29_105;
	private int[] anIntArray106;
	private int[] anIntArray107;
	private int[] anIntArray108;
	private int anInt109;
	private int gain;
	private FrequencyGenerator aClass39_111;
	private AmplitudeEnvelope aClass29_112;
	int msLength;
	int anInt114;
	private static int[] sampleBuffer;
	private static int[] noise;
	private static int[] sineTable;
	private static int[] phase = new int[5];
	private static int[] anIntArray119 = new int[5];
	private static int[] anIntArray120 = new int[5];
	private static int[] anIntArray121 = new int[5];
	private static int[] anIntArray122 = new int[5];
}