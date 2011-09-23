package com.netty.net.packet.senderevent.login;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:14:03 PM
 */
public class LoginEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public LoginEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		new PlayerInformationEvent(this.getPlayer());
		new CameraEvent(this.getPlayer());
		new TabInterfacesEvent(this.getPlayer());
		SkillsEvent skillsEvent = new SkillsEvent(this.getPlayer());
		return skillsEvent.toPacket();
	}
}