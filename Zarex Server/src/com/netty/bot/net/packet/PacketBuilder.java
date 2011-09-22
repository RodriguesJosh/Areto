package com.netty.bot.net.packet;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/**
 * Build the {@link Packet}s that we will send
 * to the server. Each packet will contain
 * an opcode (operation code) to identify
 * which is which <code>Packet</code>. Although,
 * I feel using a <code>String</code> is most
 * appropriate because ids can become...confusing.
 * @author josh
 * @since 0.1
 */
public class PacketBuilder {

	/**
	 * A <code>ChannelBuffer</code> that will
	 * represent the <code>PacketBuilder</code>
	 * when it comes to writing the <code>Packet</code>s.
	 */
	private ChannelBuffer channelBuffer = ChannelBuffers.dynamicBuffer();

	/**
	 * Creates or uses a <code>ChannelBuffer</code> for
	 * packet building.
	 * @param channelBuffer
	 * 			Sets the <code>ChanneBuffer</code> so that
	 * 			we can operate on the <code>Packet</code>s.
	 */
	public void setChannelBuffer(ChannelBuffer channelBuffer) {
		this.channelBuffer = channelBuffer;
	}

	/**
	 * Returns the <code>ChannelBuffer</code> being used.
	 * @return channelBuffer
	 * 			Gets the <code>ChannelBuffer</code> when
	 * 			we want to build a certain <code>Packet</code>.
	 */
	public ChannelBuffer getChannelBuffer() {
		return this.channelBuffer;
	}
}