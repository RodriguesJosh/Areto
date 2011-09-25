package com.netty.model.player.quest.unstablefoundations;

import com.netty.model.update.Appearance;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:45:18 PM
 */
public enum AccountType {

	/**
	 * 
	 */
	ADVENTURER,

	/**
	 * 
	 */
	WARRIOR,

	/**
	 * 
	 */
	MAGE,

	/**
	 * 
	 */
	RANGER,

	/**
	 * 
	 */
	SLAYER,

	/**
	 * 
	 */
	THIEF,

	/**
	 * 
	 */
	ATHLETE,

	/**
	 * 
	 */
	HUNTER,

	/**
	 * 
	 */
	CHEF,

	/**
	 * 
	 */
	WOODCUTTER,

	/**
	 * 
	 */
	FISHER,

	/**
	 * 
	 */
	PRIEST,

	/**
	 * 
	 */
	MINER,

	/**
	 * 
	 */
	FARMER,

	/**
	 * 
	 */
	SMITH,

	/**
	 * 
	 */
	CRAFTER,

	/**
	 * 
	 */
	FLETCHER,

	/**
	 * 
	 */
	HERBLORIST,

	/**
	 * 
	 */
	SUMMONER,

	/**
	 * 
	 */
	RUNECRAFTER;

	/**
	 * 
	 */
	private Appearance appearance;

	/**
	 * 
	 */
	private GenderType genderType;

	/**
	 * 
	 */
	private Appearance[] appearanceStyles;

	/**
	 * 
	 * @param appearance
	 * 			The id to set.
	 */
	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Appearance getAppearance() {
		return this.appearance;
	}

	/**
	 * 
	 * @param genderType
	 * 			The id to set.
	 */
	public void setGenderType(GenderType genderType) {
		this.genderType = genderType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public GenderType getGenderType() {
		return this.genderType;
	}

	/**
	 * 
	 * @param appearanceStyles
	 * 			The id to set.
	 */
	public void setAppearanceStyles(Appearance[] appearanceStyles) {
		this.appearanceStyles = appearanceStyles;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Appearance[] getAppearanceStyles() {
		return this.appearanceStyles;
	}
}