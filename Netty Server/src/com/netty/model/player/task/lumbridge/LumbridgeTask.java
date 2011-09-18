package com.netty.model.player.task.lumbridge;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class LumbridgeTask extends Task {

	private Achievement achievement;

	public LumbridgeTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.LUMBRIDGE, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}