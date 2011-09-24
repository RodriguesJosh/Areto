package com.netty.model.player.quest.aclockworksyringe;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:55:22 PM
 */
public enum ZombieStressLevel {

	/**
	 * 
	 */
	NONE(-1, -1),

	/**
	 * 
	 */
	WET_WILLY(5, 5),

	/**
	 * 
	 */
	NOSE_PINCH(5, 5),

	/**
	 * 
	 */
	PIG_NOSE(5, 5),

	/**
	 * 
	 */
	SHAKE_HEAD(5, 5),

	/**
	 * 
	 */
	INSULT(5, 5);

	/**
	 * 
	 */
	private int stress;

	/**
	 * 
	 */
	private int cooldown;

	/**
	 * 
	 * @param stress
	 * 			The id to set.
	 * @param cooldown
	 * 			The id to set.
	 */
	private ZombieStressLevel(int stress, int cooldown) {
		this.setStress(stress);
		this.setCooldown(cooldown);
	}

	/**
	 * 
	 * @param stress
	 * 			The id to set.
	 */
	public void setStress(int stress) {
		this.stress = stress;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getStress() {
		return this.stress;
	}

	/**
	 * 
	 * @param cooldown
	 * 			The id to set.
	 */
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCooldown() {
		return this.cooldown;
	}
}