package com.netty.model.player.minigame.castlewars;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;

public abstract class Team {

	private List<Player> playerList;
	private Player player;

	public Team(Player player) {
		this.setPlayerList(new ArrayList<Player>(CastleWarsConstants.MAX_CASTLE_WARS_PLAYERS));
		this.setPlayer(player);
	}

	public abstract void setStartLocation(Location startLocation);
	public abstract Location getStartLocation();
	public abstract void setEndLocation(Location endLocation);
	public abstract Location getEndLocation();
	public abstract Teleport getTeleportLocation();
	public abstract Object getEnterPortal();
	public abstract Object getLeaveLobbyPortal();
	public abstract Object getLeaveGamePortal();

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