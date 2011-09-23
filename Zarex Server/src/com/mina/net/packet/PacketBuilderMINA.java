package com.mina.net.packet;

import org.apache.mina.core.buffer.IoBuffer;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.PacketType;

/**
 * A packet building class to build packets that
 * we will use for the MINA networking API.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:12:15 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PacketBuilderMINA extends PacketBuilder {

	/**
	 * The IoBuffer declaration to write and get
	 * certain values.
	 */
	private IoBuffer ioBuffer;

	/**
	 * Constructs a new building of a packet
	 * to build and eventually send.
	 */
	public PacketBuilderMINA() {
		super((short) -1);
	}

	/**
	 * Constructs a new packet with a given
	 * opcode to set.
	 * 
	 * @param opcode
	 * 			The type of opcode for the packet.
	 */
	public PacketBuilderMINA(short opcode) {
		super(opcode, PacketType.FIXED);
	}

	/**
	 * Construts a new building of the packet
	 * with a given opcode and type of packet.
	 * 
	 * @param opcode
	 * 			The type of opcode for the packet.
	 * @param packetType
	 * 			The type of packet this building
	 * 			of the packet is.
	 */
	public PacketBuilderMINA(short opcode, PacketType packetType) {
		super(opcode, packetType);
	}

	/**
	 * Creates a new packet to send once it is all
	 * done building it.
	 * 
	 * @return new Packet
	 * 			Returns a new packet with the given
	 * 			opcode, type of packet and the IoBuffer
	 * 			it is associated with.
	 */
	public PacketMINA toPacketMINA() {
		return new PacketMINA(this.getOpcode(), this.getPacketType(), this.getIOBuffer());
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putByte(byte)
	 */
	@Override
	public PacketBuilderMINA putByte(byte b) {
		this.getIOBuffer().put(b);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putBytes(byte[])
	 */
	@Override
	public PacketBuilderMINA putBytes(byte[] b) {
		this.getIOBuffer().put(b);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putByteA(int)
	 */
	@Override
	public PacketBuilderMINA putByteA(int b) {
		this.getIOBuffer().put((byte) (b + 128));
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putBytes(byte[], int, int)
	 */
	@Override
	public PacketBuilderMINA putBytes(byte[] b, int position, int length) {
		this.getIOBuffer().put(b, position, length);
		return this;
	}

	/**
	 * Writes an IoBuffer into the packet builder's
	 * IoBuffer.
	 * 
	 * @param ioBuffer
	 * 			The IoBuffer to write.
	 * @return this
	 * 			Returns this for packet chaining.
	 */
	public PacketBuilderMINA putBytes(IoBuffer ioBuffer) {
		this.getIOBuffer().put(ioBuffer);
		return this;
	}

	/**
	 * Writes a short into the IoBuffer.
	 * 
	 * @param s
	 * 			The primitive data type to write
	 * 			into the buffer.
	 * @return this
	 * 			Returns this for packet chaining.
	 */
	public PacketBuilderMINA putShort(short s) {
		this.getIOBuffer().putShort(s);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putInt(int)
	 */
	@Override
	public PacketBuilderMINA putInt(int i) {
		this.getIOBuffer().putInt(i);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putInts(int[])
	 */
	@Override
	public PacketBuilderMINA putInts(int[] i) {
		System.arraycopy(i, 0, this.getIOBuffer(), this.getIOBuffer().position(), i.length);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putLong(long)
	 */
	@Override
	public PacketBuilderMINA putLong(long l) {
		this.getIOBuffer().putLong(l);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#startBitAccess()
	 */
	@Override
	public PacketBuilderMINA startBitAccess() {
		this.setBitPosition((short) (this.getIOBuffer().position() * 8));
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#finishBitAccess()
	 */
	@Override
	public PacketBuilderMINA finishBitAccess() {
		this.getIOBuffer().position((this.getBitPosition() + 7) / 8);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.net.packet.PacketBuilder#putBits(int, int)
	 */
	@Override
	public PacketBuilderMINA putBits(int numBits, int value) {
		// int bytes = (int) Math.ceil(numBits / 8D) + 1;
		// this.getIOBuffer().ensureWritableBytes(((this.getBitPosition() + 7) / 8) + bytes);
		byte[] buffer = this.getIOBuffer().array();
		int bytePos = this.getBitPosition() >> 3;
		int bitOffset = 8 - (this.getBitPosition() & 7);
		int bitPosition = this.getBitPosition();
		bitPosition += numBits;
		this.setBitPosition((short) bitPosition);
		for (; numBits > bitOffset; bitOffset = 8) {
			buffer[bytePos] &= ~ PacketBuilder.getBitMask()[bitOffset];
			buffer[bytePos++] |= (value >> (numBits - bitOffset)) & PacketBuilder.getBitMask()[bitOffset];
			// int bitsNum = numBits;
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
	 * Sets the IoBuffer associated with this
	 * packet.
	 * 
	 * @param ioBuffer
	 * 			The IoBuffer for this packet.
	 */
	public void setIOBuffer(IoBuffer ioBuffer) {
		this.ioBuffer = ioBuffer;
	}

	/**
	 * Gets the IoBuffer associated with this
	 * packet.
	 * 
	 * @return ioBuffer
	 * 			Returns the IoBuffer for this
	 * 			packet.
	 */
	public IoBuffer getIOBuffer() {
		return this.ioBuffer;
	}
}