package com.netty.net.packet;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.netty.net.packet.player.WalkingPacketHandler;

// Goes in the World class as a singleton design.
/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:41:05 PM
 */
public class PacketManagerMap {

	/**
	 * 
	 */
	private ConcurrentMap<Short, PacketHandler> concurrentPacketMap;

	/**
	 * 
	 */
	public PacketManagerMap() {
		this.setConcurrentPacketMap(new ConcurrentHashMap<Short, PacketHandler>());
	}

	/**
	 * 
	 */
	{
		WalkingPacketHandler walkingPacketHandler = new WalkingPacketHandler();
		this.getConcurrentPacketMap().put(new Short((short) 248), walkingPacketHandler);
		this.getConcurrentPacketMap().put(new Short((short) 164), walkingPacketHandler);
		this.getConcurrentPacketMap().put(new Short((short) 98), walkingPacketHandler);
	}

	/**
	 * 
	 */
	public void handlePacket() {
		return;
	}

	/**
	 * 
	 * @param concurrentPacketMap
	 * 			The id to set.
	 */
	public void setConcurrentPacketMap(ConcurrentMap<Short, PacketHandler> concurrentPacketMap) {
		this.concurrentPacketMap = concurrentPacketMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ConcurrentMap<Short, PacketHandler> getConcurrentPacketMap() {
		return this.concurrentPacketMap;
	}
}