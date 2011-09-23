package com.netty.model.player.minigame.barrows;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:04:52 PM
 */
public class Chest {

	/**
	 * 
	 */
	private Item[] items;

	/**
	 * 
	 * @param items
	 * 			The items to set.
	 */
	public void setItems(Item[] items) {
		this.items = items;
	}

	/**
	 * 
	 * @return items
	 * 			Returns the items to get.
	 */
	public Item[] getItems() {
		return this.items;
	}
}