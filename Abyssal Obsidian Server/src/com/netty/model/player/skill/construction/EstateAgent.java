package com.netty.model.player.skill.construction;

import com.netty.model.player.Teleport;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:06:28 PM
 */
public enum EstateAgent {

	/**
	 * 
	 */
	VARROCK,

	/**
	 * 
	 */
	FALADOR,

	/**
	 * 
	 */
	SEERS_VILLAGE,

	/**
	 * 
	 */
	EAST_ARDOUGNE;

	/**
	 * 
	 */
	private Teleport teleport;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int fee;

	/**
	 * 
	 * @param teleport
	 * 			The id to set.
	 */
	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Teleport getTeleport() {
		return this.teleport;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param fee
	 * 			The id to set.
	 */
	public void setFee(int fee) {
		this.fee = fee;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getFee() {
		return this.fee;
	}
}