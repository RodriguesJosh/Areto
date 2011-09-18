package com.netty.net.packet;

import java.math.BigInteger;

import com.netty.net.cache.CacheableNode;
import com.netty.net.cache.Deque;
import com.netty.util.ISAACRandomGen;

public class Packet extends CacheableNode {

	public static Packet create(){
		synchronized (Packet.deque) {
			Packet packet = null;
			if (Packet.anInt1412 > 0) {
				Packet.anInt1412--;
				packet = (Packet) Packet.deque.popHead();
			}
			if (packet != null) {
				packet.setPosition(0);
				return packet;
			}
		}
		Packet stream_1 = new Packet();
		stream_1.setPosition(0);
		stream_1.buffer = new byte[5000];
		return stream_1;
	}

	private Packet() {}

	public Packet(byte[] abyte0) {
		this.buffer = abyte0;
		this.setPosition(0);
	}

	public int getUnsignedByte() {
		int position = this.getPosition();
		return this.buffer[position++] & 0xff;
	}

	public byte getByte() {
		int position = this.getPosition();
		return this.buffer[position++];
	}

	public int getUnsignedShort() {
		int position = this.getPosition();
		position += 2;
		return ((this.buffer[position - 2] & 0xff) << 8) + (this.buffer[position - 1] & 0xff);
	}

