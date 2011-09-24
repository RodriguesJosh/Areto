package com.netty.model.player.skill.hunter;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:52:29 AM
 */
public enum Bait {

	/**
	 * 
	 */
	TRACK,

	/**
	 * 
	 */
	SNARE,

	/**
	 * 
	 */
	BUTTERFLY_NET_AND_JAR,

	/**
	 * 
	 */
	DEADFALL,

	/**
	 * 
	 */
	BOXTRAP,

	/**
	 * 
	 */
	FERRET_AND_RABBIT_SNARE,

	/**
	 * 
	 */
	NET_TRAP,

	/**
	 * 
	 */
	PITFALL,

	/**
	 * 
	 */
	FALCONRY,

	/**
	 * 
	 */
	NOOSE_WAND,

	/**
	 * 
	 */
	MAGIC_BOX,

	/**
	 * 
	 */
	RAW_MEAT,
	/**
	 * 
	 */
	RAW_RAINBOWFISH,

	/**
	 * 
	 */
	BARLEY,

	/**
	 * 
	 */
	SMOUDLERING_FEVER_GRASS_LURE,

	/**
	 * 
	 */
	RAW_COD_BAIT,

	/**
	 * 
	 */
	BANANA,

	/**
	 * 
	 */
	SMOULDERING_LAVENDER_LURE,

	/**
	 * 
	 */
	SPICY_CHOPPED_TOMATO,

	/**
	 * 
	 */
	RAW_COD,

	/**
	 * 
	 */
	SPICY_MINCED_MEAT,

	/**
	 * 
	 */
	PAPAYA,

	/**
	 * 
	 */
	RAW_PAPAYA_MEAT,

	/**
	 * 
	 */
	NUTS,

	/**
	 * 
	 */
	GUAM_TAR,

	/**
	 * 
	 */
	MARRENTILL_TAR,

	/**
	 * 
	 */
	TARROMIN_TAR,

	/**
	 * 
	 */
	HARRALANDER_TAR,

	/**
	 * 
	 */
	MAGICAL_BEAD,

	/**
	 * 
	 */
	SPRITE_LURE;

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