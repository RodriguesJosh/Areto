package com.netty.stuff;

import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class VarBit {

	private VarBit() {}

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet packet = new Packet(jagexArchive.getDataForName("varbit.dat"));
		int cacheSize = packet.getUnsignedShort();
		if (VarBit.cache == null) {
			VarBit.cache = new VarBit[cacheSize];
		}
		for (int j = 0; j < cacheSize; j++) {
			if (VarBit.cache[j] == null) {
				VarBit.cache[j] = new VarBit();
			}
			VarBit.cache[j].readValues(packet);
		}
		if (packet.getPosition() != packet.buffer.length) {
			System.out.println("varbit load mismatch");
		}
	}

	private void readValues(Packet packet) {
		do {
			int j = packet.getUnsignedByte();
			if (j == 0) {
				return;
			}
			if (j == 1) {
				this.configID = packet.getUnsignedShort();
				this.leastSignificantBit = packet.getUnsignedByte();
				this.mostSignificantBit = packet.getUnsignedByte();
			} else if (j == 10) {
				packet.getString();
			} else if (j == 2) {
			} else if (j == 3) {
				packet.getInt();
			} else if (j == 4) {
				packet.getInt();
			} else {
				System.out.println("Error unrecognised config code: " + j);
			}
		} while (true);
	}

	public static VarBit cache[];
	public int configID;
	public int leastSignificantBit;
	public int mostSignificantBit;
}