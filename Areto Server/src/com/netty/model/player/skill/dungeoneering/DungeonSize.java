package com.netty.model.player.skill.dungeoneering;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:04:15 AM
 */
public enum DungeonSize {

	/**
	 * 
	 */
	SMALL((byte) 16),

	/**
	 * 
	 */
	MEDIUM((byte) 32),

	/**
	 * 
	 */
	LARGE((byte) 64);

	/**
	 * 
	 */
	private byte size;

	/**
	 * 
	 * @param size
	 * 			The id to set.
	 */
	private DungeonSize(byte size) {
		this.setSize(size);
	}

	/**
	 * 
	 * @param size
	 * 			The id to set.
	 */
	public void setSize(byte size) {
		this.size = size;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getSize() {
		return this.size;
	}
}