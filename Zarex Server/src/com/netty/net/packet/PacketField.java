package com.netty.net.packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:39:54 PM
 */
public class PacketField {

	/**
	 * 
	 */
	private PacketFieldType packetFieldType;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private byte repeatedAmount;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param packetFieldType
	 * 			The id to set.
	 * @param repeatedAmount
	 * 			The id to set.
	 */
	public PacketField(String name, PacketFieldType packetFieldType, byte repeatedAmount) {
		this.setName(name);
		this.setPacketFieldType(packetFieldType);
		this.setRepeatedAmount(repeatedAmount);
	}

	/**
	 * 
	 * @param packetFieldType
	 * 			The id to set.
	 */
	public void setPacketFieldType(PacketFieldType packetFieldType) {
		this.packetFieldType = packetFieldType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketFieldType getPacketFieldType() {
		return this.packetFieldType;
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param repeatedAmount
	 * 			The id to set.
	 */
	public void setRepeatedAmount(byte repeatedAmount) {
		this.repeatedAmount = repeatedAmount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getRepeatedAmount() {
		return this.repeatedAmount;
	}
}