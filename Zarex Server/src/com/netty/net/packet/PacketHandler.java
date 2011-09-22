package com.netty.net.packet;

import com.netty.model.player.Player;

public interface PacketHandler {

	public void handlePacket(PacketAttribute packetAttribute, Player player);
}