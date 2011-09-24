package com.netty.net.packet.login;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:22:59 PM
 */
public enum ReturnCode {

	/**
	 * 
	 */
	INVALID_USER_PASS((byte) 3),

	/**
	 * 
	 */
	LOGIN((byte) 2),

	/**
	 * 
	 */
	ALREADY_LOGGED_IN((byte) 5),

	/**
	 * 
	 */
	NO_ACCOUNT((byte) 12);

	/**
	 * 
	 */
	private byte returnID;

	/**
	 * 
	 * @param returnID
	 * 			The id to set.
	 */
	private ReturnCode(byte returnID) {
		this.setReturnID(returnID);
	}

	/**
	 * 
	 * @param returnID
	 * 			The id to set.
	 */
	public void setReturnID(byte returnID) {
		this.returnID = returnID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getReturnID() {
		return this.returnID;
	}
}