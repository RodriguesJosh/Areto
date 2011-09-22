package com.netty.model.player.skill.smithing;

public class Smithing {

	private Smelting smelting;
	private Forging forging;

	public Smithing(Smelting smelting, Forging forging) {
		this.setSmelting(smelting);
		this.setForging(forging);
	}

	public void setSmelting(Smelting smelting) {
		this.smelting = smelting;
	}

	public Smelting getSmelting() {
		return this.smelting;
	}

	public void setForging(Forging forging) {
		this.forging = forging;
	}

	public Forging getForging() {
		return this.forging;
	}
}