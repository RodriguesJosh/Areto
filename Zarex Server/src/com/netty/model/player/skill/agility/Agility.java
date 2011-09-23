package com.netty.model.player.skill.agility;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:00:30 PM
 */
public class Agility {

	/**
	 * 
	 */
	private Map<Course, Obstacle> courseObstacleMap;

	/**
	 * 
	 */
	public Agility() {
		this.setCourseObstacleMap(new HashMap<Course, Obstacle>());
	}

	/**
	 * 
	 * @param courseObstacleMap
	 * 			The id to set.
	 */
	public void setCourseObstacleMap(Map<Course, Obstacle> courseObstacleMap) {
		this.courseObstacleMap = courseObstacleMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Map<Course, Obstacle> getCourseObstacleMap() {
		return this.courseObstacleMap;
	}
}