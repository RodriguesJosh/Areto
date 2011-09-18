package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.model.update.Chat;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class ChatPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int effects = (Integer) packetAttribute.getAttribute("EFFECTS");// getByteS() & 0xFF;
		int color = (Integer) packetAttribute.getAttribute("COLOR");// getByteS() & 0xFF;
		int size = (Integer) packetAttribute.getAttribute("SIZE");// getPosition() - 2;
		byte[] chatData = new byte[size];
		// packet.getBytesReverseA(chatData, size);
		player.getChatMessageList().add(new Chat(new String(chatData), effects, color));
		World.getWorld().getLogger().info("Chat : " + player.getChat().getText());
	}
}