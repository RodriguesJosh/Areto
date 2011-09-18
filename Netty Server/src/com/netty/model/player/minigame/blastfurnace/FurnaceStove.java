package com.netty.model.player.minigame.blastfurnace;

public class FurnaceStove {

	private GrateColor grateColor;

	public FurnaceStove() {
		this.setGrateColor(GrateColor.COLD);
	}

	public void setGrateColor(GrateColor grateColor) {
		this.grateColor = grateColor;
	}

	public GrateColor getGrateColor() {
		return this.grateColor;
	}
}