package com.netty.game.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:02:04 PM
 */
public class HitTwo {

	/**
	 * 
	 */
	private byte damage;

	/**
	 * 
	 */
	private HitType hitType;

	/**
	 * 
	 * @param damage
	 * 			The id to set.
	 * @param hitType
	 * 			The id to set.
	 */
	public HitTwo(byte damage, HitType hitType) {
		this.setDamage(damage);
		this.setHitType(hitType);
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
	 * @param hitType
	 * 			The id to set.
	 */
	public void setHitType(HitType hitType) {
		this.hitType = hitType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public HitType getHitType() {
		return this.hitType;
	}
}