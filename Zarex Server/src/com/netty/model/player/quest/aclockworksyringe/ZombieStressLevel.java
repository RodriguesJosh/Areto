package com.netty.model.player.quest.aclockworksyringe;

public enum ZombieStressLevel {

	NONE(-1, -1), WET_WILLY(5, 5), NOSE_PINCH(5, 5), PIG_NOSE(5, 5), SHAKE_HEAD(5, 5), INSULT(5, 5);

	private int stress;
	private int cooldown;

	private ZombieStressLevel(int stress, int cooldown) {
		this.setStress(stress);
		this.setCooldown(cooldown);
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getStress() {
		return this.stress;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public int getCooldown() {
		return this.cooldown;
	}
}