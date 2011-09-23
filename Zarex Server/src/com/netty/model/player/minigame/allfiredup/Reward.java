package com.netty.model.player.minigame.allfiredup;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:58:20 PM
 */
public enum Reward {

	/**
	 * 
	 */
	NONE(null, (byte) -1),

	/**
	 * 
	 */
	RING_OF_FIRE(null, (byte) 62),

	/**
	 * 
	 */
	FLAME_GLOVES(null, (byte) 79),

	/**
	 * 
	 */
	INFERNO_ADZE(null, (byte) 92);

	/**
	 * 
	 */
	private Item item;
	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 */
	private Reward(Item item, byte level) {
		this.setItem(item);
		this.setLevel(level);
	}

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
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLevel() {
		return this.level;
	}
}