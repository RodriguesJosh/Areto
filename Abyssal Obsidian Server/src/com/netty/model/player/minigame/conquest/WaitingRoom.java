package com.netty.model.player.minigame.conquest;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:30:52 PM
 */
public abstract class WaitingRoom {

	/**
	 * 
	 * 
	 * @param player
	 *			The id to set.
	 * @return
	 *			The id to set.
	 */
	public abstract boolean addPlayer(Player player);

	/**
	 * 
	 * 
	 * @param player
	 *			The id to set.
	 * @return
	 *			The id to set.
	 */
	public abstract boolean removePlayer(Player player);
}