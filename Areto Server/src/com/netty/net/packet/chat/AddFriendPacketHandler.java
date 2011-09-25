package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.model.player.tab.Friend;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:36:59 PM
 */
public class AddFriendPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String friendsName = (String) packetAttribute.getAttribute("FRIENDS_NAME");
		World.getWorld().getLogger().info("Adding friend : " + friendsName);
		World.getWorld().getFriendsList().add(new Friend(friendsName));
	}
}