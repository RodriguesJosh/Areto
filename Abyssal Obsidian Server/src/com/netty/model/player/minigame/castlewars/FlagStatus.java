package com.netty.model.player.minigame.castlewars;

import java.awt.Color;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:23:57 PM
 */
public enum FlagStatus {

	/**
	 * 
	 */
	TAKEN(Color.RED),

	/**
	 * 
	 */
	DROPPED(Color.YELLOW),

	/**
	 * 
	 */
	SAFE(Color.GREEN);

	/**
	 * 
	 */
	private Color color;

	/**
	 * 
	 * @param color
	 *			The id to set.
	 */
	private FlagStatus(Color color) {
		this.setColor(color);
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * 
	 * @param color
	 *			The id to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}