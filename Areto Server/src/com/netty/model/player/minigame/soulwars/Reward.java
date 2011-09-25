package com.netty.model.player.minigame.soulwars;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:28:26 PM
 */
public enum Reward {

	/**
	 * 
	 */
	ATTACK, /** Floor(lvl(squared) / 600) * 525 */

	/**
	 * 
	 */
	STRENGTH,

	/**
	 * 
	 */
	DEFENCE,

	/**
	 * 
	 */
	CONSTITUTION,

	/**
	 * 
	 */
	RANGED, /** Floor(lvl(squared) / 600) * 480 */

	/**
	 * 
	 */
	MAGIC,

	/**
	 * 
	 */
	PRAYER, /** Floor(lvl(squared) / 600) * 270 */

	/**
	 * 
	 */
	SLAYER; /** 1 - 29 6.7 * 1.1052(level) */ /** 30 - 99 (0.002848 * level(squared) + 0.14 * log(1evel)) * 45 */

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getExperience() {
		return this.experience;
	}
}