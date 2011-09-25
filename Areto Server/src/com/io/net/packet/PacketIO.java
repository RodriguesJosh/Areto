package com.io.net.packet;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * A packet implementation for the IO
 * networking.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:17:21 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PacketIO extends Packet {

	/**
	 * A byte array to store data in.
	 */
	private byte[] buffer;

	/**
	 * Constructs a new packet to send from
	 * and to the client.
	 * 
	 * @param opcode
	 * 			The opcode for the packet.
	 * @param packetType
	 * 			The type of packet.
	 * @param buffer
	 * 			The buffer to hold data for the
	 * 			packet.
	 */
	public PacketIO(int opcode, PacketType packetType, byte[] buffer) {
		super(opcode, packetType, null);
		this.setBuffer(buffer);
	}

	/**
	 * Sets the buffer for holding data.
	 * 
	 * @param buffer
	 * 			The buffer to hold data.
	 */
	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	/**
	 * Gets the byte array that is carrying
	 * data to use.
	 * 
	 * @return
	 * 			Returns the buffer that is
	 * 			holding data.
	 */
	public byte[] getBuffer() {
		return this.buffer;
	}
}