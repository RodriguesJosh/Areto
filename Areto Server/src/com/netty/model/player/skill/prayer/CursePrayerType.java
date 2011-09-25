package com.netty.model.player.skill.prayer;

import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:43:35 AM
 */
public enum CursePrayerType {

	/**
	 * 
	 */
	NONE(-1),

	/**
	 * 
	 */
	PROTECT_ITEM(0),

	/**
	 * 
	 */
	SAP_WARRIOR(1),

	/**
	 * 
	 */
	SAP_RANGER(2),

	/**
	 * 
	 */
	SAP_MAGE(3),

	/**
	 * 
	 */
	SAP_SPIRIT(4),

	/**
	 * 
	 */
	BERSERKER(5),

	/**
	 * 
	 */
	DEFLECT_SUMMONING(6),

	/**
	 * 
	 */
	DEFLECT_MAGIC(7),
	/**
	 * 
	 */
	DEFLECT_MISSILES(8),

	/**
	 * 
	 */
	DEFLECT_MELEE(9),

	/**
	 * 
	 */
	LEECH_MELEE(10),

	/**
	 * 
	 */
	LEECH_RANGED(11),

	/**
	 * 
	 */
	LEECH_MAGIC(12),

	/**
	 * 
	 */
	LEECH_DEFENCE(13),

	/**
	 * 
	 */
	LEECH_STRENGTH(14),

	/**
	 * 
	 */
	LEECH_ENERGY(15),

	/**
	 * 
	 */
	LEECH_SPECIAL_ATTACK(16),

	/**
	 * 
	 */
	WRATH(17),

	/**
	 * 
	 */
	SOUL_SPLIT(18),

	/**
	 * 
	 */
	TURMOIL(19);

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private SkillType skillType;

	/**
	 * 
	 */
	private int percentage;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	private CursePrayerType(int id) {
		this.setID(id);
		this.setSkillType(SkillType.ATTACK);
		this.setPercentage(0);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
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
	 * @param percentage
	 * 			The id to set.
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getPercentage() {
		return this.percentage;
	}
}