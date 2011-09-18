package com.netty.stuff;

import com.netty.net.packet.Packet;

public class AmplitudeEnvelope {

	public void method325(Packet packet) {
		this.form = packet.getUnsignedByte();
		this.anInt538 = packet.getInt();
		this.anInt539 = packet.getInt();
		this.method326(packet);
	}

	public void method326(Packet packet) {
		this.length = packet.getUnsignedByte();
		this.duration = new int[this.length];
		this.amplitudes = new int[this.length];
		for (int i = 0; i < this.length; i++) {
			this.duration[i] = packet.getUnsignedShort();
			this.amplitudes[i] = packet.getUnsignedShort();
		}
	}

	void resetValues() {
		this.updateTick = 0;
		this.pointer = 0;
		this.step = 0;
		this.amplitude = 0;
		this.tick = 0;
	}

	int method328(int i) {
		if (this.tick >= this.updateTick) {
			this.amplitude = this.amplitudes[this.pointer++] << 15;
			if (this.pointer >= this.length) {
				this.pointer = this.length - 1;
			}
			this.updateTick = (int)((this.duration[this.pointer] / 65536D) * i);
			if (this.updateTick > this.tick) {
				this.step = ((this.amplitudes[this.pointer] << 15) - this.amplitude) / (this.updateTick - this.tick);
			}
		}
		this.amplitude += this.step;
		this.tick++;
		return (this.amplitude - this.step) >> 15;
	}

	public AmplitudeEnvelope() {}

	private int length;
	private int[] duration;
	private int[] amplitudes;
	int anInt538;
	int anInt539;
	int form;
	private int updateTick;
	private int pointer;
	private int step;
	private int amplitude;
	private int tick;
	public static int anInt546;
}