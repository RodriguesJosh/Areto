package com.netty.model.player.minigame.fistguthix;

import com.netty.model.player.Player;

public class Hunter {

	private Player player;

	public Hunter(Player player) {
		this.setPlayer(player);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}