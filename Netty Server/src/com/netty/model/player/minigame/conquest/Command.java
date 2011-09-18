package com.netty.model.player.minigame.conquest;

public enum Command {

	BATTLE_CRY, STOICISM, REGENERATE, BOMBARD, WINDS_OF_FATE, CHARGE, CHASTISE, VIGILANCE, SHIELD_WALL;

	private int cooldown;
	private int cost;

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public int getCooldown() {
		return this.cooldown;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return this.cost;
	}
}