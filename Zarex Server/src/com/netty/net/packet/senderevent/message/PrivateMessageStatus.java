package com.netty.net.packet.senderevent.message;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 3:51:08 PM
 */
public enum PrivateMessageStatus {

	/**
	 * 
	 */
	ONLINE((byte) 0),

	/**
	 * 
	 */
	OFFLINE((byte) 1),

	/**
	 * 
	 */
	AWAY((byte) 2);

	/**
	 * 
	 */
	private byte statusID;

	/**
	 * 
	 * 
	 * @param statusID
	 */
	private PrivateMessageStatus(byte statusID) {
		this.setStatusID(statusID);
	}

	/**
	 * 
	 * @param statusID
	 * 			The statusID to set.
	 */
	public void setStatusID(byte statusID) {
		this.statusID = statusID;
	}

	/**
	 * 
	 * @return statusID
	 * 			Returns the statusID to get.
	 */
	public byte getStatusID() {
		return this.statusID;
	}
}