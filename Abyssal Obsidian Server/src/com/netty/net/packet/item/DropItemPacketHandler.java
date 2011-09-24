package com.netty.net.packet.item;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:25:42 PM
 */
public class DropItemPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int itemID = ((Integer) packetAttribute.getAttribute("ITEM_ID")).intValue();// getShortA() & 0xFF;
		int interfaceID = ((Integer) packetAttribute.getAttribute("INTERFACE_ID")).intValue();// getShort() & 0xFF;
		int itemIndex = ((Integer) packetAttribute.getAttribute("ITEM_INDEX")).intValue();// getShortA() & 0xFF;
		World.getWorld().getLogger().info("Item ID : " + itemID + " Interface ID : " + interfaceID + " Item Slot : " + itemIndex);
		switch (interfaceID) {
			case 3214:
				Item item = player.getInventory().getInventoryContainer().getItem(itemIndex);
				if (item.getID() != itemID) {
					return;
				}
				player.getPacketSender().getRegisteredGroundItem(item);
				player.getInventory().getInventoryContainer().unregisterItem(itemIndex, item);
				break;
		}
	}
}