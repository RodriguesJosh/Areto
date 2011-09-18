package com.netty.model.player.minigame.allfiredup;

public enum Log {

	REGULAR((double) 13.0), OAK((double) 13.5), WILLOW((double) 14.5), MAPLE((double) 15.75), YEW((double) 16.5), MAGIC((double) 18.0);

	private double burnTime;

	private Log(double burnTime) {
		this.setBurnTime(burnTime);
	}

	public void setBurnTime(double burnTime) {
		this.burnTime = burnTime;
	}

	public double getBurnTime() {
		return this.burnTime;
	}
}