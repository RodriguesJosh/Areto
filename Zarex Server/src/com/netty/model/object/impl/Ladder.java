package com.netty.model.object.impl;

import com.netty.model.object.Object;
import com.netty.world.Location;

public class Ladder extends Object {

	public Ladder(int id, byte direction, byte type, Location location) {
		super(id, direction, type);
		this.setLocation(location);
	}
}