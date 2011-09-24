package com.netty.model.player.minigame.castlewars;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:27:59 PM
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
		this.setPlayerList(new ArrayList<Player>(CastleWarsConstants.MAX_CASTLE_WARS_PLAYERS));
		this.setPlayer(player);
	}

	/**
	 * 
	 * @param startLocation
	 *			The id to set.
	 */
	public abstract void setStartLocation(Location startLocation);

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Location getStartLocation();

	/**
	 * 
	 * @param endLocation
	 *			The id to set.
	 */
	public abstract void setEndLocation(Location endLocation);

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Location getEndLocation();

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Teleport getTeleportLocation();

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Object getEnterPortal();

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Object getLeaveLobbyPortal();

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public abstract Object getLeaveGamePortal();


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