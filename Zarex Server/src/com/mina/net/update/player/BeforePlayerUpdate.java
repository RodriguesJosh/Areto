package com.mina.net.update.player;

import java.util.Queue;

import com.mina.model.player.PlayerMINA;
import com.netty.model.update.Chat;
import com.netty.model.update.UpdateFlag;
import com.netty.net.update.EntityUpdate;

/**
 * An update task that comes before the main
 * updating of the player.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:36:34 PM
 */
public class BeforePlayerUpdate implements Runnable {

	/**
	 * The entity update for counting down the
	 * amount of ticks left until the next update.
	 */
	private EntityUpdate entityUpdate;

	/**
	 * The player to update.
	 */
	private PlayerMINA playerMINA;

	/**
	 * Constructs a new update before the main update
	 * occurs.
	 * 
	 * @param entityUpdate
	 * 			The entity update for counting down the
	 * 			next update.
	 * @param playerMINA
	 * 			The player to update.
	 */
	public BeforePlayerUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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