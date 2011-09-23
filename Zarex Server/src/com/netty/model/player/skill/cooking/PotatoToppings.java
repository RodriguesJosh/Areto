package com.netty.model.player.skill.cooking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:38:48 PM
 */
public enum PotatoToppings {

	/**
	 * 
	 */
	SPICY_SAUCE,

	/**
	 * 
	 */
	CHILLI_CON_CARNE,

	/**
	 * 
	 */
	SCRAMBLED_EGG,

	/**
	 * 
	 */
	EGG_TOMATO,

	/**
	 * 
	 */
	FRIED_ONIONS,

	/**
	 * 
	 */
	FRIED_MUSHROOMS,

	/**
	 * 
	 */
	MUSHROOM_AND_ONION,

	/**
	 * 
	 */
	TUNA_AND_CORN;

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
	private PotatoToppings() {
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
}