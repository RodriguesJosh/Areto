package com.netty.model.player.skill.agility.gnomestronghold.obstacles;

import com.netty.model.player.skill.agility.Failure;
import com.netty.model.player.skill.agility.Obstacle;
import com.netty.model.player.skill.agility.ObstacleLevel;

public class BranchClimb extends Obstacle {

	public BranchClimb() {
		super(Failure.LOW, null, ObstacleLevel.NONE);
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public int getExperience() {
		return 5;
	}

	@Override
	public int getSpeed() {
		return 0;
	}
}