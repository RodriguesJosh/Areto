package com.netty.model.player.holidayevent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 9:43:30 PM
 */
public class HolidayEvent {

	/**
	 * 
	 */
	private DateEvent dateEvent;

	/**
	 * 
	 * 
	 * @param dateEvent
	 * 			The date in which the event occured.
	 */
	public HolidayEvent(DateEvent dateEvent) {
		this.setDateEvent(dateEvent);
	}

	/**
	 * 
	 * @param dateEvent
	 * 			The dateEvent to set.
	 */
	public void setDateEvent(DateEvent dateEvent) {
		this.dateEvent = dateEvent;
	}

	/**
	 * 
	 * @return dateEvent
	 * 			Returns the dateEvent to get.
	 */
	public DateEvent getDateEvent() {
		return this.dateEvent;
	}
}