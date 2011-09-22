package com.netty.model.player.minigame.bountyhunter;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

public abstract class Crate {

	private List<Player> playerList;
	private Player player;

	public Crate(Player player) {
		this.setPlayerList(new ArrayList<Player>(BountyHunterConstants.MAX_BOUNTY_PLAYERS));
		this.setPlayer(player);
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public abstract boolean isLevelNeeded();
}