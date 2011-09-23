package com.netty.model.player.skill.herblore;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:59:04 AM
 */
public enum Potion {

	/**
	 * 
	 */
	ATTACK_POTION,

	/**
	 * 
	 */
	ANTIPOISON,

	/**
	 * 
	 */
	RELICYMS_BALM,

	/**
	 * 
	 */
	STRENGTH_POTION,

	/**
	 * 
	 */
	SERUM_207,

	/**
	 * 
	 */
	GUTHIX_REST,

	/**
	 * 
	 */
	GUAM_TAR,

	/**
	 * 
	 */
	RESTORE_POTION,

	/**
	 * 
	 */
	GUTHIX_BALANCE,

	/**
	 * 
	 */
	BLAMISH_OIL,
	/**
	 * 
	 */
	ENERGY_POTION,

	/**
	 * 
	 */
	DEFENCE_POTION,

	/**
	 * 
	 */
	MARRENTILL_TAR,

	/**
	 * 
	 */
	SUPER_FISHING_EXPLOSIVE,

	/**
	 * 
	 */
	AGILITY_POTION,

	/**
	 * 
	 */
	COMBAT_POTION,

	/**
	 * 
	 */
	GOBLIN_POTION,

	/**
	 * 
	 */
	PRAYER_POTION,

	/**
	 * 
	 */
	TARROMIN_TAR,

	/**
	 * 
	 */
	SUMMONING_POTION,

	/**
	 * 
	 */
	CRAFTING_POTION,

	/**
	 * 
	 */
	HARRALANDER_TAR,

	/**
	 * 
	 */
	SUPER_ATTACK,

	/**
	 * 
	 */
	VIAL_OF_STENCH,

	/**
	 * 
	 */
	SUPER_ANTIPOISON,

	/**
	 * 
	 */
	FISHING_POTION,

	/**
	 * 
	 */
	SUPER_ENERGY,

	/**
	 * 
	 */
	SHRINK_ME_QUICK,

	/**
	 * 
	 */
	HUNTER_POTION,

	/**
	 * 
	 */
	SUPER_STRENGTH,

	/**
	 * 
	 */
	MAGIC_ESSENCE_POTION,

	/**
	 * 
	 */
	FLETCHING_POTION,

	/**
	 * 
	 */
	WEAPON_POISON,

	/**
	 * 
	 */
	SUPER_RESTORE,

	/**
	 * 
	 */
	SANFEW_SERUM,

	/**
	 * 
	 */
	SUPER_DEFENCE,

	/**
	 * 
	 */
	ANTIPOISON_PLUS,

	/**
	 * 
	 */
	ANTIFIRE,

	/**
	 * 
	 */
	RANGING_POTION,

	/**
	 * 
	 */
	WEAPON_POISON_PLUS,

	/**
	 * 
	 */
	MAGIC_POTION,

	/**
	 * 
	 */
	ZAMORAK_BREW,

	/**
	 * 
	 */
	ANTIPOISON_PLUS_PLUS,

	/**
	 * 
	 */
	SARADOMIN_BREW,

	/**
	 * 
	 */
	WEAPON_POISON_PLUS_PLUS,

	/**
	 * 
	 */
	RECOVER_SPECIAL,

	/**
	 * 
	 */
	SUPER_ANTIFIRE,

	/**
	 * 
	 */
	EXTREME_ATTACK,

	/**
	 * 
	 */
	EXTREME_STRENGTH,

	/**
	 * 
	 */
	EXTREME_DEFENCE,

	/**
	 * 
	 */
	EXTREME_MAGIC,

	/**
	 * 
	 */
	EXTREME_RANGING,

	/**
	 * 
	 */
	SUPER_PRAYER,

	/**
	 * 
	 */
	OVERLOAD;

	/**
	 * 
	 */
	private Ingrediant[] firstIngrediants;

	/**
	 * 
	 */
	private Ingrediant[] secondIngrediants;

	/**
	 * 
	 * @param firstIngrediants
	 * 			The id to set.
	 */
	public void setFirstIngrediants(Ingrediant[] firstIngrediants) {
		this.firstIngrediants = firstIngrediants;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Ingrediant[] getFirstIngrediants() {
		return this.firstIngrediants;
	}

	/**
	 * 
	 * @param secondIngrediants
	 * 			The id to set.
	 */
	public void setSecondIngrediants(Ingrediant[] secondIngrediants) {
		this.secondIngrediants = secondIngrediants;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Ingrediant[] getSecondIngrediants() {
		return this.secondIngrediants;
	}
}