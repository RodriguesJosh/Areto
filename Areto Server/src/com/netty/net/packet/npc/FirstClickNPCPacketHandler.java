package com.netty.net.packet.npc;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:22:05 PM
 */
public class FirstClickNPCPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int index = ((Integer) packetAttribute.getAttribute("INDEX")).intValue();// getLEShortA() & 0xFF;
		int id = World.getWorld().getNPCList().get(index).getID();
		String name = World.getWorld().getNPCList().get(index).getName();
		if (name == null) {
			return;
		}
		switch (id) {
			case 1:

				break;
		}
	}
}