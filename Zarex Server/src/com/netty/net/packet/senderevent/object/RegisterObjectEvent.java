package com.netty.net.packet.senderevent.object;

import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 1:42:34 PM
 */
public class RegisterObjectEvent extends PacketSenderEvent {

	/**
	 * The Object we wish to register into the
	 * game.
	 */
	private Object object;

	/**
	 * Constructs a new spawning of an object for
	 * the sending of the encoded packets.
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public RegisterObjectEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		if (this.getPlayer() == null) {
			return null;
		}
		if (this.getObject() == null) {
			return null;
		}
		short objectID = (short) this.getObject().getID();
		short objectX = this.getObject().getLocation().getX();
		short objectY = this.getObject().getLocation().getY();
		byte objectDirection = this.getObject().getDirection();
		byte objectType = this.getObject().getType();
		short typeDirectionDifference = (short) ((objectType << 2) + (objectDirection & 3));
		short playerRegionX = (short) (this.getPlayer().getLocation().getRegionX() * 8);
		short playerRegionY = (short) (this.getPlayer().getLocation().getRegionY() * 8);
		short xDifference = (short) (objectX - playerRegionX);
		short yDifference = (short) (objectY - playerRegionY);
		PacketBuilder locationPacketBuilder = new PacketBuilder(EncodedPacketConstants.ENTITY_LOCATION);
		locationPacketBuilder.putByteC(yDifference);
		locationPacketBuilder.putByteC(xDifference);
		this.getPlayer().getChannel().write(locationPacketBuilder.toPacket());
		PacketBuilder definitionPacketBuilder = new PacketBuilder(EncodedPacketConstants.OBJECT_DEFINITION);
		definitionPacketBuilder.putByteC(typeDirectionDifference);
		definitionPacketBuilder.putByte((byte) 0);
		this.getPlayer().getChannel().write(definitionPacketBuilder.toPacket());
		if (objectID == -1) {
			return null;
		}
		PacketBuilder idPacketBuilder = new PacketBuilder(EncodedPacketConstants.OBJECT_ID);
		idPacketBuilder.putByteS(0);
		idPacketBuilder.putLEShort(objectID);
		idPacketBuilder.putByteS((byte) typeDirectionDifference);
		return idPacketBuilder.toPacket();
	}

	/**
	 * Sets the Object to a new one.
	 * 
	 * @param object
	 * 			The object to set.
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * Gets the Object to write out the packet.
	 * 
	 * @return object
	 * 			Returns the object to get.
	 */
	public Object getObject() {
		return this.object;
	}
}