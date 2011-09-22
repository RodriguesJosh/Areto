package com.netty.model.player.minigame.blastfurnace;

public class TemperatureGauge {

	private TemperatureColor temperatureColor;

	public TemperatureGauge() {
		this.setTemperatureColor(TemperatureColor.WHITE);
	}

	public void setTemperatureColor(TemperatureColor temperatureColor) {
		this.temperatureColor = temperatureColor;
	}

	public TemperatureColor getTemperatureColor() {
		return this.temperatureColor;
	}
}