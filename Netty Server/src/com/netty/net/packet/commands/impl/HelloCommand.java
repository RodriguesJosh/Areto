package com.netty.net.packet.commands.impl;

import com.netty.model.player.Player;
import com.netty.net.packet.commands.Command;
import com.netty.net.packet.commands.CommandHandler;

public class HelloCommand implements CommandHandler {

	@Override
	public void handleCommand(Command command, Player player) {
		player.getPacketSender().getMessage("Hello!");
	}
}
