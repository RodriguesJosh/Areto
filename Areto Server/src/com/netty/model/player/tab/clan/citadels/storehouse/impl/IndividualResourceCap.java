package com.netty.model.player.tab.clan.citadels.storehouse.impl;

import com.netty.model.player.tab.clan.citadels.interfaces.map.TierType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:57:10 PM
 */
public class IndividualResourceCap {

	/**
	 * 
	 */
	private TierType tierType;

	/**
	 * 
	 */
	private short resourceCap;

	/**
	 * 
	 * @param tierType
	 * 			The tierType to set.
	 */
	public void setTierType(TierType tierType) {
		this.tierType = tierType;
	}

	/**
	 * 
	 * @return tierType
	 * 			Returns the tierType to get.
	 */
	public TierType getTierType() {
		return this.tierType;
	}

	/**
	 * 
	 * @param resourceCap
	 * 			The resourceCap to set.
	 */
	public void setResourceCap(short resourceCap) {
		this.resourceCap = resourceCap;
	}

	/**
	 * 
	 * @return resourceCap
	 * 			Returns the resourceCap to get.
	 */
	public short getResourceCap() {
		return this.resourceCap;
	}
}