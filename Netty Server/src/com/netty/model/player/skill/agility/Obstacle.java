package com.netty.model.player.skill.agility;

public abstract class Obstacle {

	private Failure failure;
	private RecoverySpeed recoverySpeed;
	private ObstacleLevel obstacleLevel;

	public Obstacle(Failure failure, RecoverySpeed recoverySpeed, ObstacleLevel obstacleLevel) {
		this.setFailure(failure);
		this.setRecoverySpeed(recoverySpeed);
		this.setObstacleLevel(obstacleLevel);
	}

	public abstract int getDamage();
	public abstract int getExperience();
	public abstract int getSpeed();

	public void setFailure(Failure failure) {
		this.failure = failure;
	}

	public Failure getFailure() {
		return this.failure;
	}

	public void setRecoverySpeed(RecoverySpeed recoverySpeed) {
		this.recoverySpeed = recoverySpeed;
	}

	public RecoverySpeed getRecoverySpeed() {
		return this.recoverySpeed;
	}

	public void setObstacleLevel(ObstacleLevel obstacleLevel) {
		this.obstacleLevel = obstacleLevel;
	}

	public ObstacleLevel getObstacleLevel() {
		return this.obstacleLevel;
	}
}