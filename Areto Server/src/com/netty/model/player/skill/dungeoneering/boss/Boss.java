package com.netty.model.player.skill.dungeoneering.boss;

import com.netty.model.item.Item;
import com.netty.model.player.skill.dungeoneering.FloorType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:03:19 AM
 */
public abstract class Boss {

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
	private Item[] drops;

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
	 * @param drops
	 * 			The id to set.
	 */
	public void setDrops(Item[] drops) {
		this.drops = drops;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item[] getDrops() {
		return this.drops;
	}
}