package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:31:28 AM
 */
public enum Glass {

	/**
	 * 
	 */
	BEER_GLASS,

	/**
	 * 
	 */
	CANDLE_LANTERN,

	/**
	 * 
	 */
	OIL_LAMP,

	/**
	 * 
	 */
	VIAL,

	/**
	 * 
	 */
	FISH_BOWL,

	/**
	 * 
	 */
	UNPOWERED_ORB,

	/**
	 * 
	 */
	LANTERN_LENS,

	/**
	 * 
	 */
	EMPTY_LIGHT_ORB;

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
	private int experience;

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