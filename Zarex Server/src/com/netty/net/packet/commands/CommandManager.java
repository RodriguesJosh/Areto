package com.netty.net.packet.commands;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:27:33 PM
 */
public class CommandManager {

	/**
	 * 
	 */
	private static ConcurrentMap<String, CommandHandler> commandHandlerMap = new ConcurrentHashMap<String, CommandHandler>();

	/**
	 * 
	 * @param command
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public static void execute(Command command, Player player) {
		String commandString = command.getCommand();
		if (!CommandManager.commandHandlerMap.containsKey(commandString)) {
			return;
		}
		CommandHandler commandHandler = CommandManager.commandHandlerMap.get(commandString);
		commandHandler.handleCommand(command, player);
	}
}