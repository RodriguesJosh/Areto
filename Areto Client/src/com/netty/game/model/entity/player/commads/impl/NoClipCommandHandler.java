package com.netty.game.model.entity.player.commads.impl;

import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.Rank;
import com.netty.game.model.entity.player.commads.Command;
import com.netty.game.model.entity.player.commads.CommandHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:47:22 PM
 */
public class NoClipCommandHandler implements CommandHandler {

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.commads.CommandHandler#handleCommand(com.netty.game.model.entity.player.Player, com.netty.game.model.entity.player.commads.Command)
	 */
	@Override
	public void handleCommand(Player player, Command command) {
		if (player == null) {
			throw new NullPointerException();
		}
		if (command.getRank() != Rank.OWNER) {
			return;
		}
	}
}