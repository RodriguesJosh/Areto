package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:27:32 AM
 */
public enum Staff {

	/**
	 * 
	 */
	WATER_BATTLESTAFF,

	/**
	 * 
	 */
	EARTH_BATTLESTAFF,

	/**
	 * 
	 */
	FIRE_BATTLESTAFF,

	/**
	 * 
	 */
	AIR_BATTLESTAFF;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private byte magicLevel;

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
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLevel() {
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
	 * @param magicLevel
	 * 			The id to set.
	 */
	public void setMagicLevel(byte magicLevel) {
		this.magicLevel = magicLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getMagicLevel() {
		return this.magicLevel;
	}
}