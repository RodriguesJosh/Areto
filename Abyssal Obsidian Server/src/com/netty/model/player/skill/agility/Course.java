package com.netty.model.player.skill.agility;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:00:16 PM
 */
public abstract class Course {

	/**
	 * 
	 */
	private Obstacle[] obstacles;

	/**
	 * 
	 * @param obstacles
	 * 			The id to set.
	 */
	public Course(Obstacle[] obstacles) {
		this.setObstacles(obstacles);
	}

	/**
	 * 
	 * @param obstacles
	 * 			The id to set.
	 */
	public void setObstacles(Obstacle[] obstacles) {
		this.obstacles = obstacles;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Obstacle[] getObstacles() {
		return this.obstacles;
	}
}