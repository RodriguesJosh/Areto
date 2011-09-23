package com.netty.model;

import com.netty.model.player.Player;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:50:06 PM
 */
public class Follow {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private Entity entity;

	/**
	 * 
	 * 
	 * @param player
	 * 			The player to set.
	 * @param entity
	 * 			The entity to set.
	 */
	public Follow(Player player, Entity entity) {
		this.setPlayer(player);
		this.setEntity(entity);
	}

	/**
	 * 
	 * 
	 * @param player
	 * 			The player to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * 
	 * @param entity
	 * 			The player to set.
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	/**
	 * 
	 * 
	 * @return entity
	 */
	public Entity getEntity() {
		return this.entity;
	}
}