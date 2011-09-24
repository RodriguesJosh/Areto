package com.netty.net.packet.senderevent.login;

import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillConstants;
import com.netty.net.packet.EncodedPacketConstants;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.packet.senderevent.PacketSenderEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:13:21 PM
 */
public class SkillsEvent extends PacketSenderEvent {

	/**
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public SkillsEvent(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.net.packet.senderevent.PacketSenderEvent#toPacket()
	 */
	@Override
	public Packet toPacket() {
		PacketBuilder packetBuilder = new PacketBuilder(EncodedPacketConstants.SKILLS);
		for (byte b = 0; b < SkillConstants.MAX_SKILLS; b++) {
			packetBuilder.putByte(b);
			packetBuilder.putInt1(this.getPlayer().getSkills()[b].getExperience());
			packetBuilder.putByte(this.getPlayer().getSkills()[b].getLevel());
		}
		return packetBuilder.toPacket();
	}
}