package com.netty.net.packet.item;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

public class FirstClickItemPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int interfaceID = (Integer) packetAttribute.getAttribute("INTERFACE_ID");// getShortA() & 0xFFFF;
		int slot = (Integer) packetAttribute.getAttribute("SLOT");// getShortA() & 0xFFFF;
		int id = (Integer) packetAttribute.getAttribute("ID");// getShortA() & 0xFFFF;
		switch (interfaceID) {
		case 5064:
		case 7423:
			if ((slot >= 0) && (slot < 28)) {
				player.getBank().depositItem(player, slot, new Item(id, 1));
			}
			break;
		}
	}
}