package com.netty.model.player.task.seersvillage;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class SeersVillageTask extends Task {

	private Achievement achievement;

	public SeersVillageTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.SEERS_VILLAGE, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}