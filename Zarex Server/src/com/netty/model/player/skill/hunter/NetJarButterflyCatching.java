package com.netty.model.player.skill.hunter;

import com.netty.model.npc.NPC;
import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:33:34 PM
 */
public enum NetJarButterflyCatching {

	/**
	 * 
	 */
	RUBY_HARVEST,

	/**
	 * 
	 */
	SAPPHIRE_GLACIALIS,

	/**
	 * 
	 */
	SNOWY_KNIGHT,

	/**
	 * 
	 */
	BLACK_WARLOCK;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private Region[] regions;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private SkillType skillType;

	/**
	 * 
	 */
	private int skillAmountRaised;

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC getNPC() {
		return this.npc;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param regions
	 * 			The id to set.
	 */
	public void setRegions(Region[] regions) {
		this.regions = regions;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Region[] getRegions() {
		return this.regions;
	}

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getExperience() {
		return this.experience;
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
	 * @param skillAmountRaised
	 * 			The id to set.
	 */
	public void setSkillAmountRaised(int skillAmountRaised) {
		this.skillAmountRaised = skillAmountRaised;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getSkillAmountRaised() {
		return this.skillAmountRaised;
	}
}