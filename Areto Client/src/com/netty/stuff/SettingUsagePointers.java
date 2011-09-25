package com.netty.stuff;

import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class SettingUsagePointers {

	private SettingUsagePointers() {}

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet packet = new Packet(jagexArchive.getDataForName("varp.dat"));
		int cacheSize = packet.getUnsignedShort();
		if (SettingUsagePointers.cache == null) {
			SettingUsagePointers.cache = new SettingUsagePointers[cacheSize];
		}
		for (int j = 0; j < cacheSize; j++) {
			if (SettingUsagePointers.cache[j] == null) {
				SettingUsagePointers.cache[j] = new SettingUsagePointers();
			}
			SettingUsagePointers.cache[j].readValues(packet, j);
		}
		if (packet.getPosition() != packet.buffer.length) {
			System.out.println("varptype load mismatch");
		}
	}

	private void readValues(Packet packet, int i) {
		do {
			int j = packet.getUnsignedByte();
			if (j == 0) {
				return;
			}
			if (j == 1) {
				packet.getUnsignedByte();
			} else if (j == 2) {
				packet.getUnsignedByte();
			} else if (j == 3) {
			} else if (j == 4) {
			} else if (j == 5) {
				this.usage = packet.getUnsignedShort();
			} else if (j == 6) {
			} else if (j == 7) {
				packet.getInt();
			} else if (j == 8) {
			} else if (j == 10) {
				packet.getString();
			} else if (j == 11) {
			} else if (j == 12) {
				packet.getInt();
			} else if (j == 13) {
			} else {
				System.out.println("Error unrecognised config code: " + j);
			}
		} while (true);
	}

	public static SettingUsagePointers cache[];
	public int usage;
}