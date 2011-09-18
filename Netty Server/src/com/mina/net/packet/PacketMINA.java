package com.mina.net.packet;

import org.apache.mina.core.buffer.IoBuffer;
import org.jboss.netty.buffer.ChannelBuffer;

import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * A MINA implmentation for the {@link Packet}
 * that we will use when sending packets to the
 * client and vice versa.
 * @author josh
 * @version 1.0
 */
public class PacketMINA extends Packet {

	/**
	 * The {@link IoBuffer} used to write out
	 * the {@code Packet}s when sending them
	 * to the client and vice versa.
	 */
	private IoBuffer ioBuffer;

	/**
	 * Constructs a new {@code Packet} but this will
	 * be the MINA implementation type.
	 * @param opcode
	 * 			The operation code that will be used
	 * 			to identify the {@code Packet}.
	 * @param packetType
	 * 			The type of {@code Packet} this packet
	 * 			will be when constructing a new one.
	 * @param channelBuffer
	 * 			{@code null}
	 * @param ioBuffer
	 * 			The {@code IoBuffer} used to write the
	 * 			{@code Packet}s.
	 */
	public PacketMINA(int opcode, PacketType packetType, ChannelBuffer channelBuffer, IoBuffer ioBuffer) {
		super(opcode, packetType, null);
		this.setIOBuffer(ioBuffer);
	}

	/**
	 * Gets the position in the {@code IoBuffer}.
	 * @return
	 */
	public int getPosition() {
		return this.getIOBuffer().position();
	}

	/**
	 * Sets the {@code IoBuffer} to a new one
	 * or to an already being used one.
	 * @param ioBuffer
	 * 			The {@code IoBuffer} to set.
	 */
	public void setIOBuffer(IoBuffer ioBuffer) {
		this.ioBuffer = ioBuffer;
	}

	/**
	 * Gets the {@code IoBuffer} instance for
	 * {@code Packet} handling.
	 * @return ioBuffer
	 * 			The {@code IoBuffer} to get.
	 */
	public IoBuffer getIOBuffer() {
		return this.ioBuffer;
	}
}