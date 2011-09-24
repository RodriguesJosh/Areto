package com.netty.model.player.skill.hunter;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:34:36 PM
 */
public enum Pitfalls {

	/**
	 * 
	 */
	SPINED_LARUPIA,

	/**
	 * 
	 */
	HORNED_GRAAHK,

	/**
	 * 
	 */
	SABRE_TOOTHED_KYATT;

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
}