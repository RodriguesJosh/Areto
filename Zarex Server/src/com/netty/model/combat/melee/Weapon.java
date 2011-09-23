package com.netty.model.combat.melee;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:41:22 AM
 */
public class Weapon {

	/**
	 * 
	 */
	private WeaponType weaponType;

	/**
	 * 
	 * @param weaponType
	 * 			The id to set.
	 */
	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public WeaponType getWeaponType() {
		return this.weaponType;
	}
}