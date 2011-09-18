package com.netty.game.model.update;

import com.netty.world.Location;

public class FaceLocation {

	private Location faceLocation;

	public FaceLocation(Location faceLocation) {
		this.setFaceLocation(faceLocation);
	}

	public void setFaceLocation(Location faceLocation) {
		this.faceLocation = faceLocation;
	}

	public Location getFaceLocation() {
		return this.faceLocation;
	}
}