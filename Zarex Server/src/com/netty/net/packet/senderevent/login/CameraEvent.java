package com.netty.net.packet.senderevent.login;

import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:13:13 PM
 */
public class CameraEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public CameraEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.RESET_CAMERA);
		return packetBuilder.toPacket();
	}
}