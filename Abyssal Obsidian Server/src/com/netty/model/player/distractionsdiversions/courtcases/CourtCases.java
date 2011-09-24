package com.netty.model.player.distractionsdiversions.courtcases;

import com.netty.model.item.Item;
import com.netty.model.player.distractionsdiversions.DistractionsAndDiversions;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 3:06:39 PM
 */
public class CourtCases extends DistractionsAndDiversions {

	/**
	 * 
	 */
	private Item courtSummons;

	/* (non-Javadoc)
	 * @see com.netty.model.player.distractionsdiversions.DistractionsAndDiversions#end()
	 */
	@Override
	public void end() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.distractionsdiversions.DistractionsAndDiversions#start()
	 */
	@Override
	public void start() {
		//
	}

	/**
	 * 
	 * @param courtSummons
	 * 			The courtSummons to set.
	 */
	public void setCourtSummons(Item courtSummons) {
		this.courtSummons = courtSummons;
	}

	/**
	 * 
	 * @return courtSummons
	 * 			Returns the courtSummons to get.
	 */
	public Item getCourtSummons() {
		return this.courtSummons;
	}
}