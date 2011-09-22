package com.netty.model.player.minigame.greatorbproject;

public enum Round {

	AIR_ALTAR(false), MIND_ALTAR(false), WATER_ALTAR(false), EARTH_ALTAR(false), FIRE_ALTAR(false), BODY_ALTAR(false), CHAOS_ALTAR(true),
	NATURE_ALTAR(true);

	private boolean isMembers;

	private Round(boolean isMembers) {
		this.setMembers(isMembers);
	}

	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	public boolean isMembers() {
		return this.isMembers;
	}
}