package com.netty.model.combat;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:33:15 AM
 */
public class Poison {

	/**
	 * 
	 */
	private byte damage;
	/**
	 * 
	 */
	private byte time;

	/**
	 * 
	 * @param damage
	 * 			The id to set.
	 * @param time
	 * 			The id to set.
	 */
	public Poison(byte damage, byte time) {
		this.setDamage(damage);
		this.setTime(time);
	}

	/**
	 * 
	 * @param damage
	 * 			The id to set.
	 */
	public void setDamage(byte damage) {
		this.damage = damage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getDamage() {
		return this.damage;
	}

	/**
	 * 
	 * @param time
	 * 			The id to set.
	 */
	public void setTime(byte time) {
		this.time = time;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getTime() {
		return this.time;
	}
}