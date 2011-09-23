package com.netty.model.player.skill.agility.gnomestronghold.obstacles;

import com.netty.model.player.skill.agility.Failure;
import com.netty.model.player.skill.agility.Obstacle;
import com.netty.model.player.skill.agility.ObstacleLevel;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:09:12 PM
 */
public class NetClimb extends Obstacle {

	/**
	 * 
	 */
	public NetClimb() {
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
		return 7;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.skill.agility.Obstacle#getSpeed()
	 */
	@Override
	public int getSpeed() {
		return 0;
	}
}
