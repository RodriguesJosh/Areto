package com.netty.model.player.skill.farming;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:05:29 AM
 */
public enum Tools {

	/**
	 * 
	 */
	RAKE,

	/**
	 * 
	 */
	DIBBER,

	/**
	 * 
	 */
	SPADE,

	/**
	 * 
	 */
	TROWEL,

	/**
	 * 
	 */
	SECATEURS,

	/**
	 * 
	 */
	WATERING_CAN,

	/**
	 * 
	 */
	SCARECROW,

	/**
	 * 
	 */
	BUCKET,

	/**
	 * 
	 */
	COMPOST,

	/**
	 * 
	 */
	SUPER_COMPOST,

	/**
	 * 
	 */
	PLANT_POTS,

	/**
	 * 
	 */
	HATCHET,

	/**
	 * 
	 */
	SACKS,

	/**
	 * 
	 */
	BASKETS,

	/**
	 * 
	 */
	PLANT_CURE,
	/**
	 * 
	 */
	GARDENING_BOOTS;

	/**
	 * 
	 */
	private Item item;

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
}