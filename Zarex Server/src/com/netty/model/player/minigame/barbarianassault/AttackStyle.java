package com.netty.model.player.minigame.barbarianassault;

import com.netty.model.combat.CombatType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:59:28 PM
 */
public enum AttackStyle {

	/**
	 * 
	 */
	CONTROLLED(CombatType.MELEE),

	/**
	 * 
	 */
	BRONZE(CombatType.RANGE),

	/**
	 * 
	 */
	WIND(CombatType.MAGIC),

	/**
	 * 
	 */
	ACCURATE(CombatType.MELEE),

	/**
	 * 
	 */
	IRON(CombatType.RANGE),

	/**
	 * 
	 */
	WATER(CombatType.MAGIC),

	/**
	 * 
	 */
	AGGRESSIVE(CombatType.MELEE),

	/**
	 * 
	 */
	STEEL(CombatType.RANGE),

	/**
	 * 
	 */
	EARTH(CombatType.MAGIC),

	/**
	 * 
	 */
	DEFENSIVE(CombatType.MELEE),

	/**
	 * 
	 */
	MITHRIL(CombatType.RANGE),

	/**
	 * 
	 */
	FIRE(CombatType.MAGIC);

	/**
	 * 
	 */
	private CombatType combatType;

	/**
	 * 
	 * @param combatType
	 * 			The id to set.
	 */
	private AttackStyle(CombatType combatType) {
		this.setCombatType(combatType);
	}

	/**
	 * 
	 * @param combatType
	 * 			The id to set.
	 */
	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public CombatType getCombatType() {
		return this.combatType;
	}
}