package com.netty.net.packet.npc;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:21:55 PM
 */
public class SecondClickNPCPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int index = ((Integer) packetAttribute.getAttribute("INDEX")).intValue();// getLEShortA() & 0xFF;
		index &= 0xFFFF;
		int id = World.getWorld().getNPCList().get(index).getID();
		if (id == -1) {
			return;
		}
	}
}