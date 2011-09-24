package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.model.player.tab.Ignore;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:29:20 PM
 */
public class AddIgnorePacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String ignoresName = (String) packetAttribute.getAttribute("IGNORES_NAME");
		World.getWorld().getLogger().info("Adding ignore : " + ignoresName);
		World.getWorld().getIgnoresList().add(new Ignore(ignoresName));
	}
}