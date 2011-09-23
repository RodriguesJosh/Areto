package com.netty.model.player.minigame.stealingcreation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:25:52 PM
 */
public class Tutorial {

	/**
	 * 
	 */
	private TutorialStage tutorialStage;

	/**
	 * 
	 * @param tutorialStage
	 * 			The id to set.
	 */
	public void setTutorialStage(TutorialStage tutorialStage) {
		this.tutorialStage = tutorialStage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public TutorialStage getTutorialStage() {
		return this.tutorialStage;
	}
}