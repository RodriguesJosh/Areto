package com.netty.bot;

import com.netty.model.player.Player;

/**
 * A class filled with constant fields
 * to use throughout the {@link Bot} we've
 * made/are going to make.
 * @author josh
 * @since 0.1
 */
public class BotConstants {

	/**
	 * The maximum amount of {@link Player}s
	 * allowed when executing the <code>Bot</code>.
	 */
	public static final short MAX_PLAYERS = 2000;

	/**
	 * The port we will use to connect to the
	 * server.
	 */
	public static final int PORT = 43594;

	/**
	 * The host/IP we will use to connect to the
	 * server.
	 */
	public static final String HOST = "127.0.0.1";
}