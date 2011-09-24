package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.magic;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:55:41 PM
 */
public enum MagicEquipmentSpell {

	/**
	 * 
	 */
	TELEPORT,

	/**
	 * 
	 */
	LEVITATION,

	/**
	 * 
	 */
	ALCHEMY,

	/**
	 * 
	 */
	ELEMENTAL;

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