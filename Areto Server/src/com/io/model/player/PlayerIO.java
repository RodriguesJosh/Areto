package com.io.model.player;

import java.net.Socket;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.model.player.Player;

/**
 * A player class for the IO implementation
 * of the Netty Server.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:10:56 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PlayerIO extends Player {

	/**
	 * The Socket for the player to connect with.
	 */
	private Socket socket;

	/**
	 * We will be using the Netty constructor to call
	 * the player.
	 * 
	 * @param socket
	 * 			The Socket for the player.
	 */
	private PlayerIO(Socket socket) {
		super(null);
		this.setSocket(socket);
	}

	/**
	 * Sets the Socket for the IO implementation
	 * of player.
	 * 
	 * @param socket
	 * 			The Socket for the player.
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Gets the Socket that the player is connecting
	 * with.
	 * 
	 * @return socket
	 * 			The Socket the player is connecting
	 * 			with.
	 */
	public Socket getSocket() {
		return this.socket;
	}
}