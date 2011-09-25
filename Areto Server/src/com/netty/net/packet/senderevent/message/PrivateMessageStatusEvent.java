package com.netty.net.packet.senderevent.message;

import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 2:11:42 PM
 */
public class PrivateMessageStatusEvent extends PacketSenderEvent {

	/**
	 * 
	 */
	private PrivateMessageStatus privateMessageStatus;

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 * @param privateMessageStatus
	 * 			The status of the private messaging
	 * 			to set.
	 */
	public PrivateMessageStatusEvent(Player player, PrivateMessageStatus privateMessageStatus) {
		super(player);
		this.setPrivateMessageStatus(privateMessageStatus);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.PRIVATE_MESSAGE_STATUS);
		packetBuilder.putByte(this.getPrivateMessageStatus().getStatusID());
		return packetBuilder.toPacket();
	}

	/**
	 * 
	 * @param privateMessageStatus
	 * 			The privateMessageStatus to set.
	 */
	public void setPrivateMessageStatus(PrivateMessageStatus privateMessageStatus) {
		this.privateMessageStatus = privateMessageStatus;
	}

	/**
	 * 
	 * @return privateMessageStatus
	 * 			Returns the privateMessageStatus to get.
	 */
	public PrivateMessageStatus getPrivateMessageStatus() {
		return this.privateMessageStatus;
	}
}