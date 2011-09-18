package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class RemoveIgnorePacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String ignoresName = (String) packetAttribute.getAttribute("IGNORES_NAME");// getString();
		World.getWorld().getLogger().info("Removing ignore : " + ignoresName);
		World.getWorld().getIgnoresList().remove(World.getWorld().getIgnoresName(ignoresName));
	}
}