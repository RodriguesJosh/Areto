package com.netty.model.player.minigame.fistguthix;

import com.netty.model.item.Item;
import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:43:01 PM
 */
public enum Reward {

	/**
	 * 
	 */
	NONE,

	/**
	 * 
	 */
	DRUIDIC_MAGE_HOOD,

	/**
	 * 
	 */
	DRUIDIC_MAGE_TOP,

	/**
	 * 
	 */
	DRUIDIC_MAGE_BOTTOM,

	/**
	 * 
	 */
	COMBAT_HOOD,

	/**
	 * 
	 */
	COMBAT_ROBE_TOP,

	/**
	 * 
	 */
	COMBAT_ROBE_BOTTOM,

	/**
	 * 
	 */
	BATTLE_HOOD,

	/**
	 * 
	 */
	BATTLE_ROBE_TOP,

	/**
	 * 
	 */
	BATTLE_ROBE_BOTTOM,

	/**
	 * 
	 */
	GREEN_DHIDE_COIF,

	/**
	 * 
	 */
	BLUE_DHIDE_COIF,

	/**
	 * 
	 */
	RED_DHIDE_COIF,

	/**
	 * 
	 */
	BLACK_DHIDE_COIF,

	/**
	 * 
	 */
	BRONZE_GAUNTLETS,

	/**
	 * 
	 */
	IRON_GAUNTLETS,

	/**
	 * 
	 */
	STEEL_GAUNTLETS,

	/**
	 * 
	 */
	BLACK_GAUNTLETS,

	/**
	 * 
	 */
	MITHRIL_GAUNTLETS,

	/**
	 * 
	 */
	ADAMANT_GAUNTLETS,

	/**
	 * 
	 */
	RUNE_GAUNTLETS,

	/**
	 * 
	 */
	DRAGON_GAUNTLETS,

	/**
	 * 
	 */
	ADAMANT_SPIKESHIELD,

	/**
	 * 
	 */
	ADAMANT_BERSERKER_SPIKESHIELD,

	/**
	 * 
	 */
	RUNE_SPIKESHIELD,

	/**
	 * 
	 */
	RUNE_BERSERKER_SPIKESHIELD,

	/**
	 * 
	 */
	AIR_RUNECRAFTING_GLOVES,

	/**
	 * 
	 */
	WATER_RUNECRAFTING_GLOVES,

	/**
	 * 
	 */
	EARTH_RUNECRAFTING_GLOVES,

	/**
	 * 
	 */
	IRIT_GLOVES,

	/**
	 * 
	 */
	AVANTOE_GLOVES,

	/**
	 * 
	 */
	KWUARM_GLOVES,

	/**
	 * 
	 */
	CADANTINE_GLOVES,

	/**
	 * 
	 */
	DRAGON_SLAYER_GLOVES;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private int tokenAmount;

	/**
	 * 
	 */
	private boolean isMembers;

	/**
	 * 
	 */
	private SkillType[] skillBoosts;

	/**
	 * 
	 * @param item
	 *			The id to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param tokenAmount
	 *			The id to set.
	 */
	public void setTokenAmount(int tokenAmount) {
		this.tokenAmount = tokenAmount;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getTokenAmount() {
		return this.tokenAmount;
	}

	/**
	 * 
	 * @param isMembers
	 *			The id to set.
	 */
	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public boolean isMembers() {
		return this.isMembers;
	}

	/**
	 * 
	 * @param skillBoosts
	 *			The id to set.
	 */
	public void setSkillBoosts(SkillType[] skillBoosts) {
		this.skillBoosts = skillBoosts;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public SkillType[] getSkillBoosts() {
		return this.skillBoosts;
	}
}