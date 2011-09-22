package com.netty.net.packet.buttons;

import com.netty.model.player.Player;

public interface ButtonHandler {

	public void handleButton(Button button, Player player);
}