package com.netty.net.packet;

public class PacketField {

	private PacketFieldType packetFieldType;
	private String name;
	private byte repeatedAmount;

	public PacketField(String name, PacketFieldType packetFieldType, byte repeatedAmount) {
		this.setName(name);
		this.setPacketFieldType(packetFieldType);
		this.setRepeatedAmount(repeatedAmount);
	}

	public void setPacketFieldType(PacketFieldType packetFieldType) {
		this.packetFieldType = packetFieldType;
	}

	public PacketFieldType getPacketFieldType() {
		return this.packetFieldType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setRepeatedAmount(byte repeatedAmount) {
		this.repeatedAmount = repeatedAmount;
	}

	public byte getRepeatedAmount() {
		return this.repeatedAmount;
	}
}