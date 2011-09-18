package com.netty.net.packet;

import com.netty.net.packet.player.WalkingPacketHandler;

public class PacketManagerArray {

	private static PacketHandler[] packetHandlers = new PacketHandler[256];

	static {
		WalkingPacketHandler walkingPacketHandler = new WalkingPacketHandler();
		PacketManagerArray.getPacketHandlers()[98] = walkingPacketHandler;
		PacketManagerArray.getPacketHandlers()[164] = walkingPacketHandler;
		PacketManagerArray.getPacketHandlers()[248] = walkingPacketHandler;
	}

	public static void handlePacket() {

	}

	public static void setPacketHandlers(PacketHandler[] packetHandlers) {
		PacketManagerArray.packetHandlers = packetHandlers;
	}

	public static PacketHandler[] getPacketHandlers() {
		return PacketManagerArray.packetHandlers;
	}
}