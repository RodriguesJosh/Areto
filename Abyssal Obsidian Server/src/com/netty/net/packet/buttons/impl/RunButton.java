package com.netty.net.packet.buttons.impl;

import com.netty.model.player.Player;
import com.netty.net.packet.buttons.Button;
import com.netty.net.packet.buttons.ButtonHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:37:31 PM
 */
public class RunButton implements ButtonHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.buttons.ButtonHandler#handleButton(com.netty.net.packet.buttons.Button, com.netty.model.player.Player)
	 */
	@Override
	public void handleButton(Button button, Player player) {
		if (player.getWalking().isRunningToggled()) {
			player.getWalking().setRunningToggled(false);
		}
		button.setID((short) 0);
	}
}
