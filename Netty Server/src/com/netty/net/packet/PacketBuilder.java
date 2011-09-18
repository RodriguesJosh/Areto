package com.netty.net.packet;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class PacketBuilder {

	private static int[] bitMask = new int[32];
	private int opcode;
	private int bitPosition;
	private PacketType packetType;
	private ChannelBuffer channelBuffer = ChannelBuffers.dynamicBuffer();

	static {
		for (int i = 0; i < PacketBuilder.getBitMask().length; i++) {
			PacketBuilder.getBitMask()[i] = (1 << i) - 1;
		}
	}

	public PacketBuilder() {
		this(-1);
	}

	public PacketBuilder(int opcode) {
		this(opcode, PacketType.FIXED);
	}

	public PacketBuilder(int opcode, PacketType packetType) {
		this.setOpcode(opcode);
		this.setPacketType(packetType);
	}

	public Packet toPacket() {
		return new Packet(this.getOpcode(), this.getPacketType(), this.getChannelBuffer().copy());
	}

	public PacketBuilder putByte(byte b) {
		this.getChannelBuffer().writeByte(b);
		return this;
	}

	public PacketBuilder putBytes(byte[] b) {
		this.getChannelBuffer().writeBytes(b);
		return this;
	}

	public PacketBuilder putBytes(ChannelBuffer channelBuffer) {
		this.getChannelBuffer().writeBytes(channelBuffer);
		return this;
	}

	public PacketBuilder putByteA(int b) {
		this.getChannelBuffer().writeByte((byte) (b + 128));
		return this;
	}

	public PacketBuilder putBytesA(byte[] data, int length) {
		for (int i = 0; i < length; i ++) {
			this.putByte((byte) (data[i] + 128));
		}
		return this;
	}

	public PacketBuilder putByteC(int i) {
		this.putByte((byte) -i);
		return this;
	}

	public PacketBuilder putByteS(int i) {
		this.putByte((byte) (128 - i));
		return this;
	}

	public PacketBuilder putBytes(byte[] b, int position, int length) {
		this.getChannelBuffer().writeBytes(b, position, length);
		return this;
	}

	public PacketBuilder putBytes(ChannelBuffer channelBuffer, int position, int length) {
		this.getChannelBuffer().writeBytes(channelBuffer, position, length);
		return this;
	}

	public PacketBuilder putShort(int s) {
		this.getChannelBuffer().writeShort(s);
		return this;
	}

	public PacketBuilder putLEShort(int s) {
		this.putByte((byte) s).putByte((byte) (s >> 8));
		return this;
	}

	public PacketBuilder putShortA(int s) {
		this.putByte((byte) (s >> 8)).putByte((byte) (s + 128));
		return this;
	}

	public PacketBuilder putLEShortA(int b) {
		this.putByte((byte) (b + 128)).putByte((byte) (b >> 8));
		return this;
	}

	public PacketBuilder putInt(int i) {
		this.getChannelBuffer().writeInt(i);
		return this;
	}

	public PacketBuilder putInts(int[] i) {
		System.arraycopy(i, 0, this.getChannelBuffer(), this.getChannelBuffer().writerIndex(), i.length);
		return this;
	}

	public PacketBuilder putInt1(int i) {
		this.putByte((byte) (i >> 8)).putByte((byte) i).putByte((byte) (i >> 24)).putByte((byte) (i >> 16));
		return this;
	}

	public PacketBuilder putInt2(int i) {
		this.putByte((byte) (i >> 16)).putByte((byte) (i >> 24)).putByte((byte) i).putByte((byte) (i >> 8));
		return this;
	}

	public PacketBuilder putLEInt(int i) {
		this.putByte((byte) i).putByte((byte) (i >> 8)).putByte((byte) (i >> 16)).putByte((byte) (i >> 24));
		return this;
	}

	public PacketBuilder putLong(long l) {
		this.getChannelBuffer().writeLong(l);
		return this;
	}

	public PacketBuilder putString(String s) {
		this.putBytes(s.getBytes()).putByte((byte) '\n');
		return this;
	}

	public PacketBuilder putSmart(int i) {
		if (i < 128) {
			return this.putByte((byte) i);
		}
		return this.putShort((short) i);
	}

	public boolean isEmpty() {
		return this.getChannelBuffer().writerIndex() <= 0;
	}

	public PacketBuilder startBitAccess() {
		this.setBitPosition(this.getChannelBuffer().writerIndex() * 8);
		return this;
	}

	public PacketBuilder finishBitAccess() {
		this.getChannelBuffer().writerIndex((this.getBitPosition() + 7) / 8);
		return this;
	}

	public PacketBuilder putBits(int numBits, int value) {
		int bytes = (int) Math.ceil(numBits / 8D) + 1;
		this.getChannelBuffer().ensureWritableBytes(((this.getBitPosition() + 7) / 8) + bytes);
		byte[] buffer = this.getChannelBuffer().array();
		int bytePos = this.getBitPosition() >> 3;
		int bitOffset = 8 - (this.getBitPosition() & 7);
		this.bitPosition += numBits;
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

	public static void setBitMask(int[] bitMask) {
		PacketBuilder.bitMask = bitMask;
	}

	public static int[] getBitMask() {
		return PacketBuilder.bitMask;
	}

	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}

	public int getOpcode() {
		return this.opcode;
	}

	public void setBitPosition(int bitPosition) {
		this.bitPosition = bitPosition;
	}

	public int getBitPosition() {
		return this.bitPosition;
	}

	public void setPacketType(PacketType packetType) {
		this.packetType = packetType;
	}

	public PacketType getPacketType() {
		return this.packetType;
	}

	public void setChannelBuffer(ChannelBuffer channelBuffer) {
		this.channelBuffer = channelBuffer;
	}

	public ChannelBuffer getChannelBuffer() {
		return this.channelBuffer;
	}
}