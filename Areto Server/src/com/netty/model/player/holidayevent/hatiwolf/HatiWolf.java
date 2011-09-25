package com.netty.model.player.holidayevent.hatiwolf;

import com.netty.model.player.holidayevent.DateEvent;
import com.netty.model.player.holidayevent.HolidayEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 24, 2011 11:07:09 AM
 */
public class HatiWolf extends HolidayEvent {

	/**
	 * 
	 */
	private Hati hati;

	/**
	 * 
	 */
	public HatiWolf() {
		super(DateEvent.TWO_THOUSAND_ELEVEN);
	}

	/**
	 * 
	 * @param hati
	 * 			The hati to set.
	 */
	public void setHati(Hati hati) {
		this.hati = hati;
	}

	/**
	 * 
	 * @return hati
	 * 			Returns the hati to get.
	 */
	public Hati getHati() {
		return this.hati;
	}
}