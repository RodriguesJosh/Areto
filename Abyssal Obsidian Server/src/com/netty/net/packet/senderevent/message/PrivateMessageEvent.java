package com.netty.net.packet.senderevent.message;

import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:02:59 PM
 */
public class PrivateMessageEvent extends PacketSenderEvent {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String text;

	/**
	 * 
	 */
	private int size;

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public PrivateMessageEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.PRIVATE_MESSAGE);
		packetBuilder.putString(this.getName());
		packetBuilder.putInt(this.getText().length());
		packetBuilder.putByte(this.getPlayer().getRank().getID());
		packetBuilder.putBytes(World.getWorld().getGoogleTranslatedLanguage(this.getPlayer(), this.getText()).getBytes(), this.getSize(), 0);
		return packetBuilder.toPacket();
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return name
	 * 			Returns the name to get.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param text
	 * 			The text to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return text
	 * 			Returns the text to get.
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * 
	 * @param size
	 * 			The size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @return size
	 * 			Returns the size to get.
	 */
	public int getSize() {
		return this.size;
	}
}