package com.netty.util;

public class Timing {

	private long startTime;

	public Timing() {
		this.setStartTime(System.currentTimeMillis());
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStartTime() {
		return this.startTime;
	}

	@Override
	public String toString() {
		return (System.currentTimeMillis() - this.getStartTime()) + "ms";
	}
}