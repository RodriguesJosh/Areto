package com.netty.game.model.update;

import com.netty.game.model.entity.Entity;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:04:33 PM
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