package com.netty.model.player.skill.cooking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:38:15 PM
 */
public enum Snails {

	/**
	 * 
	 */
	THIN_SNAIL(0, 0, 0, 0),

	/**
	 * 
	 */
	LEAN_SNAIL(0, 0, 0, 0),

	/**
	 * 
	 */
	FAT_SNAIL(0, 0, 0, 0);

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
	private Snails(int id, int level, int experience, int healthGained) {
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