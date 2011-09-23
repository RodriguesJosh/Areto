package com.netty.model.combat.range;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:41:55 AM
 */
public class Amo {

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