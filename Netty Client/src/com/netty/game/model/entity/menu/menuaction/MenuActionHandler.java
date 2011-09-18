package com.netty.game.model.entity.menu.menuaction;

import com.netty.game.model.entity.player.Player;
import com.netty.net.packet.Packet;

public interface MenuActionHandler {

	public void handleAction(MenuAction menuAction, Player player, Packet packet);
}
