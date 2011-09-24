package com.netty.lobby.world;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:34:31 PM
 */
public class GameWorld {

	/**
	 * 
	 */
	private byte id;

	/**
	 * 
	 */
	private int playerListSize;

	/**
	 * 
	 */
	private WorldType worldType;

	/**
	 * 
	 */
	private WorldActivity worldActivity;

	/**
	 * 
	 */
	private WorldLocation worldLocation;

	/**
	 * 
	 * 
	 * @param id
	 * 			The id to set.
	 * @param playerListSize
	 * 			The size of the player list to set.
	 * @param worldType
	 * 			The type of world to set.
	 * @param worldActivity
	 * 			The activity throughout the world to set.
	 * @param worldLocation
	 * 			The location of the world to set.
	 */
	public GameWorld(byte id, int playerListSize, WorldType worldType, WorldActivity worldActivity, WorldLocation worldLocation) {
		this.setID(id);
		this.setPlayerListSize(playerListSize);
		this.setWorldType(worldType);
		this.setWorldActivity(worldActivity);
		this.setWorldLocation(worldLocation);
	}

	/**
	 * 
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(byte id) {
		this.id = id;
	}

	/**
	 * 
	 * @return id
	 */
	public byte getID() {
		return this.id;
	}

	/**
	 * 
	 * @param playerListSize
	 * 			The player list size to set.
	 */
	public void setPlayerListSize(int playerListSize) {
		this.playerListSize = playerListSize;
	}

	/**
	 * 
	 * @return playerListSize
	 */
	public int getPlayerListSize() {
		return this.playerListSize;
	}

	/**
	 * 
	 * @param worldType
	 * 			The type of world to set.
	 */
	public void setWorldType(WorldType worldType) {
		this.worldType = worldType;
	}

	/**
	 * 
	 * @return worldType
	 */
	public WorldType getWorldType() {
		return this.worldType;
	}

	/**
	 * 
	 * @param worldActivity
	 * 			The world activity to set.
	 */
	public void setWorldActivity(WorldActivity worldActivity) {
		this.worldActivity = worldActivity;
	}

	/**
	 * 
	 * @return worldActivity
	 */
	public WorldActivity getWorldAcitivity() {
		return this.worldActivity;
	}

	/**
	 * 
	 * @param worldLocation
	 * 			The world location to set.
	 */
	public void setWorldLocation(WorldLocation worldLocation) {
		this.worldLocation = worldLocation;
	}

	/**
	 * 
	 * @return worldLocation
	 */
	public WorldLocation getWorldLocation() {
		return this.worldLocation;
	}
}