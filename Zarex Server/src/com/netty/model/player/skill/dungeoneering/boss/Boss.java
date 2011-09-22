package com.netty.model.player.skill.dungeoneering.boss;

import com.netty.model.item.Item;
import com.netty.model.player.skill.dungeoneering.FloorType;

public abstract class Boss {

	private FloorType floorType;
	private byte level;
	private Item[] drops;

	public void setFloorType(FloorType floorType) {
		this.floorType = floorType;
	}

	public FloorType getFloorType() {
		return this.floorType;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public byte getLevel() {
		return this.level;
	}

	public void setDrops(Item[] drops) {
		this.drops = drops;
	}

	public Item[] getDrops() {
		return this.drops;
	}
}