package com.netty.net.packet;

import org.jboss.netty.buffer.ChannelBuffer;

import com.netty.util.LoginUtility;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:16:05 PM
 */
public class Packet {

	/**
	 * 
	 */
	private int opcode;

	/**
	 * 
	 */
	private PacketType packetType;

	/**
	 * 
	 */
	private ChannelBuffer channelBuffer;

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 * @param packetType
	 * 			The id to set.
	 * @param channelBuffer
	 * 			The id to set.
	 */
	public Packet(int opcode, PacketType packetType, ChannelBuffer channelBuffer) {
		this.setOpcode(opcode);
		this.setPacketType(packetType);
		this.setChannelBuffer(channelBuffer);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCapacity() {
		return this.getChannelBuffer().capacity();
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getByte() {
		return this.getChannelBuffer().readByte();
	}

	/**
	 * 
	 * @param b
	 * 			The id to set.
	 */
	public void getBytes(byte[] b) {
		this.getChannelBuffer().readBytes(b);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getUnsignedByte() {
		return this.getChannelBuffer().readByte() & 0xff;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getShort() {
		return this.getChannelBuffer().readShort();
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getUnsignedShort() {
		return this.getChannelBuffer().readShort() & 0xffff;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getInt() {
		return this.getChannelBuffer().readInt();
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public long getLong() {
		return this.getChannelBuffer().readLong();
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getByteC() {
		return (byte) (-this.getByte());
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getByteS() {
		return (byte) (128 - this.getByte());
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getLEShortA() {
		int i = ((this.getByte() - 128) & 0xFF) | ((this.getByte() & 0xFF) << 8);
		if (i > 32767) {
			i -= 0x10000;
		}
		return (short) i;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getLEShort() {
		int i = (this.getByte() & 0xFF) | ((this.getByte() & 0xFF) << 8);
		if (i > 32767) {
			i -= 0x10000;
		}
		return (short) i;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getInt1() {
		byte b1 = this.getByte();
		byte b2 = this.getByte();
		byte b3 = this.getByte();
		byte b4 = this.getByte();
		return ((b3 << 24) & 0xFF) | ((b4 << 16) & 0xFF) | ((b1 << 8) & 0xFF) | (b2 & 0xFF);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getInt2() {
		int b1 = this.getByte() & 0xFF;
		int b2 = this.getByte() & 0xFF;
		int b3 = this.getByte() & 0xFF;
		int b4 = this.getByte() & 0xFF;
		return ((b2 << 24) & 0xFF) | ((b1 << 16) & 0xFF) | ((b4 << 8) & 0xFF) | (b3 & 0xFF);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getTriByte() {
		return ((this.getByte() << 16) & 0xFF) | ((this.getByte() << 8) & 0xFF) | (this.getByte() & 0xFF);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getByteA() {
		return (byte) (this.getByte() - 128);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getRS2String() {
		return LoginUtility.getString(this.getChannelBuffer());
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getShortA() {
		int i = ((this.getByte() & 0xFF) << 8) | ((this.getByte() - 128) & 0xFF);
		if (i > 32767) {
			i -= 0x10000;
		}
		return (short) i;
	}

	/**
	 * 
	 * @param is
	 * 			The id to set.
	 * @param offset
	 * 			The id to set.
	 * @param length
	 * 			The id to set.
	 */
	public void getReverse(byte[] is, int offset, int length) {
		for (int i = ((offset + length) - 1); i >= offset; i--) {
			is[i] = this.getByte();
		}
	}

	/**
	 * 
	 * @param is
	 * 			The id to set.
	 * @param offset
	 * 			The id to set.
	 * @param length
	 * 			The id to set.
	 */
	public void getReverseA(byte[] is, int offset, int length) {
		for (int i = ((offset + length) - 1); i >= offset; i--) {
			is[i] = this.getByteA();
		}
	}

	/**
	 * 
	 * @param amount
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public byte[] getReverseA(int amount) {
		byte[] data = new byte[amount];
		int dataPosition = 0;
		for (int i = (this.getChannelBuffer().arrayOffset() + amount) - 1; i >= this.getChannelBuffer().arrayOffset(); i--) {
			int value = this.getChannelBuffer().getByte(i);
			value -= 128;
			data[dataPosition++] = (byte) value;
		}
		return data;
	}

	/**
	 * 
	 * @param is
	 * 			The id to set.
	 * @param offset
	 * 			The id to set.
	 * @param length
	 * 			The id to set.
	 */
	public void get(byte[] is, int offset, int length) {
		for (int i = 0; i < length; i++) {
			is[offset + i] = this.getByte();
		}
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getSmart() {
		int peek = this.getChannelBuffer().getByte(this.getChannelBuffer().readerIndex());
		if (peek < 128) {
			return (this.getByte() & 0xFF);
		}
		return (this.getShort() & 0xFFFF) - 32768;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getSignedSmart() {
		int peek = this.getChannelBuffer().getByte(this.getChannelBuffer().readerIndex());
		if (peek < 128) {
			return ((this.getByte() & 0xFF) - 64);
		}
		return ((this.getShort() & 0xFFFF) - 49152);
	}

	/**
	 * 
	 * @param opcode
	 * 			The id to set.
	 */
	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getOpcode() {
		return this.opcode;
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