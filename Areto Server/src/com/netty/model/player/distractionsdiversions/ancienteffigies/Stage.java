package com.netty.model.player.distractionsdiversions.ancienteffigies;

import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:16:38 PM
 */
public enum Stage {

	/**
	 * 
	 */
	STARVED_ANCIENT_EFFIGIE((byte) 91, Stage.getSkillType()),

	/**
	 * 
	 */
	NOURISHED_ANCIENT_EFFIGIE((byte) 93, Stage.getSkillType()),

	/**
	 * 
	 */
	SATED_ANCIENT_EFFIGIE((byte) 95, Stage.getSkillType()),

	/**
	 * 
	 */
	GORGED_ANCIENT_EFFIGIE((byte) 97, Stage.getSkillType());

	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 */
	private static SkillType skillType;

	/**
	 * 
	 * 
	 * @param level
	 * 			The level for the effigy.
	 * @param skillType
	 * 			The type of skill used.
	 */
	private Stage(byte level, SkillType skillType) {
		this.setLevel(level);
		SkillType[] skillTypes = {
				SkillType.ATTACK, SkillType.DEFENCE, SkillType.DUNGEONEERING, SkillType.HITPOINT,
				SkillType.MAGIC, SkillType.PRAYER, SkillType.RANGE, SkillType.SLAYER, SkillType.STRENGTH
		};
		for (byte b = 0; b < skillTypes.length; b++) {
			if (skillType == skillTypes[b]) {
				return;
			}
		}
		Stage.setSkillType(skillType);

	}

	/**
	 * 
	 * @param level
	 * 			The level to set.
	 */
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return level
	 * 			Returns the level to get.
	 */
	public byte getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param skillType
	 * 			The skillType to set.
	 */
	public static void setSkillType(SkillType skillType) {
		Stage.skillType = skillType;
	}

	/**
	 * 
	 * @return skillType
	 * 			Returns the skillType to get.
	 */
	public static SkillType getSkillType() {
		return Stage.skillType;
	}
}