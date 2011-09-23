package com.netty.net.packet.commands;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:27:48 PM
 */
public interface CommandHandler {

	/**
	 * 
	 * @param command
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void handleCommand(Command command, Player player);
}