package com.netty.model.player.minigame.greatorbproject;

import com.netty.model.item.Item;

public enum Team {

	GREEN, YELLOW;

	private Item runecrafterHat;
	private Item repellerWand;
	private Item attractorWand;
	private Item barrierGenerator;

	public void setRunecrafterHat(Item runecrafterHat) {
		this.runecrafterHat = runecrafterHat;
	}

	public Item getRunecrafterHat() {
		return this.runecrafterHat;
	}

	public void setRepellerWand(Item repellerWand) {
		this.repellerWand = repellerWand;
	}

	public Item getRepellerWand() {
		return this.repellerWand;
	}

	public void setAttractorWand(Item attractorWand) {
		this.attractorWand = attractorWand;
	}

	public Item getAttractorWand() {
		return this.attractorWand;
	}

	public void setBarrierGenerator(Item barrierGenerator) {
		this.barrierGenerator = barrierGenerator;
	}

	public Item getBarrierGenerator() {
		return this.barrierGenerator;
	}
}