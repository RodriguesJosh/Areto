package com.netty.net.packet.commands.jnative;

import com.netty.model.player.Player;
import com.netty.net.packet.commands.Command;

/**
 * Please note that this is only a test! This
 * will support commands via the JNI just to see
 * where this Netty Server can go!
 * @author josh
 * @version 0.1
 * @since 0.1
 */
public class NativeCommand {

	/**
	 * Handles a command via the JNI (Java Native Interface). Again,
	 * this is only a test and is only used for performance demonstrations
	 * to see where RSPS can really go to.
	 * @param command
	 * @param player
	 */
	public native void handleCommand(Command command, Player player);
}