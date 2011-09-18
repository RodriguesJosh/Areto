package com.netty.model.player.skill.cooking;

public enum FireType {

	RANGE(0), LOG_FIRE(0);

	private int objectID;

	private FireType(int objectID) {
		this.setObjectID(objectID);
	}

	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}

	public int getObjectID() {
		return this.objectID;
	}
}