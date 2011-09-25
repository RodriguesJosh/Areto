package com.netty.model.player.tab.clan.citadels.locations.battlefield.elements;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 9:08:10 PM
 */
public enum Architecture {

	/**
	 * 
	 */
	CLIMBING_FRAME,

	/**
	 * 
	 */
	CLIMBING_BLOCK,

	/**
	 * 
	 */
	PORTALS,

	/**
	 * 
	 */
	DOORS,

	/**
	 * 
	 */
	BARRIERS,

	/**
	 * 
	 */
	BLOCKS;

	/**
	 * 
	 */
	private boolean levelRequirement;

	/**
	 * 
	 */
	private boolean canOvercome;

	/**
	 * 
	 */
	private boolean resilienceDamage;

	/**
	 * 
	 */
	private boolean respawnTime;

	/**
	 * 
	 * @param levelRequirement
	 * 			The levelRequirement to set.
	 */
	public void setLevelRequirement(boolean levelRequirement) {
		this.levelRequirement = levelRequirement;
	}

	/**
	 * 
	 * @return levelRequirement
	 * 			Returns the levelRequirement to get.
	 */
	public boolean isLevelRequirement() {
		return this.levelRequirement;
	}

	/**
	 * 
	 * @param canOvercome
	 * 			The canOvercome to set.
	 */
	public void setCanOvercome(boolean canOvercome) {
		this.canOvercome = canOvercome;
	}

	/**
	 * 
	 * @return canOvercome
	 * 			Returns the canOvercome to get.
	 */
	public boolean isCanOvercome() {
		return this.canOvercome;
	}

	/**
	 * 
	 * @param resilienceDamage
	 * 			The resilienceDamage to set.
	 */
	public void setResilienceDamage(boolean resilienceDamage) {
		this.resilienceDamage = resilienceDamage;
	}

	/**
	 * 
	 * @return resilienceDamage
	 * 			Returns the resilienceDamage to get.
	 */
	public boolean isResilienceDamage() {
		return this.resilienceDamage;
	}

	/**
	 * 
	 * @param respawnTime
	 * 			The respawnTime to set.
	 */
	public void setRespawnTime(boolean respawnTime) {
		this.respawnTime = respawnTime;
	}

	/**
	 * 
	 * @return respawnTime
	 * 			Returns the respawnTime to get.
	 */
	public boolean isRespawnTime() {
		return this.respawnTime;
	}
}