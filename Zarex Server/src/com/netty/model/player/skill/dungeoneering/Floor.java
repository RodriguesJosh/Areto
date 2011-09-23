package com.netty.model.player.skill.dungeoneering;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:03:57 AM
 */
public class Floor {

	/**
	 * 
	 */
	private FloorType floorType;

	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 */
	private NPC[] npcsFound;

	/**
	 * 
	 * @param floorType
	 * 			The id to set.
	 */
	public void setFloorType(FloorType floorType) {
		this.floorType = floorType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public FloorType getFloorType() {
		return this.floorType;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param npcsFound
	 * 			The id to set.
	 */
	public void setNPCSFound(NPC[] npcsFound) {
		this.npcsFound = npcsFound;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC[] getNPCSFound() {
		return this.npcsFound;
	}
}