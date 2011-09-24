package com.netty.net.packet.buttons;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:38:07 PM
 */
public interface ButtonHandler {

	/**
	 * 
	 * @param button
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void handleButton(Button button, Player player);
}