	public int getShort() {
		int position = this.getPosition();
		position += 2;
		int i = ((this.buffer[position - 2] & 0xff) << 8) + (this.buffer[position - 1] & 0xff);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int getTriBytes() {
		int position = this.getPosition();
		position += 3;
		return ((this.buffer[position - 3] & 0xff) << 16) + ((this.buffer[position - 2] & 0xff) << 8) + (this.buffer[position - 1] & 0xff);
	}

	public int getInt() {
		int position = this.getPosition();
		position += 4;
		int a = ((this.buffer[position - 4] & 0xff) << 24);
		int b = ((this.buffer[position - 3] & 0xff) << 16);
		int c = ((this.buffer[position - 2] & 0xff) << 8);
		int d = (this.buffer[position - 1] & 0xff);
		return a + b + c + d;
	}

	public long getLong() {
		long l = this.getInt() & 0xffffffffL;
		long l1 = this.getInt() & 0xffffffffL;
		return (l << 32) + l1;
	}

	public String getString() {
		int position = this.getPosition();
		while (this.buffer[position++] != 10) {
			;
		}
		return new String(this.buffer, position, this.getPosition() - position - 1);
	}

	public byte[] getBytes() {
		int position = this.getPosition();
		while (this.buffer[position++] != 10) {
			;
		}
		byte abyte0[] = new byte[this.getPosition() - position - 1];
		System.arraycopy(this.buffer, position, abyte0, position - position, this.getPosition() - 1 - position);
		return abyte0;
	}

	public void getBytes(int i, int j, byte[] abyte0) {
		int position = this.getPosition();
		for (int l = j; l < (j + i); l++) {
			abyte0[l] = this.buffer[position++];
		}
	}

	public void startBitAccess() {
		this.bitPosition = this.getPosition() * 8;
	}

	public int putBits(int i) {
		int k = this.bitPosition >> 3;
		int l = 8 - (this.bitPosition & 7);
		int i1 = 0;
		this.bitPosition += i;
		for (; i > l; l = 8) {
			i1 += (this.buffer[k++] & Packet.anIntArray1409[l]) << (i - l);
			i -= l;
		}
		if (i == l) {
			i1 += this.buffer[k] & Packet.anIntArray1409[l];
		} else {
			i1 += (this.buffer[k] >> (l - i)) & Packet.anIntArray1409[i];
		}
		return i1;
	}

	public void finishBitAccess() {
		this.setPosition((this.bitPosition + 7) / 8);
	}

	public int method421() {
		int position = this.getPosition();
		int i = this.buffer[position] & 0xff;
		if (i < 128) {
			return this.getUnsignedByte() - 64;
		} else {
			return this.getUnsignedShort() - 49152;
		}
	}

	public int method422() {
		int position = this.getPosition();
		int i = this.buffer[position] & 0xff;
		if (i < 128) {
			return this.getUnsignedByte();
		} else {
			return this.getUnsignedShort() - 32768;
		}
	}

	public void doKeys() {
		int position = this.getPosition();
		this.setPosition(0);
		byte abyte0[] = new byte[position];
		this.getBytes(position, 0, abyte0);
		BigInteger biginteger2 = new BigInteger(abyte0);
		BigInteger biginteger3 = biginteger2;
		@SuppressWarnings("unused")
		byte abyte1[] = biginteger3.toByteArray();
		this.setPosition(0);
		// this.writeWordBigEndian(abyte1.length);
		// this.putBytes(abyte1, abyte1.length, 0);
	}

	public int method426() {
		int position = this.getPosition();
		return (this.buffer[position++] - 128) & 0xff;
	}

	public int method427() {
		int position = this.getPosition();
		return -this.buffer[position++] & 0xff;
	}

	public int method428() {
		int position = this.getPosition();
		return (128 - this.buffer[position++]) & 0xff;
	}

	public byte method429() {
		int position = this.getPosition();
		return (byte) (-this.buffer[position++]);
	}

	public byte method430() {
		int position = this.getPosition();
		return (byte)(128 - this.buffer[position++]);
	}

	public int method434() {
		int position = this.getPosition();
		position += 2;
		return ((this.buffer[position - 1] & 0xff) << 8) + (this.buffer[position - 2] & 0xff);
	}

	public int method435() {
		int position = this.getPosition();
		position += 2;
		return ((this.buffer[position - 2] & 0xff) << 8) + ((this.buffer[position - 1] - 128) & 0xff);
	}

	public int method436() {
		int position = this.getPosition();
		position += 2;
		return ((this.buffer[position - 1] & 0xff) << 8) + ((this.buffer[position - 2] - 128) & 0xff);
	}

	public int method437() {
		int position = this.getPosition();
		position += 2;
		int j = ((this.buffer[position - 1] & 0xff) << 8) + (this.buffer[position - 2] & 0xff);
		if (j > 32767) {
			j -= 0x10000;
		}
		return j;
	}

	public int method438() {
		int position = this.getPosition();
		position += 2;
		int j = ((this.buffer[position - 1] & 0xff) << 8) + ((this.buffer[position - 2] - 128) & 0xff);
		if (j > 32767) {
			j -= 0x10000;
		}
		return j;
	}

	public int method439() {
		int position = this.getPosition();
		position += 4;
		return ((this.buffer[position - 2] & 0xff) << 24) + ((this.buffer[position - 1] & 0xff) << 16) + ((this.buffer[position - 4] & 0xff) << 8) + (this.buffer[position - 3] & 0xff);
	}

	public int method440() {
		int position = this.getPosition();
		position += 4;
		return ((this.buffer[position - 3] & 0xff) << 24) + ((this.buffer[position - 4] & 0xff) << 16) + ((this.buffer[position - 1] & 0xff) << 8) + (this.buffer[position - 2] & 0xff);
	}

	public void method442(int i, int j, byte abyte0[]) {
		int position = this.getPosition();
		for (int k = (j + i) - 1; k >= j; k--) {
			abyte0[k] = this.buffer[position++];
		}
	}

	public byte[] buffer;
	public int position;
	public int bitPosition;
	private static final int[] anIntArray1409 = {
		0, 1, 3, 7, 15, 31, 63, 127, 255, 511,
		1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff,
		0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff,
		0x3fffffff, 0x7fffffff, -1
	};
	public ISAACRandomGen encryption;
	private static int anInt1412;
	private static final Deque deque = new Deque();

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}
}
