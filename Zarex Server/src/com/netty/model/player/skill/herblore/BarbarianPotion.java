package com.netty.model.player.skill.herblore;

public enum BarbarianPotion {

	ATTACK_MIX, ANTIPOISON_MIX, RELICYMS_BALM_MIX, STRENGTH_MIX, STAT_RESTORE_MIX, ENERGY_MIX, DEFENCE_MIX, AGILITY_MIX, COMBAT_MIX, PRAYER_MIX,
	SUPER_ATTACK_MIX, SUPER_ANTIPOISON_MIX, FISHING_MIX, SUPER_ENERGY_MIX, HUNTING_MIX, SUPER_STRENGTH_MIX, MAGIC_ESSENCE_MIX, SUPER_RESTORE_MIX,
	SUPER_DEFENCE_MIX, EXTRA_STRONG_ANTIPOISON_MIX, ANTIFIRE_MIX, RANGING_MIX, MAGIC_MIX, ZAMORAK_MIX;

	private Ingrediant[] firstIngrediants;
	private Ingrediant[] secondIngrediants;

	public void setFirstIngrediants(Ingrediant[] firstIngrediants) {
		this.firstIngrediants = firstIngrediants;
	}

	public Ingrediant[] getFirstIngrediants() {
		return this.firstIngrediants;
	}

	public void setSecondIngrediants(Ingrediant[] secondIngrediants) {
		this.secondIngrediants = secondIngrediants;
	}

	public Ingrediant[] getSecondIngrediants() {
		return this.secondIngrediants;
	}
}