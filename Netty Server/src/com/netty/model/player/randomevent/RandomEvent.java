package com.netty.model.player.randomevent;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;

public abstract class RandomEvent {

	private Player player;

	public RandomEvent(Player player) {
		this.setPlayer(player);
	}

	public abstract void start();
	public abstract void end();
	public abstract Teleport getTeleportingLocation();
	public abstract boolean isMembers();

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}