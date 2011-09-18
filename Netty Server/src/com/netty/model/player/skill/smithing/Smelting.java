package com.netty.model.player.skill.smithing;

import com.netty.model.player.skill.mining.Ore;

public enum Smelting {

	BRONZE, BLURITE, IRON, ELEMENTAL, SILVER, STEEL, GOLD, MITHRIL, ADAMANT, RUNE;

	private Ore[] firstOres;
	private Ore[] secondOres;
	private int level;
	private int experience;

	public void setFirstOres(Ore[] firstOres) {
		this.firstOres = firstOres;
	}

	public Ore[] getFirstOres() {
		return this.firstOres;
	}

	public void setSecondOres(Ore[] secondOres) {
		this.secondOres = secondOres;
	}

	public Ore[] getSecondOres() {
		return this.secondOres;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}
}