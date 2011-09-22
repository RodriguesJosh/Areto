package com.netty.game.model.entity.player.interfaces.inventory;

import com.netty.game.model.entity.player.interfaces.Interface;
import com.netty.game.model.entity.player.interfaces.InterfaceHandler;
import com.netty.game.model.entity.player.interfaces.InterfaceLocation;

public class SkillInterfaceHandler implements InterfaceHandler {

	@Override
	public void handleInterface(Interface interfaceClass) {
		interfaceClass.setInterfaceLocation(InterfaceLocation.INVENTORY);
	}
}