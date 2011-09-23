package com.grizzly.net.packet;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketType;

/**
 * Represents a PacketBuilder object
 * that will be formatted for the Grizzly
 * implementation.
 *
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:05:42 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PacketBuilderGrizzly extends PacketBuilder {

	/**
	 * Constructs a new PacketBuilder for
	 * the Grizzly implementation. By default,
	 * the opcode will be -1.
	 */
	public PacketBuilderGrizzly() {
		super((short) -1);
	}

	/**
	 * Constructs a new PacketBuilder with a
	 * parameter of an opcode to set.
	 * @param opcode
	 * 			The opcode of the packet to build.
	 */
	public PacketBuilderGrizzly(short opcode) {
		super(opcode, PacketType.FIXED);
	}

	/**
	 * Constructs a new PacketBuilder with an
	 * opcode and the type of packet to set.
	 * @param opcode
	 * 			The opcode of the packet to build.
	 * @param packetType
	 * 			The type of packet.
	 */
	public PacketBuilderGrizzly(short opcode, PacketType packetType) {
		super(opcode, packetType);
	}

	/**
	 * Transfers all the necessary components of
	 * a packet from the building process to the
	 * actual Packet object.
	 * @return
	 * 			Returns a new packet.
	 */
	public PacketGrizzly toPacketGrizzly() {
		return new PacketGrizzly(this.getOpcode(), this.getPacketType());
	}
}