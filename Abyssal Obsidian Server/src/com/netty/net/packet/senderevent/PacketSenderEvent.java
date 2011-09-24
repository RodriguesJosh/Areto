package com.netty.net.packet.senderevent;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 1:40:41 PM
 */
public abstract class PacketSenderEvent {

	/**
	 * The player that wishes to execute an
	 * encoded packet event.
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public PacketSenderEvent(Player player) {
		this.setPlayer(player);
	}

	/**
	 * 
	 * @return
	 * 			Returns the packet to encode.
	 */
	public abstract Packet toPacket();

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return player
	 * 			Returns the player to get.
	 */
	public Player getPlayer() {
		return this.player;
	}
}