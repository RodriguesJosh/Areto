package com.netty.model.player.minigame.stealingcreation;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:26:05 PM
 */
public abstract class Team {

	/**
	 * 
	 */
	private List<Player> playerList;

	/**
	 * 
	 */
	private Barrier barrier;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 */
	public Team() {
		this.setPlayerList(new ArrayList<Player>());
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
	 * @param barrier
	 * 			The id to set.
	 */
	public void setBarrier(Barrier barrier) {
		this.barrier = barrier;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Barrier getBarrier() {
		return this.barrier;
	}

	/**
	 * 
	 * @param reward
	 * 			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}