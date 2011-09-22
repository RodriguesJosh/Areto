package com.netty.model.player.skill.agility;

public abstract class Course {

	private Obstacle[] obstacles;

	public Course(Obstacle[] obstacles) {
		this.setObstacles(obstacles);
	}

	public void setObstacles(Obstacle[] obstacles) {
		this.obstacles = obstacles;
	}

	public Obstacle[] getObstacles() {
		return this.obstacles;
	}
}