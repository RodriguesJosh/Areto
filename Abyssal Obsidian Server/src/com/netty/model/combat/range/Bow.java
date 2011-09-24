package com.netty.model.combat.range;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:42:25 AM
 */
public class Bow {

	/**
	 * 
	 */
	private BowType bowType;

	/**
	 * 
	 * @param bowType
	 * 			The id to set.
	 */
	public void setBowType(BowType bowType) {
		this.bowType = bowType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BowType getBowType() {
		return this.bowType;
	}
}