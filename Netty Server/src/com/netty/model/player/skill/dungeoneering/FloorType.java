package com.netty.model.player.skill.dungeoneering;

public enum FloorType {

	FROZEN, ABANDONED_ONE, FURNISHED, ABANDONED_TWO, OCCULT, WARPED;

	private boolean isMembers;

	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	public boolean isMembers() {
		return this.isMembers;
	}
}