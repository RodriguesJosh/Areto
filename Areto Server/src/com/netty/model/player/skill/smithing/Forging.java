package com.netty.model.player.skill.smithing;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:31:27 AM
 */
public enum Forging {

	/**
	 * 
	 */
	DAGGER,

	/**
	 * 
	 */
	AXE,

	/**
	 * 
	 */
	CHAIN_BODY,

	/**
	 * 
	 */
	MEDIUM_HELM,

	/**
	 * 
	 */
	DART_TIPS,

	/**
	 * 
	 */
	BOLTS,

	/**
	 * 
	 */
	SWORD,

	/**
	 * 
	 */
	MACE,

	/**
	 * 
	 */
	PLATE_LEGS,

	/**
	 * 
	 */
	FULL_HELM,

	/**
	 * 
	 */
	ARROWTIPS,

	/**
	 * 
	 */
	LIMBS,

	/**
	 * 
	 */
	SCIMITAR,

	/**
	 * 
	 */
	WARHAMMER,

	/**
	 * 
	 */
	PLATE_SKIRT,

	/**
	 * 
	 */
	SQUARE_SHIELD,

	/**
	 * 
	 */
	THROWING_KNIVES,

	/**
	 * 
	 */
	LONG_SWORD,

	/**
	 * 
	 */
	BATTLE_AXE,

	/**
	 * 
	 */
	PLATE_BODY,

	/**
	 * 
	 */
	KITE_SHIELD,

	/**
	 * 
	 */
	STUDS,

	/**
	 * 
	 */
	TWO_HAND_SWORD,

	/**
	 * 
	 */
	CLAWS,

	/**
	 * 
	 */
	BULLSEYE_LANTERN,

	/**
	 * 
	 */
	NAILS;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private int level;

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

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}
}