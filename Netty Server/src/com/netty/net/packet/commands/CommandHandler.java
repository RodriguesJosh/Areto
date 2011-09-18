package com.netty.net.packet.commands;

import com.netty.model.player.Player;

public interface CommandHandler {

	public void handleCommand(Command command, Player player);
}