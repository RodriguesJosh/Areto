package com.netty.model.update;

import com.netty.model.Entity;

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