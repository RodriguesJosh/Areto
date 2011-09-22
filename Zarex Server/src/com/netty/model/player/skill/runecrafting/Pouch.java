package com.netty.model.player.skill.runecrafting;

public enum Pouch {

	SMALL(3, 1), MEDIUM(6, 25), LARGE(9, 50), GIANT(12, 75);

	private Pouch(int amount, int level) {
		this.setAmount(amount);
		this.setLevel(level);
	}

	private int amount;
	private int level;

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}