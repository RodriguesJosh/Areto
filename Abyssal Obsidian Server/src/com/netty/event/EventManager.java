package com.netty.event;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 1:18:27 PM
 */
public class EventManager {

	/**
	 * 
	 */
	private Queue<Event> eventList;

	/**
	 * 
	 */
	public EventManager() {
		this.setEventList(new PriorityBlockingQueue<Event>());
	}

	/**
	 * 
	 * @param eventList
	 * 			The eventList to set.
	 */
	public void setEventList(Queue<Event> eventList) {
		this.eventList = eventList;
	}

	/**
	 * 
	 * @return eventList
	 * 			Returns the eventList to get.
	 */
	public Queue<Event> getEventList() {
		return this.eventList;
	}
}