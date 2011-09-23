package com.netty.model.player.minigame.greatorbproject;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:53:25 PM
 */
public enum Reward {

	/**
	 * 
	 */
	NONE,

	/**
	 * 
	 */
	RUNECRAFTER_HAT,

	/**
	 * 
	 */
	RUNECRAFTER_ROBE,

	/**
	 * 
	 */
	RUNECRAFTER_SKIRT,

	/**
	 * 
	 */
	RUNECRAFTER_GLOVES;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 * @param item
	 *			The id to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Item getItem() {
		return this.item;
	}
}