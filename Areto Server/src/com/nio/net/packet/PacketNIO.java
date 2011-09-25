package com.nio.net.packet;

import java.nio.ByteBuffer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:52:52 AM
 */
public class PacketNIO {

	/**
	 * 
	 */
	private ByteBuffer byteBuffer;

	/**
	 * 
	 * @param byteBuffer
	 * 			The id to set.
	 */
	public void setByteBuffer(ByteBuffer byteBuffer) {
		this.byteBuffer = byteBuffer;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ByteBuffer getByteBuffer() {
		return this.byteBuffer;
	}
}