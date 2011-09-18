package com.grizzly.model.player;

import java.nio.channels.SocketChannel;

import com.netty.model.player.Player;

/**
 * A {@link Player} class to handle the
 * {@code Player} from the Netty networking
 * part of the server.
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
public class PlayerGrizzly extends Player {

	/**
	 * Set a {@link SocketChannel} with a {@code Player}.
	 */
	private SocketChannel socketChannel;

	/**
	 * We will be using the Netty constructor to call
	 * the {@code Player}.
	 * @param socketChannel
	 * 			The {@code SocketChannel} for the Player.
	 */
	public PlayerGrizzly(SocketChannel socketChannel) {
		super(null);
		this.setSocketChannel(socketChannel);
	}

	/**
	 * Sets the {@code SocketChannel} for the Player
	 * to connect with.
	 * @param socketChannel
	 * 			The {@code SocketChannel} for the Player.
	 */
	public void setSocketChannel(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	/**
	 * Gets the {@code SocketChannel} for the Player
	 * that he/she is connecting with.
	 * @param socketChannel
	 * 			The {@code SocketChannel} for the Player.
	 */
	public SocketChannel getSocketChannel() {
		return this.socketChannel;
	}
}