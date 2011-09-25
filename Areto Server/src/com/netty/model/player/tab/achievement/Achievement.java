package com.netty.model.player.tab.achievement;

import com.netty.model.player.task.Task;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:06:09 AM
 */
public class Achievement {

	/**
	 * 
	 */
	private AchievementPlace achievementPlace;

	/**
	 * 
	 */
	private AchievementType achievementType;

	/**
	 * 
	 */
	private Task task;

	/**
	 * 
	 * @param achievementPlace
	 * 			The id to set.
	 * @param achievemenType
	 * 			The id to set.
	 * @param task
	 * 			The id to set.
	 */
	public Achievement(AchievementPlace achievementPlace, AchievementType achievemenType, Task task) {
		this.setAchievementPlace(achievementPlace);
		this.setAchievementType(achievemenType);
		this.setTask(task);
	}

	/**
	 * 
	 * @param achievementPlace
	 * 			The id to set.
	 */
	public void setAchievementPlace(AchievementPlace achievementPlace) {
		this.achievementPlace = achievementPlace;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public AchievementPlace getAchievementPlace() {
		return this.achievementPlace;
	}

	/**
	 * 
	 * @param achievementType
	 * 			The id to set.
	 */
	public void setAchievementType(AchievementType achievementType) {
		this.achievementType = achievementType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public AchievementType getAchievementType() {
		return this.achievementType;
	}

	/**
	 * 
	 * @param task
	 * 			The id to set.
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Task getTask() {
		return this.task;
	}
}