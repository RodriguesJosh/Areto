package com.netty.model.object.impl;

import com.netty.model.item.Item;
import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.update.Animation;
import com.netty.model.update.FaceLocation;
import com.netty.world.Location;

public class Flax extends Object {

	private Player player;

	public Flax(int id, byte direction, byte type) {
		super(id, direction, type);
		if (id == 2646) {
			this.getPlayer().setFaceLocation(new FaceLocation(new Location(this.getLocation().getX(), this.getLocation().getY(), this.getLocation().getZ())));
			this.setAnimation(new Animation(827, 0));
			this.getPlayer().getInventory().registerItem(new Item(1179, 1));
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}