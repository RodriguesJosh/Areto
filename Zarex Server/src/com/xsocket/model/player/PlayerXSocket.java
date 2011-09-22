package com.xsocket.model.player;

import org.xsocket.connection.IConnection;

import com.netty.model.player.Player;

public class PlayerXSocket extends Player {

	private IConnection iConnection;

	/**
	 * We will be using the Netty constructor to call
	 * the {@code Player}.
	 * @param iConnection
	 */
	public PlayerXSocket(IConnection iConnection) {
		super(null);
		this.setIConnection(iConnection);
	}

	public void setIConnection(IConnection iConnection) {
		this.iConnection = iConnection;
	}

	public IConnection getIConnection() {
		return this.iConnection;
	}
}