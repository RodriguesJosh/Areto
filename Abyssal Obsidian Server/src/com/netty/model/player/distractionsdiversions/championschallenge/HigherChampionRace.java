package com.netty.model.player.distractionsdiversions.championschallenge;

import com.netty.model.combat.CombatType;
import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 2:48:03 PM
 */
public enum HigherChampionRace {

	/**
	 * 
	 */
	LEON_DCOUR,

	/**
	 * 
	 */
	GLOPHREN;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private RuleType ruleType;

	/**
	 * 
	 */
	private short experience;

	/**
	 * 
	 */
	private ScrollType scrollType;

	/**
	 * 
	 */
	private CombatType combatType;

	/**
	 * 
	 * @param npc
	 * 			The npc to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return npc
	 * 			Returns the npc to get.
	 */
	public NPC getNPC() {
		return this.npc;
	}

	/**
	 * 
	 * @param ruleType
	 * 			The ruleType to set.
	 */
	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

	/**
	 * 
	 * @return ruleType
	 * 			Returns the ruleType to get.
	 */
	public RuleType getRuleType() {
		return this.ruleType;
	}

	/**
	 * 
	 * @param experience
	 * 			The experience to set.
	 */
	public void setExperience(short experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return experience
	 * 			Returns the experience to get.
	 */
	public short getExperience() {
		return this.experience;
	}

	/**
	 * 
	 * @param scrollType
	 * 			The scrollType to set.
	 */
	public void setScrollType(ScrollType scrollType) {
		this.scrollType = scrollType;
	}

	/**
	 * 
	 * @return scrollType
	 * 			Returns the scrollType to get.
	 */
	public ScrollType getScrollType() {
		return this.scrollType;
	}

	/**
	 * 
	 * @param combatType
	 * 			The combatType to set.
	 */
	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	/**
	 * 
	 * @return combatType
	 * 			Returns the combatType to get.
	 */
	public CombatType getCombatType() {
		return this.combatType;
	}
}