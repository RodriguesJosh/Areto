package com.netty.model.player.minigame.stealingcreation;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

public abstract class Team {

	private List<Player> playerList;
	private Barrier barrier;
	private Reward reward;

	public Team() {
		this.setPlayerList(new ArrayList<Player>());
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}

	public void setBarrier(Barrier barrier) {
		this.barrier = barrier;
	}

	public Barrier getBarrier() {
		return this.barrier;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}