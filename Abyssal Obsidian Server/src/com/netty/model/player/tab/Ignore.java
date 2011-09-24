package com.netty.model.player.tab;

import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:01:33 AM
 */
public class Ignore {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public Ignore(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		if (name.equals("")) {
			throw new IllegalArgumentException();
		}
		if (World.getWorld().getFriendsList().contains(World.getWorld().getFriendsName(name))) {
			return;
		}
		if (World.getWorld().getIgnoresList().add(this)) {
			this.setName(name);
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
}