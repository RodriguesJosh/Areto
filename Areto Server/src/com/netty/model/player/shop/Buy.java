package com.netty.model.player.shop;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:01:42 PM
 */
public class Buy {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Buy(Player player) {
		this.setPlayer(player);
	}

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