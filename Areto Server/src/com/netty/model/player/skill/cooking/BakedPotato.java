package com.netty.model.player.skill.cooking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:54:40 PM
 */
public enum BakedPotato {

	/**
	 * 
	 */
	BAKED_POTATO(0, 17, 15, 40),

	/**
	 * 
	 */
	POTATO_WITH_BUTTER(0, 39, 95, 140),

	/**
	 * 
	 */
	CHILLI_POTATO(0, 41, 165, 140),

	/**
	 * 
	 */
	POTATO_WITH_CHEESE(0, 47, 199, 160),

	/**
	 * 
	 */
	EGG_POTATO(0, 51, 195, 160),

	/**
	 * 
	 */
	MUSHROOM_ONION_POTATO(0, 64, 270, 200),

	/**
	 * 
	 */
	TUNA_POTATO(0, 68, 309, 220);

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
	 * @param id
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 * @param healthGained
	 * 			The id to set.
	 */
	private BakedPotato(int id, int level, int experience, int healthGained) {
		this.setID(id);
		this.setLevel(level);
		this.setExperience(experience);
		this.setHealthGained(healthGained);
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
}