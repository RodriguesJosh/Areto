package com.netty.model.player.minigame.templetrekking;

import com.netty.model.player.tab.Inventory;

public class Follower {

	private Inventory inventory;

	public Follower(Inventory inventory) {
		this.setInventory(inventory);
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return this.inventory;
	}
}