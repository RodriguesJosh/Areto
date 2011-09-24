package com.netty.model.player.tab.clan.citadels;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:50:45 PM
 */
public class ClanRing {

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private byte experienceBoost;

	/**
	 * 
	 * @param item
	 * 			The item to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return item
	 * 			Returns the item to get.
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param experienceBoost
	 * 			The experienceBoost to set.
	 */
	public void setExperienceBoost(byte experienceBoost) {
		this.experienceBoost = experienceBoost;
	}

	/**
	 * 
	 * @return experienceBoost
	 * 			Returns the experienceBoost to get.
	 */
	public byte getExperienceBoost() {
		return this.experienceBoost;
	}
}