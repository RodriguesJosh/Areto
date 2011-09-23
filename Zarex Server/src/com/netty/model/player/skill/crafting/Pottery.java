package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:29:00 AM
 */
public enum Pottery {

	/**
	 * 
	 */
	POT,

	/**
	 * 
	 */
	CLAY_RING,

	/**
	 * 
	 */
	PIE_DISH,

	/**
	 * 
	 */
	BOWL,

	/**
	 * 
	 */
	PLANT_POT,

	/**
	 * 
	 */
	POT_LID;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int mouldingExperience;

	/**
	 * 
	 */
	private int firingExperience;

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getItem() {
		return this.item;
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
	 * @param mouldingExperience
	 * 			The id to set.
	 */
	public void setMouldingExperience(int mouldingExperience) {
		this.mouldingExperience = mouldingExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getMouldingExperience() {
		return this.mouldingExperience;
	}

	/**
	 * 
	 * @param firingExperience
	 * 			The id to set.
	 */
	public void setFiringExperience(int firingExperience) {
		this.firingExperience = firingExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getFiringExperience() {
		return this.firingExperience;
	}
}