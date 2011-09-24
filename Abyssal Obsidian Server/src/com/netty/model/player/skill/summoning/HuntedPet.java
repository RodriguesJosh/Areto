package com.netty.model.player.skill.summoning;

import com.netty.model.item.Item;
import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:29:14 AM
 */
public enum HuntedPet {

	/**
	 * 
	 */
	BABY_GECKO,

	/**
	 * 
	 */
	BABY_PLATYPUS,

	/**
	 * 
	 */
	BABY_SQUIRREL,

	/**
	 * 
	 */
	BABY_RACCOON,

	/**
	 * 
	 */
	BABY_MONKEY;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private Item food;

	/**
	 * 
	 */
	private PetType petType;

	/**
	 * 
	 */
	private Trap trap;

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC getNPC() {
		return this.npc;
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
	 * @param food
	 * 			The id to set.
	 */
	public void setFood(Item food) {
		this.food = food;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getFood() {
		return this.food;
	}

	/**
	 * 
	 * @param petType
	 * 			The id to set.
	 */
	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PetType getPetType() {
		return this.petType;
	}

	/**
	 * 
	 * @param trap
	 * 			The id to set.
	 */
	public void setTrap(Trap trap) {
		this.trap = trap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Trap getTrap() {
		return this.trap;
	}
}