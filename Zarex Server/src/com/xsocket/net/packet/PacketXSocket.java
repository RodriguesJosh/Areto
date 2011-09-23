package com.xsocket.net.packet;

import org.jboss.netty.buffer.ChannelBuffer;

import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:50:02 AM
 */
public class PacketXSocket extends Packet {

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 * @param packetType
	 * 			The id to set.
	 * @param channelBuffer
	 * 			The id to set.
	 */
	public PacketXSocket(short opcode, PacketType packetType, ChannelBuffer channelBuffer) {
		super(opcode, packetType, channelBuffer);
	}
}