package com.netty.model.object.impl;

import com.netty.model.object.Object;
import com.netty.world.Location;

public class Door extends Object {

	private boolean isOpen;

	public Door(int id, Location location, byte direction, byte type, boolean isOpen) {
		super(id, direction, type);
		this.setLocation(location);
		this.setOpen(isOpen);
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isOpen() {
		return this.isOpen;
	}
}