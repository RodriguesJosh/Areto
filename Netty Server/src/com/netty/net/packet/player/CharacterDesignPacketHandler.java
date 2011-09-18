package com.netty.net.packet.player;

import com.netty.model.player.Player;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;

public class CharacterDesignPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		byte gender = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte head = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte chest = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte arms = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte hands = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte legs = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte feet = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte beard = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte hairColor = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte torsoColor = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte legColor = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte feetColor = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		byte skinColor = (Byte) packetAttribute.getAttribute("GENDER");// getByte();
		player.getAppearance().setAppearance(new byte[] {
				gender, hairColor, torsoColor, legColor, feetColor, skinColor,
				head, chest, arms, hands, legs, feet, beard
		});
		player.getUpdateFlags().setUpdateFlag(UpdateFlag.APPEARANCE);
		player.getPacketSender().getRemovedWindows();
	}
}