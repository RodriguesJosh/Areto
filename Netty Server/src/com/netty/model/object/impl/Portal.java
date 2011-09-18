package com.netty.model.object.impl;

import com.netty.model.object.Object;
import com.netty.world.Location;

public class Portal extends Object {

	public Portal(int id, byte direction, byte type, Location location) {
		super(id, direction, type);
		this.setLocation(location);
	}
}