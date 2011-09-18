package com.netty.game.model.entity.player.commads;

import com.netty.game.model.entity.player.Player;

public interface CommandHandler {

	public void handleCommand(Player player, Command command);
}