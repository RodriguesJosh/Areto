package com.netty.net.packet;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:14:33 PM
 */
public class PacketBuilder {

	/**
	 * 
	 */
	private static int[] bitMask = new int[32];

	/**
	 * 
	 */
	private short opcode;

	/**
	 * 
	 */
	private short bitPosition;

	/**
	 * 
	 */
	private PacketType packetType;

	/**
	 * 
	 */
	private ChannelBuffer channelBuffer = ChannelBuffers.dynamicBuffer();

	/**
	 * 
	 */
	static {
		for (int i = 0; i < PacketBuilder.getBitMask().length; i++) {
			PacketBuilder.getBitMask()[i] = (1 << i) - 1;
		}
	}

	/**
	 * 
	 */
	public PacketBuilder() {
		this((short) -1);
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 */
	public PacketBuilder(short opcode) {
		this(opcode, PacketType.FIXED);
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 * @param packetType
	 * 			The id to set.
	 */
	public PacketBuilder(short opcode, PacketType packetType) {
		this.setOpcode(opcode);
		this.setPacketType(packetType);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Packet toPacket() {
		return new Packet(this.getOpcode(), this.getPacketType(), this.getChannelBuffer().copy());
	}

	/**
	 * 
	 * @param b
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putByte(byte b) {
		this.getChannelBuffer().writeByte(b);
		return this;
	}

	/**
	 * 
	 * @param b
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putBytes(byte[] b) {
		this.getChannelBuffer().writeBytes(b);
		return this;
	}

	/**
	 * 
	 * @param channelBuffer
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putBytes(ChannelBuffer channelBuffer) {
		this.getChannelBuffer().writeBytes(channelBuffer);
		return this;
	}

	/**
	 * 
	 * @param b
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putByteA(int b) {
		this.getChannelBuffer().writeByte((byte) (b + 128));
		return this;
	}

	/**
	 * 
	 * @param data
	 * 			The id to set.
	 * @param length
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putBytesA(byte[] data, int length) {
		for (int i = 0; i < length; i ++) {
			this.putByte((byte) (data[i] + 128));
		}
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putByteC(int i) {
		this.putByte((byte) -i);
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putByteS(int i) {
		this.putByte((byte) (128 - i));
		return this;
	}

	/**
	 * 
	 * @param b
	 * 			The id to set.
	 * @param position
	 * 			The id to set.
	 * @param length
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putBytes(byte[] b, int position, int length) {
		this.getChannelBuffer().writeBytes(b, position, length);
		return this;
	}

	/**
	 * 
	 * @param channelBuffer
	 * 			The id to set.
	 * @param position
	 * 			The id to set.
	 * @param length
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putBytes(ChannelBuffer channelBuffer, int position, int length) {
		this.getChannelBuffer().writeBytes(channelBuffer, position, length);
		return this;
	}

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putShort(int s) {
		this.getChannelBuffer().writeShort(s);
		return this;
	}

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putLEShort(int s) {
		this.putByte((byte) s).putByte((byte) (s >> 8));
		return this;
	}

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putShortA(int s) {
		this.putByte((byte) (s >> 8)).putByte((byte) (s + 128));
		return this;
	}

	/**
	 * 
	 * @param b
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putLEShortA(int b) {
		this.putByte((byte) (b + 128)).putByte((byte) (b >> 8));
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putInt(int i) {
		this.getChannelBuffer().writeInt(i);
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putInts(int[] i) {
		System.arraycopy(i, 0, this.getChannelBuffer(), this.getChannelBuffer().writerIndex(), i.length);
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putInt1(int i) {
		this.putByte((byte) (i >> 8)).putByte((byte) i).putByte((byte) (i >> 24)).putByte((byte) (i >> 16));
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putInt2(int i) {
		this.putByte((byte) (i >> 16)).putByte((byte) (i >> 24)).putByte((byte) i).putByte((byte) (i >> 8));
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putLEInt(int i) {
		this.putByte((byte) i).putByte((byte) (i >> 8)).putByte((byte) (i >> 16)).putByte((byte) (i >> 24));
		return this;
	}

	/**
	 * 
	 * @param l
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putLong(long l) {
		this.getChannelBuffer().writeLong(l);
		return this;
	}

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putString(String s) {
		this.putBytes(s.getBytes()).putByte((byte) '\n');
		return this;
	}

	/**
	 * 
	 * @param i
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder putSmart(int i) {
		if (i < 128) {
			return this.putByte((byte) i);
		}
		return this.putShort((short) i);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isEmpty() {
		return this.getChannelBuffer().writerIndex() <= 0;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder startBitAccess() {
		this.setBitPosition((short) (this.getChannelBuffer().writerIndex() * 8));
		return this;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketBuilder finishBitAccess() {
		this.getChannelBuffer().writerIndex((this.getBitPosition() + 7) / 8);
		return this;
	}

	/**
	 * 
	 * @param numBits
	 * 			The id to set.
	 * @param value
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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
			// numBits -= bitOffset;
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

	/**
	 * 
	 * @param bitMask
	 * 			The id to set.
	 */
	public static void setBitMask(int[] bitMask) {
		PacketBuilder.bitMask = bitMask;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static int[] getBitMask() {
		return PacketBuilder.bitMask;
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
	 * @param bitPosition
	 * 			The id to set.
	 */
	public void setBitPosition(short bitPosition) {
		this.bitPosition = bitPosition;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getBitPosition() {
		return this.bitPosition;
	}

	/**
	 * 
	 * @param packetType
	 * 			The id to set.
	 */
	public void setPacketType(PacketType packetType) {
		this.packetType = packetType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketType getPacketType() {
		return this.packetType;
	}

	/**
	 * 
	 * @param channelBuffer
	 * 			The id to set.
	 */
	public void setChannelBuffer(ChannelBuffer channelBuffer) {
		this.channelBuffer = channelBuffer;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChannelBuffer getChannelBuffer() {
		return this.channelBuffer;
	}
}