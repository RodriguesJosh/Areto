package com.netty.game.model.entity.player.interfaces.chat;

import com.netty.game.model.entity.player.interfaces.Interface;
import com.netty.game.model.entity.player.interfaces.InterfaceHandler;
import com.netty.game.model.entity.player.interfaces.InterfaceLocation;

public class EnterAmountInterfaceHandler implements InterfaceHandler {

	private String amount;

	@Override
	public void handleInterface(Interface interfaceClass) {
		interfaceClass.setInterfaceLocation(InterfaceLocation.CHAT);
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return this.amount;
	}
}
