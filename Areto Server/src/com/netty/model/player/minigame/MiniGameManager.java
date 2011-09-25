package com.netty.model.player.minigame;

import java.util.List;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:55:15 PM
 */
public class MiniGameManager {

	/**
	 * 
	 */
	private List<MiniGame> miniGameList;

	/**
	 * 
	 * @param miniGameList
	 * 			The miniGameList to set.
	 */
	public void setMiniGameList(List<MiniGame> miniGameList) {
		this.miniGameList = miniGameList;
	}

	/**
	 * 
	 * @return miniGameList
	 * 			Returns the miniGameList to get.
	 */
	public List<MiniGame> getMiniGameList() {
		return this.miniGameList;
	}
}