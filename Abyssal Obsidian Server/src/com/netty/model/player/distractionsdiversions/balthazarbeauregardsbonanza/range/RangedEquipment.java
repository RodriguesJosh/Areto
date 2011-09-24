package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.range;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 1:51:21 PM
 */
public enum RangedEquipment {

	/**
	 * 
	 */
	BOW,

	/**
	 * 
	 */
	KNIFE,

	/**
	 * 
	 */
	THROWING_AXE,

	/**
	 * 
	 */
	ARROW;

	/**
	 * 
	 */
	private Item rangedItem;

	/**
	 * 
	 * @param rangedItem
	 * 			The ranged Item to set.
	 */
	public void setRangedItem(Item rangedItem) {
		this.rangedItem = rangedItem;
	}

	/**
	 * 
	 * @return rangedItem
	 * 			Returns the ranged Item to get.
	 */
	public Item getRangedItem() {
		return this.rangedItem;
	}
}