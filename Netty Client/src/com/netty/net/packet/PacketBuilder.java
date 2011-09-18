package com.netty.net.packet;

import com.netty.net.SignLink;

public class PacketBuilder {

	private byte[] buffer;
	private int position;
	// private ChannelBuffer channelBuffer = ChannelBuffers.dynamicBuffer();

	public void putOpcode(int i) {
		int position = this.getPosition();
		// this.buffer[position++] = (byte) (i + this.encryption.getNextKey());
		this.setPosition(position);
	}

	public void writeWordBigEndian(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) i;
		this.setPosition(position);
	}

	public void putShort(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (i >> 8);
		this.buffer[position++] = (byte) i;
		this.setPosition(position);
	}

	public void method400(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) i;
		this.buffer[position++] = (byte) (i >> 8);
		this.setPosition(position);
	}

	public void writeDWordBigEndian(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (i >> 16);
		this.buffer[position++] = (byte) (i >> 8);
		this.buffer[position++] = (byte) i;
		this.setPosition(position);
	}

	public void putInt(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (i >> 24);
		this.buffer[position++] = (byte) (i >> 16);
		this.buffer[position++] = (byte) (i >> 8);
		this.buffer[position++] = (byte) i;
		this.setPosition(position);
	}

	public void method403(int j) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) j;
		this.buffer[position++] = (byte) (j >> 8);
		this.buffer[position++] = (byte) (j >> 16);
		this.buffer[position++] = (byte) (j >> 24);
		this.setPosition(position);
	}

	public void putLong(long l) {
		try {
			int position = this.getPosition();
			this.buffer[position++] = (byte) (int) (l >> 56);
			this.buffer[position++] = (byte) (int) (l >> 48);
			this.buffer[position++] = (byte) (int) (l >> 40);
			this.buffer[position++] = (byte) (int) (l >> 32);
			this.buffer[position++] = (byte) (int) (l >> 24);
			this.buffer[position++] = (byte) (int) (l >> 16);
			this.buffer[position++] = (byte) (int) (l >> 8);
			this.buffer[position++] = (byte) (int) l;
			this.setPosition(position);
		} catch(RuntimeException runtimeexception) {
			SignLink.reporterror("14395, " + 5 + ", " + l + ", " + runtimeexception.toString());
			throw new RuntimeException();
		}
	}

	public void putString(String s) {
		int position = this.getPosition();
		System.arraycopy(s.getBytes(), 0, this.buffer, position, s.length());
		position += s.length();
		this.buffer[position++] = 10;
		this.setPosition(position);
	}

	public void putBytes(byte abyte0[], int i, int j) {
		int position = this.getPosition();
		for (int k = j; k < (j + i); k++) {
			this.buffer[position++] = abyte0[k];
		}
		this.setPosition(position);
	}

	public void putBytes(int i) {
		int position = this.getPosition();
		this.buffer[position - i - 1] = (byte) i;
		this.setPosition(position);
	}

	public void method424(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (-i);
		this.setPosition(position);
	}

	public void method425(int j) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (128 - j);
		this.setPosition(position);
	}

	public void method431(int i) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) i;
		this.buffer[position++] = (byte) (i >> 8);
		this.setPosition(position);
	}

	public void method432(int j) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (j >> 8);
		this.buffer[position++] = (byte) (j + 128);
		this.setPosition(position);
	}

	public void method433(int j) {
		int position = this.getPosition();
		this.buffer[position++] = (byte) (j + 128);
		this.buffer[position++] = (byte) (j >> 8);
		this.setPosition(position);
	}

	public void method441(int i, byte abyte0[], int j) {
		int position = this.getPosition();
		for (int k = (i + j) - 1; k >= i; k--) {
			this.buffer[position++] = (byte) (abyte0[k] + 128);
		}
		this.setPosition(position);
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public byte[] getBuffer() {
		return this.buffer;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

	/** public void setChannelBuffer(ChannelBuffer channelBuffer) {
		this.channelBuffer = channelBuffer;
	}

	public ChannelBuffer getChannelBuffer() {
		return this.channelBuffer;
	} */
}