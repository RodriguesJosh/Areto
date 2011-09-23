package com.netty.model.player.task.varrock;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:48:27 PM
 */
public class VarrockTask extends Task {

	/**
	 * 
	 */
	private Achievement achievement;

	/**
	 * 
	 * @param achievementType
	 * 			The id to set.
	 */
	public VarrockTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.VARROCK, achievementType, this));
	}

	/**
	 * 
	 * @param achievement
	 * 			The id to set.
	 */
	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Achievement getAchievement() {
		return this.achievement;
	}
}