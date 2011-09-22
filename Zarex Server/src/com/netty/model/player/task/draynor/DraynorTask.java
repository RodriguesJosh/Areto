package com.netty.model.player.task.draynor;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class DraynorTask extends Task {

	private Achievement achievement;

	public DraynorTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.DRAYNOR, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}