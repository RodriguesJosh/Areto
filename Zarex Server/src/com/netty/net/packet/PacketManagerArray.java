package com.netty.net.packet;

import com.netty.net.packet.player.WalkingPacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:40:30 PM
 */
public class PacketManagerArray {

	/**
	 * 
	 */
	private static PacketHandler[] packetHandlers = new PacketHandler[256];

	/**
	 * 
	 */
	static {
		WalkingPacketHandler walkingPacketHandler = new WalkingPacketHandler();
		PacketManagerArray.getPacketHandlers()[98] = walkingPacketHandler;
		PacketManagerArray.getPacketHandlers()[164] = walkingPacketHandler;
		PacketManagerArray.getPacketHandlers()[248] = walkingPacketHandler;
	}

	/**
	 * 
	 */
	public static void handlePacket() {
		return;
	}

	/**
	 * 
	 * @param packetHandlers
	 * 			The id to set.
	 */
	public static void setPacketHandlers(PacketHandler[] packetHandlers) {
		PacketManagerArray.packetHandlers = packetHandlers;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static PacketHandler[] getPacketHandlers() {
		return PacketManagerArray.packetHandlers;
	}
}