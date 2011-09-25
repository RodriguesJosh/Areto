package com.netty.game.model.entity.player.interfaces.inventory;

import com.netty.game.model.entity.player.interfaces.Interface;
import com.netty.game.model.entity.player.interfaces.InterfaceHandler;
import com.netty.game.model.entity.player.interfaces.InterfaceLocation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:52:10 PM
 */
public class FriendsListInterfaceHandler implements InterfaceHandler {

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.interfaces.InterfaceHandler#handleInterface(com.netty.game.model.entity.player.interfaces.Interface)
	 */
	@Override
	public void handleInterface(Interface interfaceClass) {
		interfaceClass.setInterfaceLocation(InterfaceLocation.INVENTORY);
	}
}
