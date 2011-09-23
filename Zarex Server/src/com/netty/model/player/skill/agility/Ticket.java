package com.netty.model.player.skill.agility;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:58:56 PM
 */
public enum Ticket {

	/**
	 * 
	 */
	ONE(240, 264),

	/**
	 * 
	 */
	TEN(2480, 2728),

	/**
	 * 
	 */
	TWENTY_FIVE(6500, 7150),

	/**
	 * 
	 */
	ONE_HUNDRED(28000, 30800),

	/**
	 * 
	 */
	ONE_THOUSAND(320000, 352000);

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private int glovesExperience;

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 * @param glovesExperience
	 * 			The id to set.
	 */
	private Ticket(int experience, int glovesExperience) {
		this.setExperience(experience);
		this.setGlovesExperience(glovesExperience);
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

	/**
	 * 
	 * @param glovesExperience
	 * 			The id to set.
	 */
	public void setGlovesExperience(int glovesExperience) {
		this.glovesExperience = glovesExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getGlovesExperience() {
		return this.glovesExperience;
	}
}