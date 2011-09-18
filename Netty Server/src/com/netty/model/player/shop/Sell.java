package com.netty.model.player.shop;

import com.netty.model.player.Player;

public class Sell {

	private Player player;

	public Sell(Player player) {
		this.setPlayer(player);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}