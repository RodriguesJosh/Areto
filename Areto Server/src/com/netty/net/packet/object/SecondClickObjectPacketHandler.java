package com.netty.net.packet.object;

import com.netty.model.player.Player;
import com.netty.model.player.bank.BankPin;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.Location;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:20:31 PM
 */
public class SecondClickObjectPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int objectID = ((Integer) packetAttribute.getAttribute("")).intValue();// getLEShortA() & 0xFFFF
		objectID &= 0xFFFF;
		short objectY = ((Short) packetAttribute.getAttribute("")).shortValue();// getLEShort();
		short objectX = ((Short) packetAttribute.getAttribute("")).shortValue();// (short) (packet.getShortA() & 0xFFFF);
		objectX &= 0xFFFF;
		World.getWorld().getLogger().info("Object ID : " + objectID + " Object X : " + objectX + " Object Y : " + objectY);
		if ((objectID == 2213) && player.getLocation().isWithinDistance(new Location(objectX, objectY, player.getLocation().getZ()))) {
			player.getPacketSender().getOpenBank();
		}
		switch (objectID) {
			case 11758:
			case 3193:
			case 2213:
			case 2214:
			case 3045:
			case 5276:
			case 6084:
			case 14367:
				new BankPin(player);
		}
	}
}