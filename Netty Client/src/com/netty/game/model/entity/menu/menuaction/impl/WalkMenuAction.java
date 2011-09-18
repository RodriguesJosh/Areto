package com.netty.game.model.entity.menu.menuaction.impl;

import com.netty.game.model.entity.menu.menuaction.MenuAction;
import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.player.Player;
import com.netty.net.packet.Packet;

public class WalkMenuAction implements MenuActionHandler {

	@Override
	public void handleAction(MenuAction menuAction, Player player, Packet packet) {
		/** Send the Walk packet or might even send the command to walk - not sure yet. */
	}
}
