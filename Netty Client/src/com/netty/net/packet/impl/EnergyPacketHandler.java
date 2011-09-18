package com.netty.net.packet.impl;

import com.netty.game.Client;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

public class EnergyPacketHandler implements PacketHandler {

	@Override
	public boolean handlePacket(PacketAttribute packetAttribute, Client client, Packet packet) {
		return false;
	}
}