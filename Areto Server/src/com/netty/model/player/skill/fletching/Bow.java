package com.netty.model.player.skill.fletching;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:41:57 AM
 */
public enum Bow {

	/**
	 * 
	 */
	SHORT,

	/**
	 * 
	 */
	LONG,

	/**
	 * 
	 */
	OAK_SHORT,

	/**
	 * 
	 */
	OAK_LONG,

	/**
	 * 
	 */
	WILLOW_SHORT,

	/**
	 * 
	 */
	WILLOW_LONG,

	/**
	 * 
	 */
	MAPLE_SHORT,

	/**
	 * 
	 */
	MAPLE_LONG,

	/**
	 * 
	 */
	YEW_SHORT,

	/**
	 * 
	 */
	YEW_LONG,

	/**
	 * 
	 */
	MAGIC_SHORT,

	/**
	 * 
	 */
	MAGIC_LONG;

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