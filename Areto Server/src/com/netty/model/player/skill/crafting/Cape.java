package com.netty.model.player.skill.crafting;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:33:44 AM
 */
public enum Cape {

	/**
	 * 
	 */
	RED_CAPE(0, 2),

	/**
	 * 
	 */
	YELLOW_CAPE(0, 2),

	/**
	 * 
	 */
	BLUE_CAPE(0, 2),

	/**
	 * 
	 */
	PINK_CAPE(0, 2),

	/**
	 * 
	 */
	ORANGE_CAPE(0, 2),

	/**
	 * 
	 */
	PURPLE_CAPE(0, 2),

	/**
	 * 
	 */
	GREEN_CAPE(0, 2),

	/**
	 * 
	 */
	BLACK_CAPE(0, 2);

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 */
	private Cape(int id, int experience) {
		this.setID(id);
		this.setExperience(experience);
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