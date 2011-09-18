package com.netty.model.update;

public enum HitType {

	NO_DAMAGE(0), NORMAL_DAMAGE(1), POISON_DAMAGE(2), DISEASE_DAMAGE(3);

	private int hitID;

	private HitType(int hitID) {
		this.setHitID(hitID);
	}

	public void setHitID(int hitID) {
		this.hitID = hitID;
	}

	public int getHitID() {
		return this.hitID;
	}
}