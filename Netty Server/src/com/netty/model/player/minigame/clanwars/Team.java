package com.netty.model.player.minigame.clanwars;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

public abstract class Team {

	private List<Player> playerList;
	private Player player;

	public Team(Player player) {
		this.setPlayerList(new ArrayList<Player>(ClanWarsConstants.MAX_CLAN_WARS_PLAYERS));
		this.setPlayer(player);
	}

	public abstract boolean isDangerous();
	public abstract Object getPortal();

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
}