package com.netty.model.player.minigame.allfiredup;

public class Beacon {

	private Log log;

	public Beacon(Log log) {
		this.setLog(log);
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Log getLog() {
		return this.log;
	}

	public boolean isLit() {
		return (this.getLog() != null) && (this.getLog().getBurnTime() > 0);
	}
}