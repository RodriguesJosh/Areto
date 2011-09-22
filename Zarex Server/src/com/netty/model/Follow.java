package com.netty.model;

import com.netty.model.player.Player;

public class Follow {

	private Player player;
	private Entity entity;

	public Follow(Player player, Entity entity) {
		this.setPlayer(player);
		this.setEntity(entity);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return this.entity;
	}
}