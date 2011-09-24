package com.netty.model.player.distractionsdiversions.ancienteffigies;

import com.netty.model.player.distractionsdiversions.DistractionsAndDiversions;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:16:10 PM
 */
public class AncientEffigies extends DistractionsAndDiversions {

	/**
	 * 
	 */
	private Stage stage;

	/* (non-Javadoc)
	 * @see com.netty.model.player.distractionsdiversions.DistractionsAndDiversions#end()
	 */
	@Override
	public void end() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.distractionsdiversions.DistractionsAndDiversions#start()
	 */
	@Override
	public void start() {
		//
	}

	/**
	 * 
	 * @param stage
	 * 			The stage to set.
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * 
	 * @return stage
	 * 			Returns the stage to get.
	 */
	public Stage getStage() {
		return this.stage;
	}
}