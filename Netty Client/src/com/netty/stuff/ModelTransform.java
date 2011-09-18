package com.netty.stuff;

import com.netty.net.packet.Packet;

public class ModelTransform {

	public ModelTransform(Packet packet) {
		int length = packet.getUnsignedByte();
		this.opcodes = new int[length];
		this.skinList = new int[length][];
		for (int stepID = 0; stepID < length; stepID++) {
			this.opcodes[stepID] = packet.getUnsignedByte();
		}
		for (int stepID = 0; stepID < length; stepID++) {
			int l = packet.getUnsignedByte();
			this.skinList[stepID] = new int[l];
			for (int skinIndex = 0; skinIndex < l; skinIndex++) {
				this.skinList[stepID][skinIndex] = packet.getUnsignedByte();
			}
		}
	}

	public final int[] opcodes;
	public final int[][] skinList;
}