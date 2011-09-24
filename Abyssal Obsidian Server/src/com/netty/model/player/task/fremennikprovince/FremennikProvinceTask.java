package com.netty.model.player.task.fremennikprovince;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:15:38 AM
 */
public class FremennikProvinceTask extends Task {

	/**
	 * 
	 */
	private Achievement achievement;

	/**
	 * 
	 * @param achievementType
	 * 			The id to set.
	 */
	public FremennikProvinceTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.FREMENNIK_PROVINCE, achievementType, this));
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