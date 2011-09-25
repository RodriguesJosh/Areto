package com.netty.game.model.entity.menu.menuaction;

import com.netty.game.model.entity.player.Player;
import com.netty.net.packet.Packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:25:03 PM
 */
public interface MenuActionHandler {

	/**
	 * 
	 * @param menuAction
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 * @param packet
	 * 			The id to set.
	 */
	public void handleAction(MenuAction menuAction, Player player, Packet packet);
}
