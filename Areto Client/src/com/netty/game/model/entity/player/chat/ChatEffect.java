package com.netty.game.model.entity.player.chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:43:26 PM
 */
public enum ChatEffect {

	/**
	 * 
	 */
	NONE(0),

	/**
	 * 
	 */
	WAVE_ONE(1),

	/**
	 * 
	 */
	WAVE_TWO(2),

	/**
	 * 
	 */
	SHAKE(3),

	/**
	 * 
	 */
	SCROLL(4),

	/**
	 * 
	 */
	SLIDE(5);

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	private ChatEffect(int id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
	}
}