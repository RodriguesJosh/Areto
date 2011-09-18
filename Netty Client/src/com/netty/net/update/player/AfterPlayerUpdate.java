package com.netty.net.update.player;

import com.netty.game.model.entity.player.Player;
import com.netty.net.update.EntityUpdate;

public class AfterPlayerUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private Player player;

	public AfterPlayerUpdate(EntityUpdate entityUpdate, Player player) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayer(player);
	}

	@Override
	public void run() {
		/** this.getPlayer().getUpdateFlags().resetUpdateFlags();
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
		this.getEntityUpdate().getCountDownLatch().countDown(); */
	}

	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}