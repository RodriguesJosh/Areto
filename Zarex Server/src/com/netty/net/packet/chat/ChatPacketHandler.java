package com.netty.net.packet.chat;

import com.netty.model.player.Player;
import com.netty.model.update.Chat;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:29:09 PM
 */
public class ChatPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int effects = ((Integer) packetAttribute.getAttribute("EFFECTS")).intValue();// getByteS() & 0xFF;
		int color = ((Integer) packetAttribute.getAttribute("COLOR")).intValue();// getByteS() & 0xFF;
		int size = ((Integer) packetAttribute.getAttribute("SIZE")).intValue();// getPosition() - 2;
		byte[] chatData = new byte[size];
		// packet.getBytesReverseA(chatData, size);
		player.getChatMessageList().add(new Chat(new String(chatData), effects, color));
		World.getWorld().getLogger().info("Chat : " + player.getChat().getText());
	}
}