package com.netty.model.player.skill.fletching;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:40:33 AM
 */
public enum Bolt {

	/**
	 * 
	 */
	BRONZE,

	/**
	 * 
	 */
	OPAL,

	/**
	 * 
	 */
	BLURITE,

	/**
	 * 
	 */
	JADE_TIPPED,

	/**
	 * 
	 */
	KEBBIT,

	/**
	 * 
	 */
	IRON,

	/**
	 * 
	 */
	PEARL_TIPPED,

	/**
	 * 
	 */
	LONG_KEBBIT,

	/**
	 * 
	 */
	SILVER,

	/**
	 * 
	 */
	STEEL,

	/**
	 * 
	 */
	RED_TOPAZ_TIPPED,

	/**
	 * 
	 */
	BARB_TIPPED,

	/**
	 * 
	 */
	MITHRIL,

	/**
	 * 
	 */
	BROAD_TIPPED,

	/**
	 * 
	 */
	SAPPHIRE_TIPPED,

	/**
	 * 
	 */
	EMERALD_TIPPED,

	/**
	 * 
	 */
	ADAMANT,

	/**
	 * 
	 */
	RUBY_TIPPED,

	/**
	 * 
	 */
	DIAMOND_TIPPED,

	/**
	 * 
	 */
	RUNITE,

	/**
	 * 
	 */
	DRAGONSTONE_TIPPED,

	/**
	 * 
	 */
	ONYX_TIPPED;

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
	private BoltType boltType;

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
	 * @param boltType
	 * 			The id to set.
	 */
	public void setBoltType(BoltType boltType) {
		this.boltType = boltType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BoltType getBoltType() {
		return this.boltType;
	}
}