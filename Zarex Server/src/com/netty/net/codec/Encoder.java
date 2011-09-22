package com.netty.net.codec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketType;

public class Encoder extends OneToOneEncoder {

	@Override
	protected Object encode(ChannelHandlerContext chc, Channel channel, Object object) {
		if (object == null) {
			return null;
		}
		Packet packet = (Packet) object;
		if (packet == null) {
			return null;
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
		}
		cb.writeBytes(packet.getChannelBuffer());
		return cb;
	}
}