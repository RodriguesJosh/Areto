package com.netty.net.packet.login;

import java.security.SecureRandom;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class RequestLoginPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		World.getWorld().getLogger().info("Hmmmm");
		@SuppressWarnings("unused")
		int nameHash = (Integer) packetAttribute.getAttribute("NAME_HASH");
		SecureRandom secureRandom = new SecureRandom();
		PacketBuilder packetBuilder = new PacketBuilder();
		for (int i = 0; i < 9; i++) {
			packetBuilder.putByte((byte) 0);
		}
		packetBuilder.putLong(secureRandom.nextLong());
		World.getWorld().getLogger().info("Writing the packet..");
		player.getChannel().write(packetBuilder.toPacket());
		World.getWorld().getLogger().info("Wrote the packet..");
	}
}