package com.netty.game.model.entity.player.commads.impl;

import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.Rank;
import com.netty.game.model.entity.player.commads.Command;
import com.netty.game.model.entity.player.commads.CommandHandler;

public class DisconnectCommandHandler implements CommandHandler {

	@Override
	public void handleCommand(Player player, Command command) {
		if (command.getRank() != Rank.OWNER) {
			return;
		}
	}
}