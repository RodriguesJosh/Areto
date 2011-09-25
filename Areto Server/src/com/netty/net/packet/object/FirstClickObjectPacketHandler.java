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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:20:54 PM
 */
public class FirstClickObjectPacketHandler implements PacketHandler {

	/**
	 * 
	 */
	private Lobby lobby;

	/**
	 * 
	 */
	private Flax flax;

	/**
	 * 
	 */
	private Mining mining;

	/**
	 * 
	 */
	private Woodcutting woodcutting;

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		if (player == null) {
			throw new NullPointerException();
		}
		short objectX = ((Short) packetAttribute.getAttribute("OBJECT_X")).shortValue();// getLEShortA();
		short objectID = ((Short) packetAttribute.getAttribute("OBJECT_ID")).shortValue();// getShort() & 0xFFFF);
		short objectY = ((Short) packetAttribute.getAttribute("OBJECT_Y")).shortValue();// getShortA() & 0xFFFF);
		World.getWorld().getLogger().info("Object X : " + objectX + " Object Y : " + objectY + " Object ID : " + objectID);
		if ((objectID == 299) || (objectID == 298) || (objectID == 304)) {
			player.setAnimation(new Animation(423, 0));
			player.getSkills()[SkillType.MAGIC.getID()].addExperience(50);
		}
		Location objectLocation = new Location(objectX, objectY, player.getLocation().getZ());
		this.setLobby(new Lobby(player, objectLocation, World.getWorld().getObjectList().get(objectID)));
		this.setFlax(new Flax(objectID, (byte) 0, (byte) 10));
		if (player.getLocation().isWithinDistance(objectLocation)) {
			this.setMining(new Mining(player, objectID));
			this.setWoodcutting(new Woodcutting(player, objectID));
		}
	}

	/**
	 * 
	 * @param lobby
	 * 			The id to set.
	 */
	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Lobby getLobby() {
		return this.lobby;
	}

	/**
	 * 
	 * @param flax
	 * 			The id to set.
	 */
	public void setFlax(Flax flax) {
		this.flax = flax;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Flax getFlax() {
		return this.flax;
	}

	/**
	 * 
	 * @param mining
	 * 			The id to set.
	 */
	public void setMining(Mining mining) {
		this.mining = mining;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Mining getMining() {
		return this.mining;
	}

	/**
	 * 
	 * @param woodcutting
	 * 			The id to set.
	 */
	public void setWoodcutting(Woodcutting woodcutting) {
		this.woodcutting = woodcutting;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Woodcutting getWoodcutting() {
		return this.woodcutting;
	}
}