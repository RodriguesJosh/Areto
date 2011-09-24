package com.netty.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:39:19 PM
 */
public class Hit {

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
	public Hit(byte damage, HitType hitType) {
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