package com.netty.model.player.minigame.clanwars;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:30:09 PM
 */
public abstract class Team {

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
	 *			The id to set.
	 */
	public Team(Player player) {
		this.setPlayerList(new ArrayList<Player>(ClanWarsConstants.MAX_CLAN_WARS_PLAYERS));
		this.setPlayer(player);
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */

	public abstract boolean isDangerous();
	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Object getPortal();

	/**
	 * 
	 * @param playerList
	 *			The id to set.
	 */
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public List<Player> getPlayerList() {
		return this.playerList;
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