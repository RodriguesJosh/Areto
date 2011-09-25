package com.mina.net.update.player;

import com.mina.model.player.PlayerMINA;
import com.netty.net.update.EntityUpdate;

/**
 * An update that will occur after the main
 * updating occurs for the player.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:37:12 PM
 */
public class AfterPlayerUpdate implements Runnable {

	/**
	 * The entity update for counting down the
	 * amount of ticks left until the next update
	 * starts up.
	 */
	private EntityUpdate entityUpdate;

	/**
	 * The player that we are updating.
	 */
	private PlayerMINA playerMINA;

	/**
	 * Constructs a new after task for the player
	 * updating system.
	 * 
	 * @param entityUpdate
	 * 			The entity update to set.
	 * @param playerMINA
	 * 			The player to set.
	 */
	public AfterPlayerUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.getPlayerMINA().getUpdateFlags().resetUpdateFlags();
		this.getPlayerMINA().resetTeleport();
		this.getPlayerMINA().resetMapChanging();
		this.getPlayerMINA().resetAnimation();
		this.getPlayerMINA().resetFaceEntity();
		this.getPlayerMINA().resetFaceLocation();
		this.getPlayerMINA().resetForceChat();
		this.getPlayerMINA().resetForceMovement();
		this.getPlayerMINA().resetGraphic();
		this.getPlayerMINA().resetHit();
		this.getPlayerMINA().resetHitTwo();
		this.getPlayerMINA().resetPacket();
		this.getEntityUpdate().getCountDownLatch().countDown();
	}

	/**
	 * Sets the entity update for counting down
	 * the ticks until the next update occurs.
	 * 
	 * @param entityUpdate
	 * 			The entity update to set.
	 */
	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	/**
	 * Gets the entity update to count down
	 * the ticks.
	 * 
	 * @return entityUpdate
	 * 			Returns the entity update to get.
	 */
	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	/**
	 * Sets the player for the after task of the
	 * player updating system.
	 * 
	 * @param playerMINA
	 * 			The player to set.
	 */
	public void setPlayerMINA(PlayerMINA playerMINA) {
		this.playerMINA = playerMINA;
	}

	/**
	 * Gets the player for the after task of the
	 * player updating system.
	 * 
	 * @return playerMINA
	 * 			Returns the player to get.
	 */
	public PlayerMINA getPlayerMINA() {
		return this.playerMINA;
	}
}