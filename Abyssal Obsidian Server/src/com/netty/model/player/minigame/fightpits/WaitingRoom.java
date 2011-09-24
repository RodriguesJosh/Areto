package com.netty.model.player.minigame.fightpits;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:41:23 PM
 */
public class WaitingRoom {

	/**
	 * 
	 */
	private List<Player> playerList;

	/**
	 * 
	 */
	public WaitingRoom() {
		this.setPlayerList(new ArrayList<Player>());
	}

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
}