package com.netty.model.player.skill.cooking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:40:46 PM
 */
public enum Meat {

	/**
	 * 
	 */
	COOKED_MEAT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	COOKED_CHICKEN(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	UGTHANKI_MEAT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	COOKED_RABBIT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	ROASTED_BIRD_MEAT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	ROASTED_RABBIT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	SPIDER_ON_STICK(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	SPIDER_ON_SHAFT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	CRAB_MEAT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	ROASTED_BEAST_MEAT(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	COOKED_CHOMPY(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	COOKED_JUBBLY(0, 0, 0, 0, 0, 0),

	/**
	 * 
	 */
	OOMLIE_WRAP(0, 0, 0, 0, 0, 0);

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
	private int raw;

	/**
	 * 
	 */
	private int cooked;

	/**
	 * 
	 */
	private int burnt;

	/**
	 * 
	 */
	private int healthGained;

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 * @param raw
	 * 			The id to set.
	 * @param cooked
	 * 			The id to set.
	 * @param burnt
	 * 			The id to set.
	 * @param healthGained
	 * 			The id to set.
	 */
	private Meat(int level, int experience, int raw, int cooked, int burnt, int healthGained) {
		this.setLevel(level);
		this.setExperience(experience);
		this.setRaw(raw);
		this.setCooked(cooked);
		this.setBurnt(burnt);
		this.setHealthGained(healthGained);
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
	 * @param raw
	 * 			The id to set.
	 */
	public void setRaw(int raw) {
		this.raw = raw;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getRaw() {
		return this.raw;
	}

	/**
	 * 
	 * @param cooked
	 * 			The id to set.
	 */
	public void setCooked(int cooked) {
		this.cooked = cooked;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCooked() {
		return this.cooked;
	}

	/**
	 * 
	 * @param burnt
	 * 			The id to set.
	 */
	public void setBurnt(int burnt) {
		this.burnt = burnt;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getBurnt() {
		return this.burnt;
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