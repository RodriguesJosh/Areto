package com.netty.model.player.skill.agility;

import java.util.HashMap;
import java.util.Map;

public class Agility {

	private Map<Course, Obstacle> courseObstacleMap;

	public Agility() {
		this.setCourseObstacleMap(new HashMap<Course, Obstacle>());
	}

	public void setCourseObstacleMap(Map<Course, Obstacle> courseObstacleMap) {
		this.courseObstacleMap = courseObstacleMap;
	}

	public Map<Course, Obstacle> getCourseObstacleMap() {
		return this.courseObstacleMap;
	}
}