package com.netty.net.update.player;

import java.util.Queue;

import com.netty.model.player.Player;
import com.netty.model.update.Chat;
import com.netty.model.update.UpdateFlag;
import com.netty.net.update.EntityUpdate;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:12:52 PM
 */
public class BeforePlayerUpdate implements Runnable {

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
	public BeforePlayerUpdate(EntityUpdate entityUpdate, Player player) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayer(player);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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