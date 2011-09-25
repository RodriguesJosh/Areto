package com.netty.game.model.entity.menu.menuaction.impl;

import com.netty.game.model.entity.menu.menuaction.MenuAction;
import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.player.Player;
import com.netty.net.packet.Packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:31:28 PM
 */
public class AddIgnoreMenuAction implements MenuActionHandler {

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuaction.MenuActionHandler#handleAction(com.netty.game.model.entity.menu.menuaction.MenuAction, com.netty.game.model.entity.player.Player, com.netty.net.packet.Packet)
	 */
	@Override
	public void handleAction(MenuAction menuAction, Player player, Packet packet) {
		if (menuAction == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		if (packet == null) {
			throw new NullPointerException();
		}
	}
}
