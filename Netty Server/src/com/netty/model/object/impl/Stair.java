package com.netty.model.object.impl;

import com.netty.model.object.Object;
import com.netty.world.Location;

public class Stair extends Object {

	public Stair(int id, byte direction, byte type, Location location) {
		super(id, direction, type);
		this.setLocation(location);
	}
}