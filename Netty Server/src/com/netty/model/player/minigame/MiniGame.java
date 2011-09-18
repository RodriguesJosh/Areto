package com.netty.model.player.minigame;

import com.netty.model.player.Player;

public abstract class MiniGame {

	private Player player;

	public MiniGame(Player player) {
		this.setPlayer(player);
	}

	public abstract void start();
	public abstract void end();
	public abstract MembershipState getMembershipState();
	public abstract ThreateningState getThreateningState();

	public boolean isPlaying() {
		return this != null;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}
