package com.netty.model.player.assist;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:04:55 PM
 */
public class Assist {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private Player assistingPlayer;

	/**
	 * 
	 * 
	 * @param player
	 * 			The player who needs assistance.
	 * @param assistingPlayer
	 * 			The player assistanting the other player.
	 */
	public Assist(Player player, Player assistingPlayer) {
		this.setPlayer(assistingPlayer);
		this.setAssistingPlayer(assistingPlayer);
	}

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return player
	 * 			Returns the player to get.
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param assistingPlayer
	 * 			The assistingPlayer to set.
	 */
	public void setAssistingPlayer(Player assistingPlayer) {
		this.assistingPlayer = assistingPlayer;
	}

	/**
	 * 
	 * @return assistingPlayer
	 * 			Returns the assistingPlayer to get.
	 */
	public Player getAssistingPlayer() {
		return this.assistingPlayer;
	}
}