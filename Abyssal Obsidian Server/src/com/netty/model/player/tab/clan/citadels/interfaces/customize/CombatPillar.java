package com.netty.model.player.tab.clan.citadels.interfaces.customize;

import java.util.concurrent.ConcurrentMap;

import com.netty.model.combat.CombatType;
import com.netty.model.player.tab.clan.citadels.interfaces.resource.ResourceType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:18:52 PM
 */
public enum CombatPillar {

	/**
	 * 
	 */
	BASIC_RANGED_PILLAR,

	/**
	 * 
	 */
	ELABORATE_RANGED_PILLAR,

	/**
	 * 
	 */
	ORNATE_RANGED_PILLAR,

	/**
	 * 
	 */
	BASIC_MAGIC_PILLAR,

	/**
	 * 
	 */
	ELABORATE_MAGIC_PILLAR,

	/**
	 * 
	 */
	ORNATE_MAGIC_PILLAR,

	/**
	 * 
	 */
	BASIC_MELEE_PILLAR,

	/**
	 * 
	 */
	ELABORATE_MELEE_PILLAR,

	/**
	 * 
	 */
	ORNATE_MELEE_PILLAR;

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