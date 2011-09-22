package com.netty.lobby.world;

public enum WorldActivity {

	TRADE, BARBARIAN_ASSAULT, DUNGEONEERING, CASTLE_WARS;

	private WorldType worldType;

	public void setWorldType(WorldType worldType) {
		this.worldType = worldType;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}
}