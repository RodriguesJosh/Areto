package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza;

import com.netty.model.player.distractionsdiversions.DistractionsAndDiversions;
import com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.agility.AgilityPerformance;
import com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.magic.MagicPerformance;
import com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.range.RangePerformance;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:36:05 PM
 */
public class BalthazarBeauregardsBigTopBonanza extends DistractionsAndDiversions {

	/**
	 * 
	 */
	private BalthazarBeauregard balthazarBeauregard;

	/**
	 * 
	 */
	private CircusBarker circusBarker;

	/**
	 * 
	 */
	private TicketVendor ticketVendor;

	/**
	 * 
	 */
	private AgilityPerformance agilityPerformance;

	/**
	 * 
	 */
	private MagicPerformance magicPerformance;

	/**
	 * 
	 */
	private RangePerformance rangePerformance;

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
	 * @param balthazarBeauregard
	 * 			The balthazarBeauregard to set.
	 */
	public void setBalthazarBeauregard(BalthazarBeauregard balthazarBeauregard) {
		this.balthazarBeauregard = balthazarBeauregard;
	}

	/**
	 * 
	 * @return balthazarBeauregard
	 * 			Returns the balthazarBeauregard to get.
	 */
	public BalthazarBeauregard getBalthazarBeauregard() {
		return this.balthazarBeauregard;
	}

	/**
	 * 
	 * @param circusBarker
	 * 			The circusBarker to set.
	 */
	public void setCircusBarker(CircusBarker circusBarker) {
		this.circusBarker = circusBarker;
	}

	/**
	 * 
	 * @return circusBarker
	 * 			Returns the circusBarker to get.
	 */
	public CircusBarker getCircusBarker() {
		return this.circusBarker;
	}

	/**
	 * 
	 * @param ticketVendor
	 * 			The ticketVendor to set.
	 */
	public void setTicketVendor(TicketVendor ticketVendor) {
		this.ticketVendor = ticketVendor;
	}

	/**
	 * 
	 * @return ticketVendor
	 * 			Returns the ticketVendor to get.
	 */
	public TicketVendor getTicketVendor() {
		return this.ticketVendor;
	}

	/**
	 * 
	 * @param agilityPerformance
	 * 			The agilityPerformance to set.
	 */
	public void setAgilityPerformance(AgilityPerformance agilityPerformance) {
		this.agilityPerformance = agilityPerformance;
	}

	/**
	 * 
	 * @return agilityPerformance
	 * 			Returns the agilityPerformance to get.
	 */
	public AgilityPerformance getAgilityPerformance() {
		return this.agilityPerformance;
	}

	/**
	 * 
	 * @param magicPerformance
	 * 			The magicPerformance to set.
	 */
	public void setMagicPerformance(MagicPerformance magicPerformance) {
		this.magicPerformance = magicPerformance;
	}

	/**
	 * 
	 * @return magicPerformance
	 * 			Returns the magicPerformance to get.
	 */
	public MagicPerformance getMagicPerformance() {
		return this.magicPerformance;
	}

	/**
	 * 
	 * @param rangePerformance
	 * 			The rangePerformance to set.
	 */
	public void setRangePerformance(RangePerformance rangePerformance) {
		this.rangePerformance = rangePerformance;
	}

	/**
	 * 
	 * @return rangePerformance
	 * 			Returns the rangePerformance to get.
	 */
	public RangePerformance getRangePerformance() {
		return this.rangePerformance;
	}
}