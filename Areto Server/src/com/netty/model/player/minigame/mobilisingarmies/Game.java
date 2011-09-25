package com.netty.model.player.minigame.mobilisingarmies;

import com.netty.model.player.Teleport;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:36:12 PM
 */
public abstract class Game {

	/**
	 * 
	 * @param teleport
	 * 			The id to set.
	 */
	public abstract void setTeleport(Teleport teleport);

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Teleport getTeleport();
}