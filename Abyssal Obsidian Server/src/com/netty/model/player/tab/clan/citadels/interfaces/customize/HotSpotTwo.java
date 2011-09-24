package com.netty.model.player.tab.clan.citadels.interfaces.customize;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:18:19 PM
 */
public class HotSpotTwo {

	/**
	 * 
	 */
	private CombatPillar combatPillar;

	/**
	 * 
	 */
	private CombatStatue combatStatue;

	/**
	 * 
	 */
	private WeaponRack weaponRack;

	/**
	 * 
	 * @param combatPillar
	 * 			The combatPillar to set.
	 */
	public void setCombatPillar(CombatPillar combatPillar) {
		this.combatPillar = combatPillar;
	}

	/**
	 * 
	 * @return combatPillar
	 * 			Returns the combatPillar to get.
	 */
	public CombatPillar getCombatPillar() {
		return this.combatPillar;
	}

	/**
	 * 
	 * @param combatStatue
	 * 			The combatStatue to set.
	 */
	public void setCombatStatue(CombatStatue combatStatue) {
		this.combatStatue = combatStatue;
	}

	/**
	 * 
	 * @return combatStatue
	 * 			Returns the combatStatue to get.
	 */
	public CombatStatue getCombatStatue() {
		return this.combatStatue;
	}

	/**
	 * 
	 * @param weaponRack
	 * 			The weaponRack to set.
	 */
	public void setWeaponRack(WeaponRack weaponRack) {
		this.weaponRack = weaponRack;
	}

	/**
	 * 
	 * @return weaponRack
	 * 			Returns the weaponRack to get.
	 */
	public WeaponRack getWeaponRack() {
		return this.weaponRack;
	}
}