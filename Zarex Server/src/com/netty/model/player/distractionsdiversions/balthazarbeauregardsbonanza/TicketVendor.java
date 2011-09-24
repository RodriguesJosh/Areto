package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza;

import java.util.Queue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:41:31 PM
 */
public class TicketVendor {

	/**
	 * 
	 */
	private Queue<Ticket> ticketList;

	/**
	 * 
	 */
	public void takeTicket() {
		//
	}

	/**
	 * 
	 */
	public void tornTicket() {
		//
	}

	/**
	 * 
	 * @param ticketList
	 * 			The ticketList to set.
	 */
	public void setTicketList(Queue<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * 
	 * @return ticketList
	 * 			Returns the ticketList to get.
	 */
	public Queue<Ticket> getTicketList() {
		return this.ticketList;
	}
}