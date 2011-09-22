package com.netty.net.packet;

import com.netty.game.Client;

public interface PacketHandler {

	public boolean handlePacket(PacketAttribute packetAttribute, Client client, Packet packet);
}