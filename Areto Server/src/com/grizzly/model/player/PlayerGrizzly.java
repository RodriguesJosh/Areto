package com.grizzly.model.player;

import java.nio.channels.SocketChannel;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.model.player.Player;

/**
 * A player class to handle the networking
 * for the Grizzly implementation of the
 * Netty server.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:54:36 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PlayerGrizzly extends Player {

	/**
	 * A declared SocketChannel.
	 */
	private SocketChannel socketChannel;

	/**
	 * We will be using the Netty constructor to call
	 * the player.
	 * 
	 * @param socketChannel
	 * 			The SocketChannel for the Player.
	 */
	public PlayerGrizzly(SocketChannel socketChannel) {
		super(null);
		this.setSocketChannel(socketChannel);
	}

	/**
	 * Sets the SocketChannel for the player
	 * to connect with.
	 * 
	 * @param socketChannel
	 * 			The SocketChannel for the Player.
	 */
	public void setSocketChannel(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	/**
	 * Gets the SocketChannel for the Player
	 * that he/she is connecting with.
	 * 
	 * @return socketChannel
	 * 			The SocketChannel for the Player.
	 */
	public SocketChannel getSocketChannel() {
		return this.socketChannel;
	}
}