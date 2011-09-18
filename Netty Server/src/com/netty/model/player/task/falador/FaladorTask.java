package com.netty.model.player.task.falador;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class FaladorTask extends Task {

	private Achievement achievement;

	public FaladorTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.FALADOR, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}