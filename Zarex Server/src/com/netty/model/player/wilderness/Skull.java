package com.netty.model.player.wilderness;

public class Skull {

	private SkullType skullType;

	public Skull(SkullType skullType) {
		this.setSkullType(skullType);
	}

	public void setSkullType(SkullType skullType) {
		this.skullType = skullType;
	}

	public SkullType getSkullType() {
		return this.skullType;
	}
}