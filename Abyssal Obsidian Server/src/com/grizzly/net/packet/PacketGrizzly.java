package com.grizzly.net.packet;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * Represents a packet object that will
 * be formatted for the Grizzly implementation.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:05:24 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PacketGrizzly extends Packet {

	/**
	 * Constructs a new packet for the Grizzly
	 * implementation of the networking.
	 * 
	 * @param opcode
	 * 			The opcode of the packet.
	 * @param packetType
	 * 			The type of packet.
	 */
	public PacketGrizzly(short opcode, PacketType packetType) {
		super(opcode, packetType, null);
	}
}