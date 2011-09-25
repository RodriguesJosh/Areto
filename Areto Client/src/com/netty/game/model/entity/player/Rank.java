package com.netty.game.model.entity.player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:41:21 PM
 */
public enum Rank {

	/**
	 * 
	 */
	PLAYER((byte) 0),

	/**
	 * 
	 */
	MODERATOR((byte) 1),

	/**
	 * 
	 */
	ADMINISTRATOR((byte) 2),

	/**
	 * 
	 */
	OWNER((byte) 3);

	/**
	 * 
	 */
	private byte id;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	private Rank(byte id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(byte id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getID() {
		return this.id;
	}
}