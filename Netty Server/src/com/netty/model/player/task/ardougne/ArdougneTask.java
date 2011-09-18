package com.netty.model.player.task.ardougne;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class ArdougneTask extends Task {

	private Achievement achievement;

	public ArdougneTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.ARDOUGNE, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}