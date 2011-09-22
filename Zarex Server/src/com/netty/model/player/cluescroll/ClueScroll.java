package com.netty.model.player.cluescroll;

public abstract class ClueScroll {

	private ClueScrollLevel clueScrollLevel;

	public ClueScroll(ClueScrollLevel clueScrollLevel) {
		this.setClueScrollLevel(clueScrollLevel);
	}

	public abstract String getClueMessage();

	public void setClueScrollLevel(ClueScrollLevel clueScrollLevel) {
		this.clueScrollLevel = clueScrollLevel;
	}

	public ClueScrollLevel getClueScrollLevel() {
		return this.clueScrollLevel;
	}
}