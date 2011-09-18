package com.netty.model.player.task.karamja;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class KaramjaTask extends Task {

	private Achievement achievement;

	public KaramjaTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.KARAMJA, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}