package com.netty.model.player.skill.agility.brimhavenagilityarena;

import java.util.LinkedList;
import java.util.List;

import com.netty.model.player.skill.agility.Course;
import com.netty.model.player.skill.agility.Ticket;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:10:22 PM
 */
public class BrimhavenAgilityArena extends Course {

	/**
	 * 
	 */
	private List<Ticket> ticketList;

	/**
	 * 
	 */
	public BrimhavenAgilityArena() {
		super(null);
		this.setTicketList(new LinkedList<Ticket>());
	}

	/**
	 * 
	 * @param ticketList
	 * 			The id to set.
	 */
	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Ticket> getTicketList() {
		return this.ticketList;
	}
}