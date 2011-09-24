package com.netty.net.packet.senderevent.login;

import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:14:19 PM
 */
public class TabInterfacesEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public TabInterfacesEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.RESET_CAMERA);
		TabInterface[] tabInterfaces = new TabInterface[14];
		int[] interfaces = { 2423, 3917, 638, 3213, 1644, 5608, 1151, 12855, 5065, 5715, 2449, 4445, 147, 6299 };
		for (int i = 0; i < tabInterfaces.length; i++) {
			tabInterfaces[i] = new TabInterface((short) interfaces[i]);
			packetBuilder.putShort(tabInterfaces[i].getInterfaceID());
			packetBuilder.putByteA(i);
		}
		return packetBuilder.toPacket();
	}
}