package com.netty.game.model.update;

import com.netty.game.model.entity.Entity;

public class FaceEntity {

	private Entity faceEntity;

	public FaceEntity(Entity faceEntity) {
		this.setFaceEntity(faceEntity);
	}

	public void setFaceEntity(Entity faceEntity) {
		this.faceEntity = faceEntity;
	}

	public Entity getFaceEntity() {
		return this.faceEntity;
	}
}