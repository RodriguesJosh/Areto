package com.netty.model.player.skill.agility.gnomestronghold.obstacles;

import com.netty.model.player.skill.agility.Failure;
import com.netty.model.player.skill.agility.Obstacle;
import com.netty.model.player.skill.agility.ObstacleLevel;

public class BalancingRope extends Obstacle {

	public BalancingRope() {
		super(Failure.LOW, null, ObstacleLevel.NONE);
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public int getExperience() {
		return 7;
	}

	@Override
	public int getSpeed() {
		return 0;
	}
}