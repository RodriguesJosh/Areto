package com.netty.model.player.minigame.mobilisingarmies;

public enum GameType {

	CONFLICT(new Conflict()), SIEGE(new Siege()), HOARD(new Hoard()), RESCUE(new Rescue());

	private Game game;

	private GameType(Game game) {
		this.setGame(game);
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return this.game;
	}
}