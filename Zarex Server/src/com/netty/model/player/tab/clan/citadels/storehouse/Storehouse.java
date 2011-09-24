package com.netty.model.player.tab.clan.citadels.storehouse;

import com.netty.model.player.tab.clan.citadels.storehouse.impl.IndividualResourceCap;
import com.netty.model.player.tab.clan.citadels.storehouse.impl.ResourceSpoiling;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:42:05 PM
 */
public class Storehouse {

	/**
	 * 
	 */
	private IndividualResourceCap individualResourceCap;

	/**
	 * 
	 */
	private ResourceSpoiling resourceSpoiling;

	/**
	 * 
	 * @param individualResourceCap
	 * 			The individualResourceCap to set.
	 */
	public void setIndividualResourceCap(IndividualResourceCap individualResourceCap) {
		this.individualResourceCap = individualResourceCap;
	}

	/**
	 * 
	 * @return individualResourceCap
	 * 			Returns the individualResourceCap to get.
	 */
	public IndividualResourceCap getIndividualResourceCap() {
		return this.individualResourceCap;
	}

	/**
	 * 
	 * @param resourceSpoiling
	 * 			The resourceSpoiling to set.
	 */
	public void setResourceSpoiling(ResourceSpoiling resourceSpoiling) {
		this.resourceSpoiling = resourceSpoiling;
	}

	/**
	 * 
	 * @return resourceSpoiling
	 * 			Returns the resourceSpoiling to get.
	 */
	public ResourceSpoiling getResourceSpoiling() {
		return this.resourceSpoiling;
	}
}