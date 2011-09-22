package com.netty.net.packet;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.netty.net.packet.player.WalkingPacketHandler;

// Goes in the World class.
public class PacketManagerMap {

	private ConcurrentMap<Short, PacketHandler> concurrentPacketMap;

	public PacketManagerMap() {
		this.setConcurrentPacketMap(new ConcurrentHashMap<Short, PacketHandler>());
	}

	{
		WalkingPacketHandler walkingPacketHandler = new WalkingPacketHandler();
		this.getConcurrentPacketMap().put((short) 248, walkingPacketHandler);
		this.getConcurrentPacketMap().put((short) 164, walkingPacketHandler);
		this.getConcurrentPacketMap().put((short) 98, walkingPacketHandler);
	}

	public void handlePacket() {

	}

	public void setConcurrentPacketMap(ConcurrentMap<Short, PacketHandler> concurrentPacketMap) {
		this.concurrentPacketMap = concurrentPacketMap;
	}

	public ConcurrentMap<Short, PacketHandler> getConcurrentPacketMap() {
		return this.concurrentPacketMap;
	}
}