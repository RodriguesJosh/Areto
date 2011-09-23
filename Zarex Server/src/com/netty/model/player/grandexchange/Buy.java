package com.netty.model.player.grandexchange;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:53:30 PM
 */
public class Buy {

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 */
	public Buy(Item item) {
		this.setItem(item);
	}

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
}