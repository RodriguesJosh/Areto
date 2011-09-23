package com.io.net.packet;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * We will build the packets here so that
 * later on we can send them to the client
 * and vice versa.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:19:43 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PacketBuilderIO extends Packet {

	/**
	 * The byte array to hold data.
	 */
	private byte[] buffer;

	/**
	 * Constructs a new packet to build and
	 * then send to and from the client.
	 * 
	 * @param opcode
	 * 			The opcode for the packet.
	 * @param packetType
	 * 			The type of packet.
	 */
	public PacketBuilderIO(int opcode, PacketType packetType) {
		super(opcode, packetType, null);
	}

	/**
	 * Sets the buffer for holding data.
	 * 
	 * @param buffer
	 * 			The buffer to set.
	 */
	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	/**
	 * Gets the byte array that is containing
	 * data to use.
	 * 
	 * @return
	 * 			The buffer that is carrying
	 * 			data.
	 */
	public byte[] getBuffer() {
		return this.buffer;
	}
}