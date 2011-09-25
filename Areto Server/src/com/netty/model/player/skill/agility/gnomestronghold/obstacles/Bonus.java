package com.netty.model.player.skill.agility.gnomestronghold.obstacles;

import com.netty.model.player.skill.agility.Failure;
import com.netty.model.player.skill.agility.Obstacle;
import com.netty.model.player.skill.agility.ObstacleLevel;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:09:37 PM
 */
public class Bonus extends Obstacle {

	/**
	 * 
	 */
	public Bonus() {
		super(Failure.LOW, null, ObstacleLevel.NONE);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.skill.agility.Obstacle#getDamage()
	 */
	@Override
	public int getDamage() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.skill.agility.Obstacle#getExperience()
	 */
	@Override
	public int getExperience() {
		return 39;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.skill.agility.Obstacle#getSpeed()
	 */
	@Override
	public int getSpeed() {
		return 0;
	}
}