package com.netty.model.player.wilderness;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:45:25 PM
 */
public class Skull {

	/**
	 * 
	 */
	private SkullType skullType;

	/**
	 * 
	 * @param skullType
	 * 			The id to set.
	 */
	public Skull(SkullType skullType) {
		this.setSkullType(skullType);
	}

	/**
	 * 
	 * @param skullType
	 * 			The id to set.
	 */
	public void setSkullType(SkullType skullType) {
		this.skullType = skullType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SkullType getSkullType() {
		return this.skullType;
	}
}