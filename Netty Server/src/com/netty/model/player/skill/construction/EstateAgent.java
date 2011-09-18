package com.netty.model.player.skill.construction;

import com.netty.model.player.Teleport;

public enum EstateAgent {

	VARROCK, FALADOR, SEERS_VILLAGE, EAST_ARDOUGNE;

	private Teleport teleport;
	private int level;
	private int fee;

	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	public Teleport getTeleport() {
		return teleport;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getFee() {
		return fee;
	}
}