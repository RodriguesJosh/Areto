package com.netty.model.player.quest.learningtheropes;

import com.netty.model.update.Appearance;

public enum AccountType {

	ADVENTURER, WARRIOR, MAGE, RANGER, SLAYER, THIEF, ATHLETE, HUNTER, CHEF, WOODCUTTER, FISHER, PRIEST,
	MINER, FARMER, SMITH, CRAFTER, FLETCHER, HERBLORIST, SUMMONER, RUNECRAFTER;

	private Appearance appearance;
	private GenderType genderType;
	private Appearance[] appearanceStyles;

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	public Appearance getAppearance() {
		return this.appearance;
	}

	public void setGenderType(GenderType genderType) {
		this.genderType = genderType;
	}

	public GenderType getGenderType() {
		return this.genderType;
	}

	public void setAppearanceStyles(Appearance[] appearanceStyles) {
		this.appearanceStyles = appearanceStyles;
	}

	public Appearance[] getAppearanceStyles() {
		return this.appearanceStyles;
	}
}