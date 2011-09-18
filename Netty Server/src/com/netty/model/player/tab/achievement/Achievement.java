package com.netty.model.player.tab.achievement;

import com.netty.model.player.task.Task;

public class Achievement {

	private AchievementPlace achievementPlace;
	private AchievementType achievementType;
	private Task task;

	public Achievement(AchievementPlace achievementPlace, AchievementType achievemenType, Task task) {
		this.setAchievementPlace(achievementPlace);
		this.setAchievementType(achievemenType);
		this.setTask(task);
	}

	public void setAchievementPlace(AchievementPlace achievementPlace) {
		this.achievementPlace = achievementPlace;
	}

	public AchievementPlace getAchievementPlace() {
		return this.achievementPlace;
	}

	public void setAchievementType(AchievementType achievementType) {
		this.achievementType = achievementType;
	}

	public AchievementType getAchievementType() {
		return this.achievementType;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Task getTask() {
		return this.task;
	}
}