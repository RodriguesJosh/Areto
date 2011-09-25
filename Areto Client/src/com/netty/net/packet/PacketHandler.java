package com.netty.net.packet;

import com.netty.game.Client;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:26:08 PM
 */
public interface PacketHandler {

	/**
	 * 
	 * @param packetAttribute
	 * 			The id to set.
	 * @param client
	 * 			The id to set.
	 * @param packet
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean handlePacket(PacketAttribute packetAttribute, Client client, Packet packet);
}