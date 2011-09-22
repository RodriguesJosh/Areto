package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.model.player.tab.Friend;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class PrivateMessagePacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String friendsName = (String) packetAttribute.getAttribute("FRIENDS_NAME");
		World.getWorld().getLogger().info("Sending PM to friend : " + friendsName);
		String text = (String) packetAttribute.getAttribute("TEXT");
		Friend friend = World.getWorld().getFriendsName(friendsName);
		int textSize = (byte) (player.getPacket().getChannelBuffer().writerIndex() - 8);
		// player.getPacket().getBytes(text.getBytes(), 0, player.getPacket().getChannelBuffer().writerIndex());
		if (!friend.isOnline()) {
			player.getPacketSender().getMessage(friendsName + " is currently not available.");
			return;
		}
		player.getPacketSender().getPrivateMessage(friendsName, text, textSize);
	}
}