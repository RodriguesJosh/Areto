package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:28:23 PM
 */
public class RemoveIgnorePacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String ignoresName = (String) packetAttribute.getAttribute("IGNORES_NAME");// getString();
		World.getWorld().getLogger().info("Removing ignore : " + ignoresName);
		World.getWorld().getIgnoresList().remove(World.getWorld().getIgnoresName(ignoresName));
	}
}