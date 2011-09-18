package com.netty.net.packet.login;

import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.util.NameUtility;
import com.netty.world.World;

public class ConnectLoginPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		World.getWorld().getLogger().info("Hi!");
		/** @SuppressWarnings("unused")
		int magicCode = (Integer) packetAttribute.getAttribute("MAGIC_CODE");
		@SuppressWarnings("unused")
		int clientVersion = (Integer) packetAttribute.getAttribute("CLIENT_VERSION");
		@SuppressWarnings("unused")
		boolean lowDetail = ((Integer) packetAttribute.getAttribute("MEMORY")) == 0;
		World.getWorld().getLogger().info("Blah!");
		@SuppressWarnings("unused")
		int data = (Integer) packetAttribute.getAttribute("LOGIN_BLOCK_DATA");
		@SuppressWarnings("unused")
		long clientSessionKey = (Long) packetAttribute.getAttribute("CLIENT_SESSION_KEY");
		@SuppressWarnings("unused")
		long serverSessionKey = (Long) packetAttribute.getAttribute("SERVER_SESSION_KEY");
		@SuppressWarnings("unused")
		int uid = (Integer) packetAttribute.getAttribute("UID"); */
		String name = (String) packetAttribute.getAttribute("NAME");
		String pass = (String) packetAttribute.getAttribute("PASS");
		player.setName(NameUtility.getFormattedName(name));
		player.setPass(pass);
		World.getWorld().getLogger().info("Hey!");
		// player.getChannel().write(new PacketBuilder().putByte((byte) 2).putByte((byte) 0).putByte((byte) 0));
		World.getWorld().getLogger().info("Almost there!");
		World.getWorld().registerPlayer(player);
	}
}