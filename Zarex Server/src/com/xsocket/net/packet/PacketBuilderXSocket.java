package com.xsocket.net.packet;

import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:50:09 AM
 */
public class PacketBuilderXSocket extends PacketBuilder {

	/**
	 * 
	 */
	public PacketBuilderXSocket() {
		this((short) -1);
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 */
	public PacketBuilderXSocket(short opcode) {
		this(opcode, PacketType.FIXED);
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 * @param packetType
	 * 			The id to set.
	 */
	public PacketBuilderXSocket(short opcode, PacketType packetType) {
		this.setOpcode(opcode);
		this.setPacketType(packetType);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketXSocket toPacketXSocket() {
		return new PacketXSocket(this.getOpcode(), this.getPacketType(), this.getChannelBuffer().copy());
	}
}