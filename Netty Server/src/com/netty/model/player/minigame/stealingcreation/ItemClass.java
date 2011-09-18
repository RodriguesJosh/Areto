package com.netty.model.player.minigame.stealingcreation;

public enum ItemClass {

	ONE(1), TWO(20), THREE(40), FOUR(60), FIVE(80);

	private int level;

	private ItemClass(int level) {
		this.setLevel(level);
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}