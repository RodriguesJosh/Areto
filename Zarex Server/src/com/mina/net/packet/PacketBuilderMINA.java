package com.mina.net.packet;

import org.apache.mina.core.buffer.IoBuffer;

import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketType;

public class PacketBuilderMINA extends PacketBuilder {

	private IoBuffer ioBuffer;

	public PacketBuilderMINA() {
		super(-1);
	}

	public PacketBuilderMINA(short opcode) {
		super(opcode, PacketType.FIXED);
	}

	public PacketBuilderMINA(short opcode, PacketType packetType) {
		super(opcode, packetType);
	}

	public PacketMINA toPacketMINA() {
		return new PacketMINA(this.getOpcode(), this.getPacketType(), null, this.getIOBuffer());
	}

	@Override
	public PacketBuilderMINA putByte(byte b) {
		this.getIOBuffer().put(b);
		return this;
	}

	@Override
	public PacketBuilderMINA putBytes(byte[] b) {
		this.getIOBuffer().put(b);
		return this;
	}

	@Override
	public PacketBuilderMINA putByteA(int b) {
		this.getIOBuffer().put((byte) (b + 128));
		return this;
	}

	@Override
	public PacketBuilderMINA putBytes(byte[] b, int position, int length) {
		this.getIOBuffer().put(b, position, length);
		return this;
	}

	public PacketBuilderMINA putBytes(IoBuffer ioBuffer) {
		this.getIOBuffer().put(ioBuffer);
		return this;
	}

	public PacketBuilderMINA putShort(short s) {
		this.getIOBuffer().putShort(s);
		return this;
	}

	@Override
	public PacketBuilderMINA putInt(int i) {
		this.getIOBuffer().putInt(i);
		return this;
	}

	@Override
	public PacketBuilderMINA putInts(int[] i) {
		System.arraycopy(i, 0, this.getIOBuffer(), this.getIOBuffer().position(), i.length);
		return this;
	}

	@Override
	public PacketBuilderMINA putLong(long l) {
		this.getIOBuffer().putLong(l);
		return this;
	}

	@Override
	public PacketBuilderMINA startBitAccess() {
		this.setBitPosition(this.getIOBuffer().position() * 8);
		return this;
	}

	@Override
	public PacketBuilderMINA finishBitAccess() {
		this.getIOBuffer().position((this.getBitPosition() + 7) / 8);
		return this;
	}

	@Override
	public PacketBuilderMINA putBits(int numBits, int value) {
		// int bytes = (int) Math.ceil(numBits / 8D) + 1;
		// this.getIOBuffer().ensureWritableBytes(((this.getBitPosition() + 7) / 8) + bytes);
		byte[] buffer = this.getIOBuffer().array();
		int bytePos = this.getBitPosition() >> 3;
		int bitOffset = 8 - (this.getBitPosition() & 7);
		int bitPosition = this.getBitPosition();
		bitPosition += numBits;
		this.setBitPosition(bitPosition);
		for (; numBits > bitOffset; bitOffset = 8) {
			buffer[bytePos] &= ~ PacketBuilder.getBitMask()[bitOffset];
			buffer[bytePos++] |= (value >> (numBits - bitOffset)) & PacketBuilder.getBitMask()[bitOffset];
			numBits -= bitOffset;
		}
		if (numBits == bitOffset) {
			buffer[bytePos] &= ~ PacketBuilder.getBitMask()[bitOffset];
			buffer[bytePos] |= value & PacketBuilder.getBitMask()[bitOffset];
		} else {
			buffer[bytePos] &= ~ (PacketBuilder.getBitMask()[numBits] << (bitOffset - numBits));
			buffer[bytePos] |= (value & PacketBuilder.getBitMask()[numBits]) << (bitOffset - numBits);
		}
		return this;
	}

	public void setIOBuffer(IoBuffer ioBuffer) {
		this.ioBuffer = ioBuffer;
	}

	public IoBuffer getIOBuffer() {
		return this.ioBuffer;
	}
}