package com.netty.model.player.minigame.fistguthix;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:44:10 PM
 */
public class Hunter {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public Hunter(Player player) {
		this.setPlayer(player);
	}

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}
}