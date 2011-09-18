package com.netty.model.player.minigame.barbarianassault;

import com.netty.model.combat.CombatType;

public enum AttackStyle {

	CONTROLLED(CombatType.MELEE), BRONZE(CombatType.RANGE), WIND(CombatType.MAGIC), ACCURATE(CombatType.MELEE), IRON(CombatType.RANGE),
	WATER(CombatType.MAGIC), AGGRESSIVE(CombatType.MELEE), STEEL(CombatType.RANGE), EARTH(CombatType.MAGIC), DEFENSIVE(CombatType.MELEE),
	MITHRIL(CombatType.RANGE), FIRE(CombatType.MAGIC);

	private CombatType combatType;

	private AttackStyle(CombatType combatType) {
		this.setCombatType(combatType);
	}

	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	public CombatType getCombatType() {
		return this.combatType;
	}
}