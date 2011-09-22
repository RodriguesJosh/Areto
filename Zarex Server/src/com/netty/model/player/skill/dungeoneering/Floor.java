package com.netty.model.player.skill.dungeoneering;

import com.netty.model.npc.NPC;

public class Floor {

	private FloorType floorType;
	private byte level;
	private NPC[] npcsFound;

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

	public void setNPCSFound(NPC[] npcsFound) {
		this.npcsFound = npcsFound;
	}

	public NPC[] getNPCSFound() {
		return this.npcsFound;
	}
}