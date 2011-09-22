package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.model.player.tab.Ignore;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class AddIgnorePacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String ignoresName = (String) packetAttribute.getAttribute("IGNORES_NAME");
		World.getWorld().getLogger().info("Adding ignore : " + ignoresName);
		World.getWorld().getIgnoresList().add(new Ignore(ignoresName));
	}
}