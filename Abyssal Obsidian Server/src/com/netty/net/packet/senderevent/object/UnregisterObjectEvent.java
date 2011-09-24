package com.netty.net.packet.senderevent.object;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 2:09:05 PM
 */
public class UnregisterObjectEvent extends PacketSenderEvent {

	/**
	 * Constructs a new Object to unregister
	 * from the game.
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public UnregisterObjectEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		return null;
	}
}