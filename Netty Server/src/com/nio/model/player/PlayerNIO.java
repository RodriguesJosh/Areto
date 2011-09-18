package com.nio.model.player;

import java.nio.ByteBuffer;

import com.netty.model.player.Player;

public class PlayerNIO extends Player {

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

	public void setByteBuffer(ByteBuffer byteBuffer) {
		this.byteBuffer = byteBuffer;
	}

	public ByteBuffer getByteBuffer() {
		return this.byteBuffer;
	}
}