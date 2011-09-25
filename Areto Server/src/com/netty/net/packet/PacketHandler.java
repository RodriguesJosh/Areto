package com.netty.net.packet;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:40:16 PM
 */
public interface PacketHandler {

	/**
	 * 
	 * @param packetAttribute
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void handlePacket(PacketAttribute packetAttribute, Player player);
}