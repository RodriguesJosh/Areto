package com.netty.game.model.entity.player.interfaces.chat;

import com.netty.game.model.entity.player.interfaces.Interface;
import com.netty.game.model.entity.player.interfaces.InterfaceHandler;
import com.netty.game.model.entity.player.interfaces.InterfaceLocation;

public class EnterNameInterfaceHandler implements InterfaceHandler {

	private String name;

	@Override
	public void handleInterface(Interface interfaceClass) {
		interfaceClass.setInterfaceLocation(InterfaceLocation.CHAT);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
