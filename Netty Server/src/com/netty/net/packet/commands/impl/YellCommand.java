package com.netty.net.packet.commands.impl;

import com.netty.model.player.Player;
import com.netty.net.packet.commands.Command;
import com.netty.net.packet.commands.CommandHandler;
import com.netty.world.World;

public class YellCommand implements CommandHandler {

	@Override
	public void handleCommand(Command command, Player player) {
		String message = command.getCommand().substring(5);
		for (Player p : World.getWorld().getPlayerList()) {
			p.getPacketSender().getMessage(player.getName() + ": " + message);
		}
	}
}