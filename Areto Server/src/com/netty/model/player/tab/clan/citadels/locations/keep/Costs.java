package com.netty.model.player.tab.clan.citadels.locations.keep;

import java.util.concurrent.ConcurrentMap;

import com.netty.model.player.tab.clan.citadels.interfaces.map.TierType;
import com.netty.model.player.tab.clan.citadels.interfaces.resource.ResourceType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:25:02 AM
 */
public class Costs {

	/**
	 * 
	 */
	private ConcurrentMap<TierType, ConcurrentMap<Short, ResourceType>> costMap;

	/**
	 * 
	 * @param costMap
	 * 			The costMap to set.
	 */
	public void setCostMap(ConcurrentMap<TierType, ConcurrentMap<Short, ResourceType>> costMap) {
		this.costMap = costMap;
	}

	/**
	 * 
	 * @return costMap
	 * 			Returns the costMap to get.
	 */
	public ConcurrentMap<TierType, ConcurrentMap<Short, ResourceType>> getCostMap() {
		return this.costMap;
	}
}