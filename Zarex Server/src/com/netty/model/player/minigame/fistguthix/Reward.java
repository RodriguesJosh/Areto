package com.netty.model.player.minigame.fistguthix;

import com.netty.model.item.Item;
import com.netty.model.player.skill.SkillType;

public enum Reward {

	NONE, DRUIDIC_MAGE_HOOD, DRUIDIC_MAGE_TOP, DRUIDIC_MAGE_BOTTOM, COMBAT_HOOD, COMBAT_ROBE_TOP, COMBAT_ROBE_BOTTOM, BATTLE_HOOD, BATTLE_ROBE_TOP,
	BATTLE_ROBE_BOTTOM, GREEN_DHIDE_COIF, BLUE_DHIDE_COIF, RED_DHIDE_COIF, BLACK_DHIDE_COIF, BRONZE_GAUNTLETS, IRON_GAUNTLETS, STEEL_GAUNTLETS,
	BLACK_GAUNTLETS, MITHRIL_GAUNTLETS, ADAMANT_GAUNTLETS, RUNE_GAUNTLETS, DRAGON_GAUNTLETS, ADAMANT_SPIKESHIELD, ADAMANT_BERSERKER_SPIKESHIELD,
	RUNE_SPIKESHIELD, RUNE_BERSERKER_SPIKESHIELD, AIR_RUNECRAFTING_GLOVES, WATER_RUNECRAFTING_GLOVES, EARTH_RUNECRAFTING_GLOVES, IRIT_GLOVES,
	AVANTOE_GLOVES, KWUARM_GLOVES, CADANTINE_GLOVES, DRAGON_SLAYER_GLOVES;

	private Item item;
	private int tokenAmount;
	private boolean isMembers;
	private SkillType[] skillBoosts;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setTokenAmount(int tokenAmount) {
		this.tokenAmount = tokenAmount;
	}

	public int getTokenAmount() {
		return this.tokenAmount;
	}

	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	public boolean isMembers() {
		return this.isMembers;
	}

	public void setSkillBoosts(SkillType[] skillBoosts) {
		this.skillBoosts = skillBoosts;
	}

	public SkillType[] getSkillBoosts() {
		return this.skillBoosts;
	}
}