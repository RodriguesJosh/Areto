package com.netty.model.player.task.falador;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:15:25 AM
 */
public class FaladorTask extends Task {

	/**
	 * 
	 */
	private Achievement achievement;

	/**
	 * 
	 * @param achievementType
	 * 			The id to set.
	 */
	public FaladorTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.FALADOR, achievementType, this));
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