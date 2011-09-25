package com.netty.game.model.entity.player.commads.impl;

import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.Rank;
import com.netty.game.model.entity.player.commads.Command;
import com.netty.game.model.entity.player.commads.CommandHandler;
import com.netty.stuff.FPS;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:48:01 PM
 */
public class FPSCommandHandler implements CommandHandler {

	/**
	 * 
	 */
	private FPS fps;

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.commads.CommandHandler#handleCommand(com.netty.game.model.entity.player.Player, com.netty.game.model.entity.player.commads.Command)
	 */
	@Override
	public void handleCommand(Player player, Command command) {
		if (player == null) {
			throw new NullPointerException();
		}
		if (command.getRank() != Rank.OWNER) {
			return;
		}
		this.setFPS(new FPS(0));
	}

	/**
	 * 
	 * @param fps
	 * 			The FPS to set.
	 */
	public void setFPS(FPS fps) {
		this.fps = fps;
	}

	/**
	 * 
	 * @return fps
	 * 			Returns the FPS to get.
	 */
	public FPS getFPS() {
		return this.fps;
	}
}