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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:31:34 PM
 */
public class Decoder extends FrameDecoder {

	/**
	 * 
	 */
	private short opcode = -1;

	/**
	 * 
	 */
	private short length = -1;

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.frame.FrameDecoder#decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer)
	 */
	@Override
	protected Object decode(ChannelHandlerContext chc, Channel channel, ChannelBuffer cb) {
		Player player = (Player) chc.getAttachment();
		if (player == null) {
			return null;
		}
		if (this.getOpcode() == -1) {
			if (cb.readableBytes() >= 1) {
				this.setOpcode((short) (cb.readByte() & 0xFF));
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
				this.setLength((short) (cb.readByte() & 0xFF));
			} else {
				return null;
			}
		}
		if (cb.readableBytes() >= this.getLength()) {
			byte[] data = new byte[this.getLength()];
			cb.readBytes(data);
			ChannelBuffer channelBuffer = ChannelBuffers.buffer(data.length);
			cb.writeBytes(data);
			try {
				return new Packet(this.getOpcode(), PacketType.FIXED, channelBuffer);
			} finally {
				this.setOpcode((short) -1);
				this.setLength((short) -1);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 */
	public void setOpcode(short opcode) {
		this.opcode = opcode;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getOpcode() {
		return this.opcode;
	}

	/**
	 * 
	 * @param length
	 * 			The id to set.
	 */
	public void setLength(short length) {
		this.length = length;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getLength() {
		return this.length;
	}
}