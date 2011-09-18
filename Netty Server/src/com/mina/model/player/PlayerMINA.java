package com.mina.model.player;

import org.apache.mina.core.session.IoSession;

import com.mina.net.packet.PacketMINA;
import com.netty.model.player.Player;

public class PlayerMINA extends Player {

	private IoSession ioSession;
	private PacketMINA packetMINA;

	/**
	 * We will be using the Netty constructor to call
	 * the {@code Player}.
	 * @param ioSession
	 * 			The session for the {@code Player}.
	 */
	public PlayerMINA(IoSession ioSession) {
		super(null);
		this.setIOSession(ioSession);
	}

	public void setIOSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}

	public IoSession getIOSession() {
		return this.ioSession;
	}

	public void setPacketMINA(PacketMINA packetMINA) {
		this.packetMINA = packetMINA;
	}

	public PacketMINA getPacketMINA() {
		return this.packetMINA;
	}
}