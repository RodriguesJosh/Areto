package com.netty.model.player.tab;

import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:01:11 AM
 */
public class Friend {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private boolean isOnline;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param isOnline
	 * 			The id to set.
	 */
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isOnline() {
		return this.isOnline;
	}
}