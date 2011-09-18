package com.mina.net.update.player;

import java.util.Queue;

import com.mina.model.player.PlayerMINA;
import com.netty.model.update.Chat;
import com.netty.model.update.UpdateFlag;
import com.netty.net.update.EntityUpdate;

public class BeforePlayerUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private PlayerMINA playerMINA;

	public BeforePlayerUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

	@Override
	public void run() {
		Queue<Chat> queueChat = this.getPlayerMINA().getChatMessageList();
		if (queueChat.size() > 0) {
			this.getPlayerMINA().getUpdateFlags().setUpdateFlag(UpdateFlag.CHAT);
			Chat chat = this.getPlayerMINA().getChatMessageList().poll();
			this.getPlayerMINA().setChat(chat);
		} else {
			this.getPlayerMINA().setChat(null);
		}
		this.getPlayerMINA().getWalking().processNextMovement();
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