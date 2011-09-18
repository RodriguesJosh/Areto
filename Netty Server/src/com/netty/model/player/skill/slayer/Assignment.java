package com.netty.model.player.skill.slayer;

public class Assignment {

	private Master master;
	private Creature creature;
	private short creatureAmount;

	public Assignment(Master master, Creature creature, short creatureAmount) {
		this.setMaster(master);
		this.setCreature(creature);
		this.setCreatureAmount(creatureAmount);
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public Master getMaster() {
		return this.master;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Creature getCreature() {
		return this.creature;
	}

	public void setCreatureAmount(short creatureAmount) {
		this.creatureAmount = creatureAmount;
	}

	public short getCreatureAmount() {
		return this.creatureAmount;
	}
}