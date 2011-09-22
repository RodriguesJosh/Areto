package com.netty.model.player.skill.summoning;

import com.netty.model.item.Item;
import com.netty.model.npc.NPC;

public enum DogPet {

	BULLDOG, TERRIER, SHEEPDOG, GREYHOUND, DALMATIAN, LABRADOR;

	private NPC npc;
	private int level;
	private Item food;
	private PetType petType;

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setFood(Item food) {
		this.food = food;
	}

	public Item getFood() {
		return this.food;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public PetType getPetType() {
		return this.petType;
	}
}