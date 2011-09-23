package com.netty.model.player.skill.cooking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:52:06 PM
 */
public enum Brewing {

	/**
	 * 
	 */
	CIDER,

	/**
	 * 
	 */
	DWARVEN_STOUT,

	/**
	 * 
	 */
	ASGARNIAN_ALE,

	/**
	 * 
	 */
	GREENMANS_ALE,

	/**
	 * 
	 */
	WIZARDS_MIND_BOMB,

	/**
	 * 
	 */
	DRAGON_BITTER,

	/**
	 * 
	 */
	MOONLIGHT_MEAD,

	/**
	 * 
	 */
	AXEMANS_FOLLY,

	/**
	 * 
	 */
	CHEFS_DELIGHT,

	/**
	 * 
	 */
	SLAYERS_RESPITE;

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private int healthGained;

	/**
	 * 
	 */
	private int[] boost;

	/**
	 * 
	 */
	private Brewing() {
		//
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

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

	/**
	 * 
	 * @param healthGained
	 * 			The id to set.
	 */
	public void setHealthGained(int healthGained) {
		this.healthGained = healthGained;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getHealthGained() {
		return this.healthGained;
	}

	/**
	 * 
	 * @param boost
	 * 			The id to set.
	 */
	public void setBoost(int[] boost) {
		this.boost = boost;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int[] getBoost() {
		return this.boost;
	}
}