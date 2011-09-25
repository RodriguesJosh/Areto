package com.netty.net.packet.senderevent.login;

import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:13:45 PM
 */
public class PlayerInformationEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public PlayerInformationEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.PLAYER_INFORMATION);
		packetBuilder.putByteA(this.getPlayer().isMembership() ? 1 : 0);
		packetBuilder.putLEShortA(this.getPlayer().getIndex());
		return packetBuilder.toPacket();
	}
}