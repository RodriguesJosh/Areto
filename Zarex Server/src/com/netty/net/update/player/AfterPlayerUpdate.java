package com.netty.net.update.player;

import com.netty.model.player.Player;
import com.netty.net.update.EntityUpdate;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:13:01 PM
 */
public class AfterPlayerUpdate implements Runnable {

	/**
	 * 
	 */
	private EntityUpdate entityUpdate;

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param entityUpdate
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public AfterPlayerUpdate(EntityUpdate entityUpdate, Player player) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayer(player);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.getPlayer().getUpdateFlags().resetUpdateFlags();
		this.getPlayer().resetTeleport();
		this.getPlayer().resetMapChanging();
		this.getPlayer().resetAnimation();
		this.getPlayer().resetFaceEntity();
		this.getPlayer().resetFaceLocation();
		this.getPlayer().resetForceChat();
		this.getPlayer().resetForceMovement();
		this.getPlayer().resetGraphic();
		this.getPlayer().resetHit();
		this.getPlayer().resetHitTwo();
		this.getPlayer().resetPacket();
		this.getEntityUpdate().getCountDownLatch().countDown();
	}

	/**
	 * 
	 * @param entityUpdate
	 * 			The id to set.
	 */
	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}
}