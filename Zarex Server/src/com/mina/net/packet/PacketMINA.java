package com.mina.net.packet;

import org.apache.mina.core.buffer.IoBuffer;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * A MINA implmentation for the {@link Packet}
 * that we will use when sending packets to the
 * client and vice versa.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:12:06 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PacketMINA extends Packet {

	/**
	 * The IoBuffer used to write out the packets
	 * when sending them to the client and vice versa.
	 */
	private IoBuffer ioBuffer;

	/**
	 * Constructs a new {@code Packet} but this will
	 * be the MINA implementation type.
	 * 
	 * @param opcode
	 * 			The operation code that will be used
	 * 			to identify the packet.
	 * @param packetType
	 * 			The type of packet this packet will be
	 * 			when constructing a new one.
	 * @param ioBuffer
	 * 			The IoBuffer used to write the
	 * 			packets.
	 */
	public PacketMINA(int opcode, PacketType packetType, IoBuffer ioBuffer) {
		super(opcode, packetType, null);
		this.setIOBuffer(ioBuffer);
	}

	/**
	 * Gets the position in the IoBuffer.
	 * 
	 * @return
	 * 			The position in the ByteBuffer.
	 */
	public int getPosition() {
		return this.getIOBuffer().position();
	}

	/**
	 * Sets the IoBuffer to a new one or to an
	 * already being used one.
	 * 
	 * @param ioBuffer
	 * 			The IoBuffer to set.
	 */
	public void setIOBuffer(IoBuffer ioBuffer) {
		this.ioBuffer = ioBuffer;
	}

	/**
	 * Gets the  IoBuffer instance for Packet
	 * handling.
	 * 
	 * @return ioBuffer
	 * 			The IoBuffer to get.
	 */
	public IoBuffer getIOBuffer() {
		return this.ioBuffer;
	}
}