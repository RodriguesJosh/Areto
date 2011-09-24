package com.netty.model.combat.magic;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:34:16 AM
 */
public class Staff {

	/**
	 * 
	 */
	private Item item;

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