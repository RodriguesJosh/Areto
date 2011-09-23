package com.netty.model.player.skill.agility;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:59:37 PM
 */
public abstract class Obstacle {

	/**
	 * 
	 */
	private Failure failure;

	/**
	 * 
	 */
	private RecoverySpeed recoverySpeed;

	/**
	 * 
	 */
	private ObstacleLevel obstacleLevel;

	/**
	 * 
	 * @param failure
	 * 			The id to set.
	 * @param recoverySpeed
	 * 			The id to set.
	 * @param obstacleLevel
	 * 			The id to set.
	 */
	public Obstacle(Failure failure, RecoverySpeed recoverySpeed, ObstacleLevel obstacleLevel) {
		this.setFailure(failure);
		this.setRecoverySpeed(recoverySpeed);
		this.setObstacleLevel(obstacleLevel);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract int getDamage();
	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract int getExperience();
	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract int getSpeed();

	/**
	 * 
	 * @param failure
	 * 			The id to set.
	 */
	public void setFailure(Failure failure) {
		this.failure = failure;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Failure getFailure() {
		return this.failure;
	}

	/**
	 * 
	 * @param recoverySpeed
	 * 			The id to set.
	 */
	public void setRecoverySpeed(RecoverySpeed recoverySpeed) {
		this.recoverySpeed = recoverySpeed;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RecoverySpeed getRecoverySpeed() {
		return this.recoverySpeed;
	}

	/**
	 * 
	 * @param obstacleLevel
	 * 			The id to set.
	 */
	public void setObstacleLevel(ObstacleLevel obstacleLevel) {
		this.obstacleLevel = obstacleLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ObstacleLevel getObstacleLevel() {
		return this.obstacleLevel;
	}
}