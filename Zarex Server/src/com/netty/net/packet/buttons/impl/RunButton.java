package com.netty.net.packet.buttons.impl;

import com.netty.model.player.Player;
import com.netty.net.packet.buttons.Button;
import com.netty.net.packet.buttons.ButtonHandler;

public class RunButton implements ButtonHandler {

	@Override
	public void handleButton(Button button, Player player) {
		if (player.getWalking().isRunningToggled()) {
			player.getWalking().setRunningToggled(false);
		}
		button.setID(0);
	}
}
