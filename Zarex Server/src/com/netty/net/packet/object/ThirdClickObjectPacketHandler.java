package com.netty.net.packet.object;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:20:20 PM
 */
public class ThirdClickObjectPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		return;
	}
}