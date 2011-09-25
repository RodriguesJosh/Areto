package com.mina.model.player;

import org.apache.mina.core.session.IoSession;

import com.mina.net.packet.PacketMINA;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.model.player.Player;

/**
 * Represents a player for the MINA networking
 * for when we want to switch between networking
 * APIs.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:24:19 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class PlayerMINA extends Player {

	/**
	 * The session this player is intertwined
	 * with.
	 */
	private IoSession ioSession;

	/**
	 * The packet that the player is using at
	 * the moment.
	 */
	private PacketMINA packetMINA;

	/**
	 * We will be using the Netty constructor to call
	 * the player.
	 * 
	 * @param ioSession
	 * 			The session for the {@code Player}.
	 */
	public PlayerMINA(IoSession ioSession) {
		super(null);
		this.setIOSession(ioSession);
	}

	/**
	 * Sets the IoSession for this player
	 * to write and read data with.
	 * 
	 * @param ioSession
	 * 			The IoSession to set for the
	 * 			player.
	 */
	public void setIOSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}

	/**
	 * Gets the IoSession that the
	 * player is attached with.
	 * 
	 * @return
	 * 			Returns the IoSession for the
	 * 			player.
	 */
	public IoSession getIOSession() {
		return this.ioSession;
	}

	/**
	 * Sets the packet for the player
	 * to use.
	 * 
	 * @param packetMINA
	 * 			The packet to set for the player.
	 */
	public void setPacketMINA(PacketMINA packetMINA) {
		this.packetMINA = packetMINA;
	}

	/**
	 * Gets the packet that this player
	 * is using at the moment.
	 * 
	 * @return
	 * 			The packet for the player.
	 */
	public PacketMINA getPacketMINA() {
		return this.packetMINA;
	}
}