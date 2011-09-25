package com.netty.model.player.randomevent;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:42:10 PM
 */
public abstract class RandomEvent {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public RandomEvent(Player player) {
		this.setPlayer(player);
	}

	/**
	 * 
	 */
	public abstract void start();

	/**
	 * 
	 */
	public abstract void end();
	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Teleport getTeleportingLocation();
	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract boolean isMembers();

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}
}