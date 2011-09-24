package com.netty.net.packet.senderevent.login;

import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:13:30 PM
 */
public class MapRegionEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public MapRegionEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.MAP_REGION);
		this.getPlayer().setLastLocation(this.getPlayer().getLocation());
		packetBuilder.putShortA(this.getPlayer().getLocation().getRegionX() + 6);
		packetBuilder.putShort(this.getPlayer().getLocation().getRegionY() + 6);
		return packetBuilder.toPacket();
	}
}