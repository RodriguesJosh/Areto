package com.netty.game.model.entity.player.interfaces.chat;

import com.netty.game.model.entity.player.interfaces.Interface;
import com.netty.game.model.entity.player.interfaces.InterfaceHandler;
import com.netty.game.model.entity.player.interfaces.InterfaceLocation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:51:00 PM
 */
public class EnterAmountInterfaceHandler implements InterfaceHandler {

	/**
	 * 
	 */
	private String amount;

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.interfaces.InterfaceHandler#handleInterface(com.netty.game.model.entity.player.interfaces.Interface)
	 */
	@Override
	public void handleInterface(Interface interfaceClass) {
		interfaceClass.setInterfaceLocation(InterfaceLocation.CHAT);
	}

	/**
	 * 
	 * @param amount
	 * 			The id to set.
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getAmount() {
		return this.amount;
	}
}
