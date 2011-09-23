package com.netty.net.packet.senderevent.container;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:01:07 PM
 */
public class BankEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public BankEvent(Player player) {
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