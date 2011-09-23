package com.netty.net.packet.player;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:18:54 PM
 */
public class DefaultPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		return;
	}
}