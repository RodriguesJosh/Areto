package com.netty.net.packet.item;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

public class PickupItemPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		@SuppressWarnings("unused")
		int itemY = (Integer) packetAttribute.getAttribute("ITEM_Y");// getLEShort();
		@SuppressWarnings("unused")
		int itemID = (Integer) packetAttribute.getAttribute("ITEM_ID");// getShort() & 0xFF;
		@SuppressWarnings("unused")
		int itemX = (Integer) packetAttribute.getAttribute("ITEM_X");// getLEShort();
		if (player.getInventory().getInventoryContainer().getFreeSlots() > 0) {
			// player.getInventory().getInventoryContainer().registerItem(new Item(itemID, 1));
		}
	}
}
