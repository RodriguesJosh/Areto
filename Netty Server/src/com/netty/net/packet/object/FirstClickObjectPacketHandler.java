package com.netty.net.packet.object;

import com.netty.model.object.impl.Flax;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.castlewars.Lobby;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.skill.mining.Mining;
import com.netty.model.player.skill.woodcutting.Woodcutting;
import com.netty.model.update.Animation;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.Location;
import com.netty.world.World;

public class FirstClickObjectPacketHandler implements PacketHandler {

	private Lobby lobby;
	private Flax flax;
	private Mining mining;
	private Woodcutting woodcutting;

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		short objectX = (Short) packetAttribute.getAttribute("OBJECT_X");// getLEShortA();
		short objectID = (Short) packetAttribute.getAttribute("OBJECT_ID");// getShort() & 0xFFFF);
		short objectY = (Short) packetAttribute.getAttribute("OBJECT_Y");// getShortA() & 0xFFFF);
		World.getWorld().getLogger().info("Object X : " + objectX + " Object Y : " + objectY + " Object ID : " + objectID);
		if ((objectID == 299) || (objectID == 298) || (objectID == 304)) {
			player.setAnimation(new Animation(423, 0));
			player.getSkills()[SkillType.MAGIC.getID()].addExperience(50);
		}
		Location objectLocation = new Location(objectX, objectY, player.getLocation().getZ());
		this.setLobby(new Lobby(player, objectLocation, World.getWorld().getObjectList().get(objectID)));
		this.setFlax(new Flax(objectID, (byte) 0, (byte) 10));
		if ((player != null) && (player.getLocation().isWithinDistance(objectLocation))) {
			this.setMining(new Mining(player, objectID));
			this.setWoodcutting(new Woodcutting(player, objectID));
		}
	}

	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	public Lobby getLobby() {
		return this.lobby;
	}

	public void setFlax(Flax flax) {
		this.flax = flax;
	}

	public Flax getFlax() {
		return this.flax;
	}

	public void setMining(Mining mining) {
		this.mining = mining;
	}

	public Mining getMining() {
		return this.mining;
	}

	public void setWoodcutting(Woodcutting woodcutting) {
		this.woodcutting = woodcutting;
	}

	public Woodcutting getWoodcutting() {
		return this.woodcutting;
	}
}