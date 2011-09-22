package com.netty.net.packet.commands.impl;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.net.packet.commands.Command;
import com.netty.net.packet.commands.CommandHandler;

public class TeleportCommand implements CommandHandler {

	@Override
	public void handleCommand(Command command, Player player) {
		player.setTeleport(Teleport.valueOf(command.getCommand().substring(5)));
	}
}