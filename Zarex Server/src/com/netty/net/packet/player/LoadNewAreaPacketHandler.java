package com.netty.net.packet.player;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:16:57 PM
 */
public class LoadNewAreaPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		// Object[] objects = {
		// 		World.getWorld().getObjectList().get(0), World.getWorld().getObjectList().get(1)
		// };
		// for (Object object : objects) {
		// 	player.getPacketSender().registerObject(object);
		// }
		// World.getWorld().getLogger().info("Loading done...");
	}
}