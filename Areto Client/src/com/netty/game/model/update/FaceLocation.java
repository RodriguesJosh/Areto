package com.netty.game.model.update;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:04:41 PM
 */
public class FaceLocation {

	/**
	 * 
	 */
	private Location faceLocation;

	/**
	 * 
	 * @param faceLocation
	 * 			The id to set.
	 */
	public FaceLocation(Location faceLocation) {
		this.setFaceLocation(faceLocation);
	}

	/**
	 * 
	 * @param faceLocation
	 * 			The id to set.
	 */
	public void setFaceLocation(Location faceLocation) {
		this.faceLocation = faceLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getFaceLocation() {
		return this.faceLocation;
	}
}