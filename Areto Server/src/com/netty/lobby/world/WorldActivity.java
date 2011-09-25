package com.netty.lobby.world;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:43:37 PM
 */
public enum WorldActivity {

	/**
	 * 
	 */
	TRADE,

	/**
	 * 
	 */
	BARBARIAN_ASSAULT,

	/**
	 * 
	 */
	DUNGEONEERING,

	/**
	 * 
	 */
	CASTLE_WARS;

	/**
	 * 
	 */
	private WorldType worldType;

	/**
	 * 
	 * 
	 * @param worldType
	 * 			The type of world to set.
	 */
	public void setWorldType(WorldType worldType) {
		this.worldType = worldType;
	}

	/**
	 * 
	 * 
	 * @return worldType
	 */
	public WorldType getWorldType() {
		return this.worldType;
	}
}