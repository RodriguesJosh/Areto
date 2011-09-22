package com.netty.model.player.shop;

import com.netty.model.player.Player;

public class Buy {

	private Player player;

	public Buy(Player player) {
		this.setPlayer(player);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}