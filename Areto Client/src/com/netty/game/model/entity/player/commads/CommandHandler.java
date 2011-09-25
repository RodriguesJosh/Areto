package com.netty.game.model.entity.player.commads;

import com.netty.game.model.entity.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:47:08 PM
 */
public interface CommandHandler {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param command
	 * 			The id to set.
	 */
	public void handleCommand(Player player, Command command);
}