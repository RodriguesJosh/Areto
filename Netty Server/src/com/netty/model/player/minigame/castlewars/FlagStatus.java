package com.netty.model.player.minigame.castlewars;

import java.awt.Color;

public enum FlagStatus {

	TAKEN(Color.RED), DROPPED(Color.YELLOW), SAFE(Color.GREEN);

	private Color color;

	private FlagStatus(Color color) {
		this.setColor(color);
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}