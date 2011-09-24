/**
 * 
 */
package com.netty.model.player.tab.clan.citadels.interfaces.customize;

import java.util.concurrent.ConcurrentMap;

import com.netty.model.combat.CombatType;
import com.netty.model.player.tab.clan.citadels.interfaces.resource.ResourceType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:19:02 PM
 */
public enum CombatStatue {

	/**
	 * 
	 */
	ROUGH_HEWN_RANGED_STATUE,

	/**
	 * 
	 */
	ENGRAVED_RANGED_STATUE,

	/**
	 * 
	 */
	ARTISAN_RANGED_STATUE,

	/**
	 * 
	 */
	ROUGH_HEWN_MAGIC_STATUE,

	/**
	 * 
	 */
	ENGRAVED_MAGIC_STATUE,

	/**
	 * 
	 */
	ARTISAN_MAGIC_STATUE,

	/**
	 * 
	 */
	ROUGH_HEWN_MELEE_STATUE,

	/**
	 * 
	 */
	ENGRAVED_MELEE_STATUE,

	/**
	 * 
	 */
	ARTISAN_MELEE_STATUE;

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