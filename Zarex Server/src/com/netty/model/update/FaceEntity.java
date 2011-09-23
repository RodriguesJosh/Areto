package com.netty.model.update;

import com.netty.model.Entity;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:37:08 PM
 */
public class FaceEntity {

	/**
	 * 
	 */
	private Entity faceEntity;

	/**
	 * 
	 * @param faceEntity
	 * 			The id to set.
	 */
	public FaceEntity(Entity faceEntity) {
		this.setFaceEntity(faceEntity);
	}

	/**
	 * 
	 * @param faceEntity
	 * 			The id to set.
	 */
	public void setFaceEntity(Entity faceEntity) {
		this.faceEntity = faceEntity;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Entity getFaceEntity() {
		return this.faceEntity;
	}
}