package com.netty.model.player.skill.dungeoneering;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:03:40 AM
 */
public enum FloorType {

	/**
	 * 
	 */
	FROZEN,

	/**
	 * 
	 */
	ABANDONED_ONE,

	/**
	 * 
	 */
	FURNISHED,

	/**
	 * 
	 */
	ABANDONED_TWO,

	/**
	 * 
	 */
	OCCULT,

	/**
	 * 
	 */
	WARPED;

	/**
	 * 
	 */
	private boolean isMembers;

	/**
	 * 
	 * @param isMembers
	 * 			The id to set.
	 */
	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMembers() {
		return this.isMembers;
	}
}