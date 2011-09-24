package com.netty.model.player.skill.dungeoneering.doors;

import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.skill.runecrafting.Runecrafting;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:02:28 AM
 */
public enum SkillDoor {

	/**
	 * 
	 */
	RUNED_DOOR(SkillType.RUNECRAFTING, Runecrafting.class),

	/**
	 * 
	 */
	BARRED_DOOR(SkillType.STRENGTH, MeleeCombat.class);

	/**
	 * 
	 */
	private SkillType skillType;

	/**
	 * 
	 */
	private Class<?> skillUsed;

	/**
	 * 
	 * @param skillType
	 * 			The id to set.
	 * @param skillUsed
	 * 			The id to set.
	 */
	private SkillDoor(SkillType skillType, Class<?> skillUsed) {
		this.setSkillType(skillType);
		this.setSkillUsed(skillUsed);
	}

	/**
	 * 
	 * @param skillType
	 * 			The id to set.
	 */
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SkillType getSkillType() {
		return this.skillType;
	}

	/**
	 * 
	 * @param skillUsed
	 * 			The id to set.
	 */
	public void setSkillUsed(Class<?> skillUsed) {
		this.skillUsed = skillUsed;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Class<?> getSkillUsed() {
		return this.skillUsed;
	}
}