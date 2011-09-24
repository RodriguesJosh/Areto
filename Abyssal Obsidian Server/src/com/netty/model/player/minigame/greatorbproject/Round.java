package com.netty.model.player.minigame.greatorbproject;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:53:02 PM
 */
public enum Round {

	/**
	 * 
	 */
	AIR_ALTAR(false),

	/**
	 * 
	 */
	MIND_ALTAR(false),

	/**
	 * 
	 */
	WATER_ALTAR(false),

	/**
	 * 
	 */
	EARTH_ALTAR(false),

	/**
	 * 
	 */
	FIRE_ALTAR(false),

	/**
	 * 
	 */
	BODY_ALTAR(false),

	/**
	 * 
	 */
	CHAOS_ALTAR(true),

	/**
	 * 
	 */
	NATURE_ALTAR(true);

	/**
	 * 
	 */
	private boolean isMembers;

	/**
	 * 
	 * @param isMembers
	 *			The id to set.
	 */
	private Round(boolean isMembers) {
		this.setMembers(isMembers);
	}

	/**
	 * 
	 * @param isMembers
	 *			The id to set.
	 */
	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public boolean isMembers() {
		return this.isMembers;
	}
}