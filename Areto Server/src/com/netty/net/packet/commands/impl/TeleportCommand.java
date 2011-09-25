package com.netty.net.packet.commands.impl;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.net.packet.commands.Command;
import com.netty.net.packet.commands.CommandHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:26:38 PM
 */
public class TeleportCommand implements CommandHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.commands.CommandHandler#handleCommand(com.netty.net.packet.commands.Command, com.netty.model.player.Player)
	 */
	@Override
	public void handleCommand(Command command, Player player) {
		player.setTeleport(Teleport.valueOf(command.getCommand().substring(5)));
	}
}