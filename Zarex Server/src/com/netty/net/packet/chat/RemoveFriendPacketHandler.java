package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class RemoveFriendPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String friendsName = (String) packetAttribute.getAttribute("FRIENDS_NAME");
		World.getWorld().getLogger().info("Removing friend : " + friendsName);
		World.getWorld().unregisterFriend(World.getWorld().getFriendsName(friendsName));
	}
}