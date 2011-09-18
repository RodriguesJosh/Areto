package com.netty.model.player.skill.dungeoneering.doors;

import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.skill.runecrafting.Runecrafting;

public enum SkillDoor {

	RUNED_DOOR(SkillType.RUNECRAFTING, Runecrafting.class), BARRED_DOOR(SkillType.STRENGTH, MeleeCombat.class);

	private SkillType skillType;
	private Class<?> skillUsed;

	private SkillDoor(SkillType skillType, Class<?> skillUsed) {
		this.setSkillType(skillType);
		this.setSkillUsed(skillUsed);
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public SkillType getSkillType() {
		return this.skillType;
	}

	public void setSkillUsed(Class<?> skillUsed) {
		this.skillUsed = skillUsed;
	}

	public Class<?> getSkillUsed() {
		return this.skillUsed;
	}
}