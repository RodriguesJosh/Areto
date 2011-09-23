package com.netty.model.player.minigame.blastfurnace;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:10:02 PM
 */
public class TemperatureGauge {

	/**
	 * 
	 */
	private TemperatureColor temperatureColor;

	/**
	 * 
	 */
	public TemperatureGauge() {
		this.setTemperatureColor(TemperatureColor.WHITE);
	}

	/**
	 * 
	 * @param temperatureColor
	 * 			The id to set.
	 */
	public void setTemperatureColor(TemperatureColor temperatureColor) {
		this.temperatureColor = temperatureColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public TemperatureColor getTemperatureColor() {
		return this.temperatureColor;
	}
}