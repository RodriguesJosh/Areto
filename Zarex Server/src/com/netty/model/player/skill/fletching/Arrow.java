package com.netty.model.player.skill.fletching;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:39:54 AM
 */
public enum Arrow {

	/**
	 * 
	 */
	SHAFTS,

	/**
	 * 
	 */
	HEADLESS,

	/**
	 * 
	 */
	BRONZE,

	/**
	 * 
	 */
	IRON,

	/**
	 * 
	 */
	STEEL,

	/**
	 * 
	 */
	MITHRIL,

	/**
	 * 
	 */
	BROAD_LEAF,

	/**
	 * 
	 */
	ADAMANT,

	/**
	 * 
	 */
	RUNE,

	/**
	 * 
	 */
	DRAGON;

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
	 */
	private int experienceSet;

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

	/**
	 * 
	 * @param experienceSet
	 * 			The id to set.
	 */
	public void setExperienceSet(int experienceSet) {
		this.experienceSet = experienceSet;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getExperienceSet() {
		return this.experienceSet;
	}
}