package com.xsocket.model.player;

import org.xsocket.connection.IConnection;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:52:12 AM
 */
public class PlayerXSocket extends Player {

	/**
	 * 
	 */
	private IConnection iConnection;

	/**
	 * We will be using the Netty constructor to call
	 * the {@code Player}.
	 * @param iConnection
	 * 			The id to set.
	 */
	public PlayerXSocket(IConnection iConnection) {
		super(null);
		this.setIConnection(iConnection);
	}

	/**
	 * 
	 * @param iConnection
	 * 			The id to set.
	 */
	public void setIConnection(IConnection iConnection) {
		this.iConnection = iConnection;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public IConnection getIConnection() {
		return this.iConnection;
	}
}