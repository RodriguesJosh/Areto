package com.netty.game.model.entity.player.interfaces.threed;

import com.netty.game.model.entity.player.interfaces.Interface;
import com.netty.game.model.entity.player.interfaces.InterfaceHandler;
import com.netty.game.model.entity.player.interfaces.InterfaceLocation;

public class BankInterfaceHandler implements InterfaceHandler {

	@Override
	public void handleInterface(Interface interfaceClass) {
		interfaceClass.setInterfaceLocation(InterfaceLocation.THREE_D);
	}
}
