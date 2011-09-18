package com.netty.net.packet.player;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

public class LoadNewAreaPacketHandler implements PacketHandler {

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