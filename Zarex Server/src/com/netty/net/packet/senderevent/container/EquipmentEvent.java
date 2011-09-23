package com.netty.net.packet.senderevent.container;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:02:22 PM
 */
public class EquipmentEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public EquipmentEvent(Player player) {
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