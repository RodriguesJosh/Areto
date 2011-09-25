package com.netty.bot.net;

import org.jboss.netty.channel.Channel;

import com.netty.model.player.Player;

/**
 * We will login to the server and
 * construct a new {@link Player} when
 * logging in.
 * @author josh
 * @since 0.1
 */
public class Login {

	/**
	 * The channel to connect to the
	 * server.
	 */
	private Channel channel;

	/**
	 * Creates a new or used channel so that we
	 * can use it to connect to the server.
	 * @param channel
	 * 			Sets the channel.
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
	 * The channel that we are using when connecting
	 * to the server.
	 * @return channel
	 * 			Gets the channel that we are connecting
	 * 			with.
	 */
	public Channel getChannel() {
		return this.channel;
	}
}