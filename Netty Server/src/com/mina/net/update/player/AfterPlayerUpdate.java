package com.mina.net.update.player;

import com.mina.model.player.PlayerMINA;
import com.netty.net.update.EntityUpdate;

public class AfterPlayerUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private PlayerMINA playerMINA;

	public AfterPlayerUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

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

	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	public void setPlayerMINA(PlayerMINA playerMINA) {
		this.playerMINA = playerMINA;
	}

	public PlayerMINA getPlayerMINA() {
		return this.playerMINA;
	}
}