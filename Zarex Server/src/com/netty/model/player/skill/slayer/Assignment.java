package com.netty.model.player.skill.slayer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:41:26 AM
 */
public class Assignment {

	/**
	 * 
	 */
	private Master master;

	/**
	 * 
	 */
	private Creature creature;

	/**
	 * 
	 */
	private short creatureAmount;

	/**
	 * 
	 * @param master
	 * 			The id to set.
	 * @param creature
	 * 			The id to set.
	 * @param creatureAmount
	 * 			The id to set.
	 */
	public Assignment(Master master, Creature creature, short creatureAmount) {
		this.setMaster(master);
		this.setCreature(creature);
		this.setCreatureAmount(creatureAmount);
	}

	/**
	 * 
	 * @param master
	 * 			The id to set.
	 */
	public void setMaster(Master master) {
		this.master = master;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Master getMaster() {
		return this.master;
	}

	/**
	 * 
	 * @param creature
	 * 			The id to set.
	 */
	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Creature getCreature() {
		return this.creature;
	}

	/**
	 * 
	 * @param creatureAmount
	 * 			The id to set.
	 */
	public void setCreatureAmount(short creatureAmount) {
		this.creatureAmount = creatureAmount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getCreatureAmount() {
		return this.creatureAmount;
	}
}