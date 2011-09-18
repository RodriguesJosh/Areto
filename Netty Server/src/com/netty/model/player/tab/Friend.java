package com.netty.model.player.tab;

import com.netty.world.World;

public class Friend {

	private String name;
	private boolean isOnline;

	public Friend(String name) {
		if (World.getWorld().getIgnoresList().contains(World.getWorld().getIgnoresName(name))) {
			return;
		}
		if ((name == null) || name.equals("")) {
			return;
		}
		if (World.getWorld().getFriendsList().add(this)) {
			this.setName(name);
			this.setOnline(true);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public boolean isOnline() {
		return this.isOnline;
	}
}