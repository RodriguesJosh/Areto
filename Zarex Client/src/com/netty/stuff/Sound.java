package com.netty.stuff;

import com.netty.net.packet.Packet;

public class Sound {

	private Sound() {
		this.aClass6Array329 = new SoundTrack[10];
	}

	public static void unpack(Packet packet) {
		Sound.waveGenerationBuffer = new byte[0x6baa8];
		Sound.waveGenerationPacket = new Packet(Sound.waveGenerationBuffer);
		SoundTrack.method166();
		do {
			int j = packet.getUnsignedShort();
			if (j == 65535) {
				return;
			}
			Sound.soundGeneratorList[j] = new Sound();
			Sound.soundGeneratorList[j].method242(packet);
			Sound.anIntArray326[j] = Sound.soundGeneratorList[j].method243();
		} while (true);
	}

	public static Packet method241(int i, int j) {
		if(Sound.soundGeneratorList[j] != null) {
			Sound sound = Sound.soundGeneratorList[j];
			return sound.method244(i);
		}
		return null;
	}

	private void method242(Packet packet) {
		for (int i = 0; i < 10; i++) {
			int j = packet.getUnsignedByte();
			int position = packet.getPosition();
			if (j != 0) {
				position--;
				this.aClass6Array329[i] = new SoundTrack();
				this.aClass6Array329[i].method169(packet);
			}
		}
		this.anInt330 = packet.getUnsignedShort();
		this.anInt331 = packet.getUnsignedShort();
	}

	private int method243() {
		int j = 0x98967f;
		for (int k = 0; k < 10; k++) {
			if ((this.aClass6Array329[k] != null) && ((this.aClass6Array329[k].anInt114 / 20) < j)) {
				j = this.aClass6Array329[k].anInt114 / 20;
			}
		}
		if ((this.anInt330 < this.anInt331) && ((this.anInt330 / 20) < j)) {
			j = this.anInt330 / 20;
		}
		if ((j == 0x98967f) || (j == 0)) {
			return 0;
		}
		for (int l = 0; l < 10; l++) {
			if (this.aClass6Array329[l] != null) {
				this.aClass6Array329[l].anInt114 -= j * 20;
			}
		}
		if (this.anInt330 < this.anInt331) {
			this.anInt330 -= j * 20;
			this.anInt331 -= j * 20;
		}
		return j;
	}

	private Packet method244(int i) {
		int k = this.method245(i);
		Sound.waveGenerationPacket.setPosition(0);
		// Sound.waveGenerationPacket.putInt(0x52494646);
		// Sound.waveGenerationPacket.method403(36 + k);
		// Sound.waveGenerationPacket.putInt(0x57415645);
		// Sound.waveGenerationPacket.putInt(0x666d7420);
		// Sound.waveGenerationPacket.method403(16);
		// Sound.waveGenerationPacket.method400(1);
		// Sound.waveGenerationPacket.method400(1);
		// Sound.waveGenerationPacket.method403(22050);
		// Sound.waveGenerationPacket.method403(22050);
		// Sound.waveGenerationPacket.method400(1);
		// Sound.waveGenerationPacket.method400(8);
		// Sound.waveGenerationPacket.putInt(0x64617461);
		// Sound.waveGenerationPacket.method403(k);
		int position = Sound.waveGenerationPacket.getPosition();
		position = position + k;
		return Sound.waveGenerationPacket;
	}

	private int method245(int i) {
		int j = 0;
		for (int k = 0; k < 10; k++) {
			if ((this.aClass6Array329[k] != null) && ((this.aClass6Array329[k].msLength + this.aClass6Array329[k].anInt114) > j)) {
				j = this.aClass6Array329[k].msLength + this.aClass6Array329[k].anInt114;
			}
		}
		if (j == 0) {
			return 0;
		}
		int l = (22050 * j) / 1000;
		int i1 = (22050 * this.anInt330) / 1000;
		int j1 = (22050 * this.anInt331) / 1000;
		if ((i1 < 0) || (i1 > l) || (j1 < 0) || (j1 > l) || (i1 >= j1)) {
			i = 0;
		}
		int k1 = l + ((j1 - i1) * (i - 1));
		for (int l1 = 44; l1 < (k1 + 44); l1++) {
			Sound.waveGenerationBuffer[l1] = -128;
		}
		for (int i2 = 0; i2 < 10; i2++) {
			if (this.aClass6Array329[i2] != null) {
				int j2 = (this.aClass6Array329[i2].msLength * 22050) / 1000;
				int i3 = (this.aClass6Array329[i2].anInt114 * 22050) / 1000;
				int ai[] = this.aClass6Array329[i2].method167(j2, this.aClass6Array329[i2].msLength);
				for (int l3 = 0; l3 < j2; l3++) {
					Sound.waveGenerationBuffer[l3 + i3 + 44] += (byte)(ai[l3] >> 8);
				}
			}
		}
		if (i > 1) {
			i1 += 44;
			j1 += 44;
			l += 44;
			int k2 = (k1 += 44) - l;
			for (int j3 = l - 1; j3 >= j1; j3--) {
				Sound.waveGenerationBuffer[j3 + k2] = Sound.waveGenerationBuffer[j3];
			}
			for (int k3 = 1; k3 < i; k3++) {
				int l2 = (j1 - i1) * k3;
				System.arraycopy(Sound.waveGenerationBuffer, i1, Sound.waveGenerationBuffer, i1 + l2, j1 - i1);
			}
			k1 -= 44;
		}
		return k1;
	}

	private static Sound[] soundGeneratorList = new Sound[5000];
	public static int[] anIntArray326 = new int[5000];
	private static byte[] waveGenerationBuffer;
	private static Packet waveGenerationPacket;
	private SoundTrack[] aClass6Array329;
	private int anInt330;
	private int anInt331;
}