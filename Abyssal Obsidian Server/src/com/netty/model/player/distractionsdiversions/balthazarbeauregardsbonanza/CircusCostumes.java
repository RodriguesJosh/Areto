package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 2:28:12 PM
 */
public enum CircusCostumes {

	/**
	 * 
	 */
	AUDIENCE,

	/**
	 * 
	 */
	ACROBAT,

	/**
	 * 
	 */
	CLOWN,

	/**
	 * 
	 */
	RINGMASTER;

	/**
	 * 
	 */
	private Item[] items;

	/**
	 * 
	 */
	private short score;

	/**
	 * 
	 * @param items
	 * 			The items to set.
	 */
	public void setItems(Item... items) {
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

	/**
	 * 
	 * @param score
	 * 			The score to set.
	 */
	public void setScore(short score) {
		this.score = score;
	}

	/**
	 * 
	 * @return score
	 * 			Returns the score to get.
	 */
	public short getScore() {
		return this.score;
	}
}