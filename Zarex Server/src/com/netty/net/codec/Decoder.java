package com.netty.net.codec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketConstants;
import com.netty.net.packet.PacketType;

public class Decoder extends FrameDecoder {

	private int opcode = -1;
	private int length = -1;

	@Override
	protected Object decode(ChannelHandlerContext chc, Channel channel, ChannelBuffer cb) {
		Player player = (Player) chc.getAttachment();
		if (player == null) {
			return null;
		}
		if (this.getOpcode() == -1) {
			if (cb.readableBytes() >= 1) {
				this.setOpcode(cb.readByte() & 0xFF);
				if (this.getOpcode() == 0) {
					return null;
				}
				this.setLength(PacketConstants.PACKET_SIZES[this.getOpcode()]);
			} else {
				return null;
			}
		}
		if (this.getLength() == -1) {
			if (cb.readableBytes() >= 1) {
				this.setLength(cb.readByte() & 0xFF);
			} else {
				return null;
			}
		}
		if (cb.readableBytes() >= this.getLength()) {
			byte[] data = new byte[this.getLength()];
			cb.readBytes(data);
			ChannelBuffer channelBuffer = ChannelBuffers.buffer(data.length);
			cb.writeBytes(data);
			Packet packet = new Packet(this.getOpcode(), PacketType.FIXED, channelBuffer);
			try {
				if ((player != null) && (packet != null)) {
					return new Packet(this.getOpcode(), PacketType.FIXED, cb);
				}
			} finally {
				this.setOpcode(-1);
				this.setLength(-1);
			}
		}
		return null;
	}

	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}

	public int getOpcode() {
		return this.opcode;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}
}