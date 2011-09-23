package com.netty.model.player.minigame.templetrekking;

import com.netty.model.player.tab.Inventory;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:20:20 PM
 */
public class Follower {

	/**
	 * 
	 */
	private Inventory inventory;

	/**
	 * 
	 * @param inventory
	 * 			The id to set.
	 */
	public Follower(Inventory inventory) {
		this.setInventory(inventory);
	}

	/**
	 * 
	 * @param inventory
	 * 			The id to set.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Inventory getInventory() {
		return this.inventory;
	}
}