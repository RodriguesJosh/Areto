package com.netty.model.player.minigame.bountyhunter;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:10:52 PM
 */
public abstract class Crate {

	/**
	 * 
	 */
	private List<Player> playerList;

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Crate(Player player) {
		this.setPlayerList(new ArrayList<Player>(BountyHunterConstants.MAX_BOUNTY_PLAYERS));
		this.setPlayer(player);
	}

	/**
	 * 
	 * @param playerList
	 * 			The id to set.
	 */
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Player> getPlayerList() {
		return this.playerList;
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract boolean isLevelNeeded();
}