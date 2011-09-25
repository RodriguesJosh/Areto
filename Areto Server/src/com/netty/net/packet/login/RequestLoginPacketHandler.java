package com.netty.net.packet.login;

import java.security.SecureRandom;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:23:54 PM
 */
public class RequestLoginPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		World.getWorld().getLogger().info("Hmmmm");
		int nameHash = ((Integer) packetAttribute.getAttribute("NAME_HASH")).intValue();
		if (nameHash == -1) {
			return;
		}
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