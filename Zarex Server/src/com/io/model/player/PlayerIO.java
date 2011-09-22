package com.io.model.player;

import java.net.Socket;

import com.netty.model.player.Player;

/**
 * A {@link Player} class for the IO implementation
 * of the Netty Server.
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
public class PlayerIO extends Player {

	/**
	 * The {@link Socket} for the {@code Player}
	 * to connect with.
	 */
	private Socket socket;

	/**
	 * We will be using the Netty constructor to call
	 * the {@code Player}.
	 * @param socket
	 * 			The {@code Socket} for the {@code Socket}.
	 */
	private PlayerIO(Socket socket) {
		super(null);
		this.setSocket(socket);
	}

	/**
	 * Sets the {@code Socket} for the IO implementation
	 * of {@code Player}.
	 * @param socket
	 * 			The {@code Socket} for the {@code Socket}.
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Gets the {@code Socket} that the {@code Player}
	 * is connecting with.
	 * @return socket
	 * 			The {@code Socket} the {@code Player}
	 * 			is connecting with.
	 */
	public Socket getSocket() {
		return this.socket;
	}
}