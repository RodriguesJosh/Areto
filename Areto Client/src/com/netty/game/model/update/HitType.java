package com.netty.game.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:01:08 PM
 */
public enum HitType {

	/**
	 * 
	 */
	NONE((byte) 0),

	/**
	 * 
	 */
	NORMAL((byte) 1),

	/**
	 * 
	 */
	POISON((byte) 2),

	/**
	 * 
	 */
	DISEASE((byte) 3);

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