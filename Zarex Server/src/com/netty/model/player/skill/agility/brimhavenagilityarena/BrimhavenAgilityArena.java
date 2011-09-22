package com.netty.model.player.skill.agility.brimhavenagilityarena;

import java.util.LinkedList;
import java.util.List;

import com.netty.model.player.skill.agility.Course;
import com.netty.model.player.skill.agility.Ticket;

public class BrimhavenAgilityArena extends Course {

	private List<Ticket> ticketList;

	public BrimhavenAgilityArena() {
		super(null);
		this.setTicketList(new LinkedList<Ticket>());
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public List<Ticket> getTicketList() {
		return this.ticketList;
	}
}