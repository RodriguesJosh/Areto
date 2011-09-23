package com.netty.lobby;

import java.util.ArrayList;
import java.util.List;

import com.netty.lobby.world.GameWorld;

/**
 * A class to represent a list of worlds
 * to choose from and switch.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 4:22:51 PM
 */
public class WorldSelect {

	/**
	 * A list filled with worlds to choose
	 * from.
	 */
	private List<GameWorld> gameWorldList;

	/**
	 * Constructs a new selection of worlds
	 * to switch.
	 */
	public WorldSelect() {
		this.setGameWorldList(new ArrayList<GameWorld>());
	}

	/**
	 * Sets the list of gaming worlds to
	 * switch from.
	 * 
	 * @param gameWorldList
	 * 			The world list to set.
	 */
	public void setGameWorldList(List<GameWorld> gameWorldList) {
		this.gameWorldList = gameWorldList;
	}

	/**
	 * Gets the list of gaming worlds to choose
	 * from.
	 * 
	 * @return gameWorldList
	 * 			Returns the world list to get.
	 */
	public List<GameWorld> getGameWorldList() {
		return this.gameWorldList;
	}
}