package com.netty.model.player.skill.herblore;

public class Herblore {

	private BarbarianPotion barbarianPotion;
	private Potion potion;

	public void setBarbarianPotion(BarbarianPotion barbarianPotion) {
		this.barbarianPotion = barbarianPotion;
	}

	public BarbarianPotion getBarbarianPotion() {
		return this.barbarianPotion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
	}

	public Potion getPotion() {
		return this.potion;
	}
}