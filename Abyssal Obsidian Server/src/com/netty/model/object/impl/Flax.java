package com.netty.model.object.impl;

import com.netty.model.item.Item;
import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.update.Animation;
import com.netty.model.update.FaceLocation;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:07:21 AM
 */
public class Flax extends Object {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param direction
	 * 			The id to set.
	 * @param type
	 * 			The id to set.
	 */
	public Flax(int id, byte direction, byte type) {
		super(id, direction, type);
		if (id == 2646) {
			this.getPlayer().setFaceLocation(new FaceLocation(new Location(this.getLocation().getX(), this.getLocation().getY(), this.getLocation().getZ())));
			this.setAnimation(new Animation(827, 0));
			this.getPlayer().getInventory().registerItem(new Item(1179, 1));
		}
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