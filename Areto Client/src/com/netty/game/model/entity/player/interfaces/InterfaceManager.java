package com.netty.game.model.entity.player.interfaces;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:50:08 PM
 */
public class InterfaceManager {

	/**
	 * 
	 * @param interfaceHandler
	 * 			The id to set.
	 */
	public void handleInterface(InterfaceHandler interfaceHandler) {
		if (interfaceHandler == null) {
			throw new NullPointerException();
		}
	}
}