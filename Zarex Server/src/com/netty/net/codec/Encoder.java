package com.netty.net.codec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:30:47 PM
 */
public class Encoder extends OneToOneEncoder {

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.oneone.OneToOneEncoder#encode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, java.lang.Object)
	 */
	@Override
	protected Object encode(ChannelHandlerContext chc, Channel channel, Object object) {
		Packet packet = (Packet) object;
		if (packet == null) {
			throw new NullPointerException();
		}
		int opcode = packet.getOpcode();
		if (opcode == -1) {
			return packet.getChannelBuffer();
		}
		PacketType packetType = packet.getPacketType();
		int length = packet.getCapacity();
		int finalLength = length + 1;
		switch (packetType) {
			case VARIABLE_BYTE:
				finalLength += 1;
				break;
			case VARIABLE_SHORT:
				finalLength += 2;
				break;
			case FIXED:
				break;
		}
		ChannelBuffer cb = ChannelBuffers.buffer(finalLength);
		cb.writeByte((byte) opcode);
		switch (packetType) {
			case VARIABLE_BYTE:
				cb.writeByte((byte) length);
				break;
			case VARIABLE_SHORT:
				cb.writeShort((short) length);
				break;
			case FIXED:
				break;
		}
		cb.writeBytes(packet.getChannelBuffer());
		return cb;
	}
}