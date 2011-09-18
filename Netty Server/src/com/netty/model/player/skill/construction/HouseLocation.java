package com.netty.model.player.skill.construction;

import com.netty.model.player.Teleport;

public enum HouseLocation {

	RIMMINGTON, TAVERLY, POLLNIVNEACH, RELLEKKA, BRIMHAVEN, YANILLE;

	private Teleport teleport;
	private int level;
	private int relocatePrice;

	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	public Teleport getTeleport() {
		return this.teleport;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setRelocatePrice(int relocatePrice) {
		this.relocatePrice = relocatePrice;
	}

	public int getRelocatePrice() {
		return this.relocatePrice;
	}
}