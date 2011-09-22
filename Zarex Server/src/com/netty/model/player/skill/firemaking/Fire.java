package com.netty.model.player.skill.firemaking;

import com.netty.world.Location;

public class Fire {

	private Location fireLocation;
	private long fireTime;
	private int animationID;

	public Fire(Location fireLocation, long fireTime, int animationID) {
		this.setFireLocation(fireLocation);
		this.setFireTime(fireTime);
		this.setAnimationID(animationID);
	}

	public void setFireLocation(Location fireLocation) {
		this.fireLocation = fireLocation;
	}

	public Location getFireLocation() {
		return this.fireLocation;
	}

	public void setFireTime(long fireTime) {
		this.fireTime = fireTime;
	}

	public long getFireTime() {
		return this.fireTime;
	}

	public void setAnimationID(int animationID) {
		this.animationID = animationID;
	}

	public int getAnimationID() {
		return this.animationID;
	}
}