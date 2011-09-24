package com.netty.model.player.minigame;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:55:49 PM
 */
public abstract class MiniGame {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public MiniGame(Player player) {
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
	public abstract MembershipState getMembershipState();

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract ThreateningState getThreateningState();

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isPlaying() {
		return this != null;
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