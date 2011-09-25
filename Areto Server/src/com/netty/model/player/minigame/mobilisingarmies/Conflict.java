package com.netty.model.player.minigame.mobilisingarmies;

import com.netty.model.player.Teleport;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:36:23 PM
 */
public class Conflict extends Game {

	/**
	 * 
	 */
	private Teleport teleport;

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.mobilisingarmies.Game#setTeleport(com.netty.model.player.Teleport)
	 */
	@Override
	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.mobilisingarmies.Game#getTeleport()
	 */
	@Override
	public Teleport getTeleport() {
		return this.teleport;
	}
}