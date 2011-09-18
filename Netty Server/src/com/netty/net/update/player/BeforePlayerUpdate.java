package com.netty.net.update.player;

import java.util.Queue;

import com.netty.model.player.Player;
import com.netty.model.update.Chat;
import com.netty.model.update.UpdateFlag;
import com.netty.net.update.EntityUpdate;

public class BeforePlayerUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private Player player;

	public BeforePlayerUpdate(EntityUpdate entityUpdate, Player player) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayer(player);
	}

	@Override
	public void run() {
		Queue<Chat> queueChat = this.getPlayer().getChatMessageList();
		if (queueChat.size() > 0) {
			this.getPlayer().getUpdateFlags().setUpdateFlag(UpdateFlag.CHAT);
			Chat chat = this.getPlayer().getChatMessageList().poll();
			this.getPlayer().setChat(chat);
		} else {
			this.getPlayer().setChat(null);
		}
		this.getPlayer().getWalking().processNextMovement();
		this.getEntityUpdate().getCountDownLatch().countDown();
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