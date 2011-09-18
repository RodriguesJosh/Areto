package com.nio.net.packet;

import java.nio.ByteBuffer;

public class PacketNIO {

	private ByteBuffer byteBuffer;

	public void setByteBuffer(ByteBuffer byteBuffer) {
		this.byteBuffer = byteBuffer;
	}

	public ByteBuffer getByteBuffer() {
		return this.byteBuffer;
	}
}