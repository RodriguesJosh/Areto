package com.netty.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:40:06 PM
 */
public enum HitType {

	/**
	 * 
	 */
	NO_DAMAGE((byte) 0),

	/**
	 * 
	 */
	NORMAL_DAMAGE((byte) 1),

	/**
	 * 
	 */
	POISON_DAMAGE((byte) 2),

	/**
	 * 
	 */
	DISEASE_DAMAGE((byte) 3);

	/**
	 * 
	 */
	private byte hitID;

	/**
	 * 
	 * @param hitID
	 * 			The id to set.
	 */
	private HitType(byte hitID) {
		this.setHitID(hitID);
	}

	/**
	 * 
	 * @param hitID
	 * 			The id to set.
	 */
	public void setHitID(byte hitID) {
		this.hitID = hitID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getHitID() {
		return this.hitID;
	}
}