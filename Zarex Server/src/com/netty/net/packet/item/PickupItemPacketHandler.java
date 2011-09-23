package com.netty.net.packet.item;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:24:52 PM
 */
public class PickupItemPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int itemY = ((Integer) packetAttribute.getAttribute("ITEM_Y")).intValue();// getLEShort();
		int itemID = ((Integer) packetAttribute.getAttribute("ITEM_ID")).intValue();// getShort() & 0xFF;
		int itemX = ((Integer) packetAttribute.getAttribute("ITEM_X")).intValue();// getLEShort();
		if (itemY == -1) {
			return;
		}
		if (itemID == -1) {
			return;
		}
		if (itemX == -1) {
			return;
		}
		if (player.getInventory().getInventoryContainer().getFreeSlots() > 0) {
			// player.getInventory().getInventoryContainer().registerItem(new Item(itemID, 1));
		}
	}
}
