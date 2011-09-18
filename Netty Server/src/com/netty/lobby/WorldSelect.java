package com.netty.lobby;

import java.util.LinkedList;
import java.util.List;

import com.netty.lobby.world.GameWorld;

public class WorldSelect {

	private List<GameWorld> gameWorldList;

	public WorldSelect() {
		this.setGameWorldList(new LinkedList<GameWorld>());
	}

	public void setGameWorldList(List<GameWorld> gameWorldList) {
		this.gameWorldList = gameWorldList;
	}

	public List<GameWorld> getGameWorldList() {
		return this.gameWorldList;
	}
}