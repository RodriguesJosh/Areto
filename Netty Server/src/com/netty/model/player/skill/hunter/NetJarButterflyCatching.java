package com.netty.model.player.skill.hunter;

import com.netty.model.npc.NPC;
import com.netty.model.player.skill.SkillType;

public enum NetJarButterflyCatching {

	RUBY_HARVEST, SAPPHIRE_GLACIALIS, SNOWY_KNIGHT, BLACK_WARLOCK;

	private NPC npc;
	private int level;
	private Region[] regions;
	private int experience;
	private SkillType skillType;
	private int skillAmountRaised;

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

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public SkillType getSkillType() {
		return this.skillType;
	}

	public void setSkillAmountRaised(int skillAmountRaised) {
		this.skillAmountRaised = skillAmountRaised;
	}

	public int getSkillAmountRaised() {
		return this.skillAmountRaised;
	}
}