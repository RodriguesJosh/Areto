package com.nio.model.player;

import java.nio.ByteBuffer;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:54:26 AM
 */
public class PlayerNIO extends Player {

	/**
	 * 
	 */
	private ByteBuffer byteBuffer;

	/**
	 * We will be using the Netty constructor to call
	 * the {@code Player}.
	 * @param byteBuffer
	 * 			The byteBuffer for the {@code Player}.
	 */
	public PlayerNIO(ByteBuffer byteBuffer) {
		super(null);
		this.setByteBuffer(byteBuffer);
	}

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