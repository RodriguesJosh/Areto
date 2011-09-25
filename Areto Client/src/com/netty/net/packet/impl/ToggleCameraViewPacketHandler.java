package com.netty.net.packet.impl;

import com.netty.game.Client;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:33:20 PM
 */
public class ToggleCameraViewPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.game.Client, com.netty.net.packet.Packet)
	 */
	@Override
	public boolean handlePacket(PacketAttribute packetAttribute, Client client, Packet packet) {
		if (packetAttribute == null) {
			throw new NullPointerException();
		}
		if (client == null) {
			throw new NullPointerException();
		}
		if (packet == null) {
			throw new NullPointerException();
		}
		return false;
	}
}