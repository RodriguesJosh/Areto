package com.netty.model.player.skill.runecrafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:30:26 AM
 */
public enum Talisman {

	/**
	 * 
	 */
	AIR_TALISMAN,

	/**
	 * 
	 */
	MIND_TALISMAN,

	/**
	 * 
	 */
	WATER_TALISMAN,

	/**
	 * 
	 */
	EARTH_TALISMAN,

	/**
	 * 
	 */
	FIRE_TALISMAN,

	/**
	 * 
	 */
	BODY_TALISMAN,

	/**
	 * 
	 */
	COSMIC_TALISMAN,

	/**
	 * 
	 */
	CHAOS_TALISMAN,

	/**
	 * 
	 */
	NATURE_TALISMAN,

	/**
	 * 
	 */
	LAW_TALISMAN,

	/**
	 * 
	 */
	DEATH_TALISMAN,

	/**
	 * 
	 */
	BLOOD_TALISMAN,

	/**
	 * 
	 */
	SOUL_TALISMAN,

	/**
	 * 
	 */
	ELEMENTAL_TALISMAN,

	/**
	 * 
	 */
	OMNI_TALISMAN;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private boolean isMembers;

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
	 * @param isMembers
	 * 			The id to set.
	 */
	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMembers() {
		return this.isMembers;
	}
}