package com.netty.model.player.minigame.mobilisingarmies;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:35:57 PM
 */
public enum GameType {

	/**
	 * 
	 */
	CONFLICT(new Conflict()),

	/**
	 * 
	 */
	SIEGE(new Siege()),

	/**
	 * 
	 */
	HOARD(new Hoard()),

	/**
	 * 
	 */
	RESCUE(new Rescue());

	/**
	 * 
	 */
	private Game game;

	/**
	 * 
	 * @param game
	 * 			The id to set.
	 */
	private GameType(Game game) {
		this.setGame(game);
	}

	/**
	 * 
	 * @param game
	 * 			The id to set.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Game getGame() {
		return this.game;
	}
}