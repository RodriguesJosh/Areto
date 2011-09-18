package com.netty.lobby.world;

public class GameWorld {

	private byte id;
	private int playerListSize;
	private WorldType worldType;
	private WorldActivity worldActivity;
	private WorldLocation worldLocation;

	public GameWorld(byte id, int playerListSize, WorldType worldType, WorldActivity worldActivity, WorldLocation worldLocation) {
		this.setID(id);
		this.setPlayerListSize(playerListSize);
		this.setWorldType(worldType);
		this.setWorldActivity(worldActivity);
		this.setWorldLocation(worldLocation);
	}

	public void setID(byte id) {
		this.id = id;
	}

	public byte getID() {
		return this.id;
	}

	public void setPlayerListSize(int playerListSize) {
		this.playerListSize = playerListSize;
	}

	public int getPlayerListSize() {
		return this.playerListSize;
	}

	public void setWorldType(WorldType worldType) {
		this.worldType = worldType;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public void setWorldActivity(WorldActivity worldActivity) {
		this.worldActivity = worldActivity;
	}

	public WorldActivity getWorldAcitivity() {
		return this.worldActivity;
	}

	public void setWorldLocation(WorldLocation worldLocation) {
		this.worldLocation = worldLocation;
	}

	public WorldLocation getWorldLocation() {
		return this.worldLocation;
	}
}