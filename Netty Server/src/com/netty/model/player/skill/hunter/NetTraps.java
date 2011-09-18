package com.netty.model.player.skill.hunter;

import com.netty.model.npc.NPC;

public enum NetTraps {

	BABY_SQUIRREL, SWAMP_LIZARD, ORANGE_SALAMANDER, PENGUIN, RED_SALAMANDER, BLACK_SALAMANDER;

	private NPC npc;
	private int level;
	private Region[] regions;
	private int experience;

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setRegions(Region[] regions) {
		this.regions = regions;
	}

	public Region[] getRegions() {
		return this.regions;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}
}