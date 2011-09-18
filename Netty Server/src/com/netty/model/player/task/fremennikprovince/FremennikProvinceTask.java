package com.netty.model.player.task.fremennikprovince;

import com.netty.model.player.tab.achievement.Achievement;
import com.netty.model.player.tab.achievement.AchievementPlace;
import com.netty.model.player.tab.achievement.AchievementType;
import com.netty.model.player.task.Task;

public class FremennikProvinceTask extends Task {

	private Achievement achievement;

	public FremennikProvinceTask(AchievementType achievementType) {
		this.setAchievement(new Achievement(AchievementPlace.FREMENNIK_PROVINCE, achievementType, this));
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}
}