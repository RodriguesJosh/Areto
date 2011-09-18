package com.netty.model.player.tab;

import com.netty.world.World;

public class Ignore {

	private String name;

	public Ignore(String name) {
		if (World.getWorld().getFriendsList().contains(World.getWorld().getFriendsName(name))) {
			return;
		}
		if (name.equals("") || (name == null)) {
			return;
		}
		if (World.getWorld().getIgnoresList().add(this)) {
			this.setName(name);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}