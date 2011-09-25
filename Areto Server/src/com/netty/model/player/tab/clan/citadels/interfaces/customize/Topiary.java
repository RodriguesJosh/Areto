package com.netty.model.player.tab.clan.citadels.interfaces.customize;

import java.util.concurrent.ConcurrentMap;

import com.netty.model.combat.CombatType;
import com.netty.model.player.tab.clan.citadels.interfaces.resource.ResourceType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:19:27 PM
 */
public enum Topiary {

	/**
	 * 
	 */
	ROUGH_HEWN_BASE,

	/**
	 * 
	 */
	ARTISAN_BASE,

	/**
	 * 
	 */
	EMBELLISHED_BASE,

	/**
	 * 
	 */
	ADORNED_BASE,

	/**
	 * 
	 */
	GRAND_BASE,

	/**
	 * 
	 */
	TOWER_HEDGE,

	/**
	 * 
	 */
	BEAR_HEDGE,

	/**
	 * 
	 */
	DRAGON_HEDGE,

	/**
	 * 
	 */
	PHOENIX_HEDGE,

	/**
	 * 
	 */
	CASTLE_HEDGE,

	/**
	 * 
	 */
	UNICORN_HEDGE,

	/**
	 * 
	 */
	FLORAL_BEAR_HEDGE,

	/**
	 * 
	 */
	FLORAL_DRAGON_HEDGE,

	/**
	 * 
	 */
	FLORAL_PHOENIX_HEDGE,

	/**
	 * 
	 */
	FLORAL_CASTLE_HEDGE,

	/**
	 * 
	 */
	FLORAL_UNICORN_HEDGE;

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