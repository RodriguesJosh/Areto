package com.netty.model.update;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:37:24 PM
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