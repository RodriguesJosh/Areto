package com.netty.net.packet.item;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;


/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:25:30 PM
 */
public class FifthClickItemPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int interfaceID = ((Integer) packetAttribute.getAttribute("INTERFACE_ID")).intValue();// getShortA() & 0xFFFF;
		int slot = ((Integer) packetAttribute.getAttribute("SLOT")).intValue();// getShortA() & 0xFFFF;
		int id = ((Integer) packetAttribute.getAttribute("ID")).intValue();// getShortA() & 0xFFFF;
		switch (interfaceID) {
			case 5064:
			case 7423:
				if ((slot >= 0) && (slot < 28) && (id != -1)) {
					// X amount.
					// player.getBank().depositItem(player, slot, new Item(id, player.getInventory().getInventoryContainer().getAmount(id)));
				}
				break;
		}
	}
}