package com.netty.world;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:59:24 AM
 */
public enum Revision {

	/**
	 * 
	 */
	THREE_ONE_SEVEN((short) 317),

	/**
	 * 
	 */
	FOUR_SEVEN_FOUR((short) 474),

	/**
	 * 
	 */
	FIVE_OH_EIGHT((short) 508),

	/**
	 * 
	 */
	FIVE_SIXTY_TWO((short) 562),

	/**
	 * 
	 */
	SIX_OH_ONE((short) 601),

	/**
	 * 
	 */
	SIX_FOURTEEN((short) 614),

	/**
	 * 
	 */
	SIX_THIRTY_FOUR((short) 634);

	/**
	 * 
	 */
	private short revisionID;

	/**
	 * 
	 * @param revisionID
	 * 			The id to set.
	 */
	private Revision(short revisionID) {
		this.setRevisionID(revisionID);
	}

	/**
	 * 
	 * @param revisionID
	 * 			The id to set.
	 */
	public void setRevisionID(short revisionID) {
		this.revisionID = revisionID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getRevisionID() {
		return this.revisionID;
	}
}