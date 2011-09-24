package com.netty.model.player.tab.clan.citadels.interfaces.customize;

import java.util.concurrent.ConcurrentMap;

import com.netty.model.combat.CombatType;
import com.netty.model.player.tab.clan.citadels.interfaces.resource.ResourceType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:19:12 PM
 */
public enum WeaponRack {

	/**
	 * 
	 */
	MILITIAS_ARSENAL,

	/**
	 * 
	 */
	GLADIATORS_ARSENAL,

	/**
	 * 
	 */
	QUARTERMASTERS_ARSENAL,

	/**
	 * 
	 */
	IMPERIAL_ARSENAL,

	/**
	 * 
	 */
	GRANDMASTERS_ARSENAL,

	/**
	 * 
	 */
	DYNASTIC_ARSENAL,

	/**
	 * 
	 */
	PHALANX_ARSENAL;

	/**
	 * 
	 */
	private CombatType combatType;

	/**
	 * 
	 */
	private ConcurrentMap<ResourceType[], Integer> resourceMap;

	/**
	 * 
	 * @param combatType
	 * 			The combatType to set.
	 */
	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	/**
	 * 
	 * @return combatType
	 * 			Returns the combatType to get.
	 */
	public CombatType getCombatType() {
		return this.combatType;
	}

	/**
	 * 
	 * @param resourceMap
	 * 			The resourceMap to set.
	 */
	public void setResourceMap(ConcurrentMap<ResourceType[], Integer> resourceMap) {
		this.resourceMap = resourceMap;
	}

	/**
	 * 
	 * @return resourceMap
	 * 			Returns the resourceMap to get.
	 */
	public ConcurrentMap<ResourceType[], Integer> getResourceMap() {
		return this.resourceMap;
	}
}