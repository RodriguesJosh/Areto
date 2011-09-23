package com.netty.net.packet.commands.impl;

import com.netty.model.player.Player;
import com.netty.net.packet.commands.Command;
import com.netty.net.packet.commands.CommandHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:26:26 PM
 */
public class YellCommand implements CommandHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.commands.CommandHandler#handleCommand(com.netty.net.packet.commands.Command, com.netty.model.player.Player)
	 */
	@Override
	public void handleCommand(Command command, Player player) {
		String message = command.getCommand().substring(5);
		for (Player p : World.getWorld().getPlayerList()) {
			p.getPacketSender().getMessage(player.getName() + ": " + message);
		}
	}
}