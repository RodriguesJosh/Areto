package com.netty.model.player.tab.clan.citadels.storehouse.impl;

import com.netty.model.player.tab.clan.citadels.interfaces.map.TierType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:57:29 PM
 */
public class ResourceSpoiling {

	/**
	 * 
	 */
	private TierType tierType;

	/**
	 * 
	 */
	private byte percentageCarried;

	/**
	 * 
	 */
	private short maximumResource;

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
	 * @param percentageCarried
	 * 			The percentageCarried to set.
	 */
	public void setPercentageCarried(byte percentageCarried) {
		this.percentageCarried = percentageCarried;
	}

	/**
	 * 
	 * @return percentageCarried
	 * 			Returns the percentageCarried to get.
	 */
	public byte getPercentageCarried() {
		return this.percentageCarried;
	}

	/**
	 * 
	 * @param maximumResource
	 * 			The maximumResource to set.
	 */
	public void setMaximumResource(short maximumResource) {
		this.maximumResource = maximumResource;
	}

	/**
	 * 
	 * @return maximumResource
	 * 			Returns the maximumResource to get.
	 */
	public short getMaximumResource() {
		return this.maximumResource;
	}
}