package com.netty.model.player.minigame.blastfurnace;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:08:46 PM
 */
public class FurnaceStove {

	/**
	 * 
	 */
	private GrateColor grateColor;

	/**
	 * 
	 */
	public FurnaceStove() {
		this.setGrateColor(GrateColor.COLD);
	}

	/**
	 * 
	 * @param grateColor
	 * 			The id to set.
	 */
	public void setGrateColor(GrateColor grateColor) {
		this.grateColor = grateColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public GrateColor getGrateColor() {
		return this.grateColor;
	}
}