package com.netty.model.player.task.varrock;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class VarrockTask extends Task {

	private Achievement achievement;

	public VarrockTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.VARROCK, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}