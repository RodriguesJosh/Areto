package com.netty.model.player.skill.runecrafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:31:16 AM
 */
public enum Tiara {

	/**
	 * 
	 */
	AIR_TIARA,

	/**
	 * 
	 */
	MIND_TIARA,

	/**
	 * 
	 */
	WATER_TIARA,

	/**
	 * 
	 */
	EARTH_TIARA,

	/**
	 * 
	 */
	FIRE_TIARA,

	/**
	 * 
	 */
	BODY_TIARA,

	/**
	 * 
	 */
	COSMIC_TIARA,

	/**
	 * 
	 */
	CHAOS_TIARA,

	/**
	 * 
	 */
	NATURE_TIARA,

	/**
	 * 
	 */
	LAW_TIARA,

	/**
	 * 
	 */
	DEATH_TIARA,

	/**
	 * 
	 */
	BLOOD_TIARA,

	/**
	 * 
	 */
	SOUL_TIARA, /**
	 * 
	 */
	OMNI_TIARA;

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