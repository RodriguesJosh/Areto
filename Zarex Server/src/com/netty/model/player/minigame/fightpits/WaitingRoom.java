package com.netty.model.player.minigame.fightpits;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;

public class WaitingRoom {

	private List<Player> playerList;

	public WaitingRoom() {
		this.setPlayerList(new ArrayList<Player>());
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}
}