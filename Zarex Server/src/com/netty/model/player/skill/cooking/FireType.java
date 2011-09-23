package com.netty.model.player.skill.cooking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:43:37 PM
 */
public enum FireType {

	/**
	 * 
	 */
	RANGE(0),

	/**
	 * 
	 */
	LOG_FIRE(0);

	/**
	 * 
	 */
	private int objectID;

	/**
	 * 
	 * @param objectID
	 * 			The id to set.
	 */
	private FireType(int objectID) {
		this.setObjectID(objectID);
	}

	/**
	 * 
	 * @param objectID
	 * 			The id to set.
	 */
	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getObjectID() {
		return this.objectID;
	}
}