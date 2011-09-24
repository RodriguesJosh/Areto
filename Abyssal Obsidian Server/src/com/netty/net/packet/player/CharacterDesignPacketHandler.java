package com.netty.net.packet.player;

import com.netty.model.player.Player;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:19:19 PM
 */
public class CharacterDesignPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		Byte genderByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte gender = genderByte.byteValue();// getByte();
		Byte headByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte head = headByte.byteValue();// getByte();
		Byte chestByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte chest = chestByte.byteValue();// getByte();
		Byte armsByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte arms = armsByte.byteValue();// getByte();
		Byte handsByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte hands = handsByte.byteValue();// getByte();
		Byte legsByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte legs = legsByte.byteValue();// getByte();
		Byte feetByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte feet = feetByte.byteValue();// getByte();
		Byte beardByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte beard = beardByte.byteValue();// getByte();
		Byte hairColorByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte hairColor = hairColorByte.byteValue();// getByte();
		Byte torsoColorByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte torsoColor = torsoColorByte.byteValue();// getByte();
		Byte legColorByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte legColor = legColorByte.byteValue();// getByte();
		Byte feetColorByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte feetColor = feetColorByte.byteValue();// getByte();
		Byte skinColorByte = (Byte) packetAttribute.getAttribute("GENDER");
		byte skinColor = skinColorByte.byteValue();// getByte();
		player.getAppearance().setAppearance(new byte[] {
				gender, hairColor, torsoColor, legColor, feetColor, skinColor,
				head, chest, arms, hands, legs, feet, beard
		});
		player.getUpdateFlags().setUpdateFlag(UpdateFlag.APPEARANCE);
		player.getPacketSender().getRemovedWindows();
	}
}