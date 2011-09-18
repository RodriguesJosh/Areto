package com.netty.model.player.minigame.mobilisingarmies;

import com.netty.model.player.Teleport;

public class Hoard extends Game {

	private Teleport teleport;

	@Override
	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	@Override
	public Teleport getTeleport() {
		return this.teleport;
	}
}