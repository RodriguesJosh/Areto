package com.netty.net.packet.npc;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class FirstClickNPCPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int index = (Integer) packetAttribute.getAttribute("INDEX");// getLEShortA() & 0xFF;
		int id = World.getWorld().getNPCList().get(index).getID();
		@SuppressWarnings("unused")
		String name = World.getWorld().getNPCList().get(index).getName();
		switch (id) {
		case 1:

			break;
		}
	}
}