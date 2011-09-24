package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:31:59 AM
 */
public enum Gem {

	/**
	 * 
	 */
	OPAL,

	/**
	 * 
	 */
	JADE,

	/**
	 * 
	 */
	RED_TOPAZ;

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
	private int cutExperience;

	/**
	 * 
	 */
	private int crushedExperience;

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
	 * @param cutExperience
	 * 			The id to set.
	 */
	public void setCutExperience(int cutExperience) {
		this.cutExperience = cutExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCutExperience() {
		return this.cutExperience;
	}

	/**
	 * 
	 * @param crushedExperience
	 * 			The id to set.
	 */
	public void setCrushedExperience(int crushedExperience) {
		this.crushedExperience = crushedExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCrushedExperience() {
		return this.crushedExperience;
	}
}