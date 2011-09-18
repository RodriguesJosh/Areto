package com.netty.model.player.minigame.brimhavenagilityarena;

import java.util.LinkedList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.agility.Ticket;

public class BrimhavenAgilityArena extends MiniGame {

	private List<Ticket> ticketList;

	public BrimhavenAgilityArena(Player player) {
		super(player);
		this.setTicketList(new LinkedList<Ticket>());
	}

	@Override
	public void start() {}

	@Override
	public void end() {}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.DANGEROUS;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public List<Ticket> getTicketList() {
		return this.ticketList;
	}
}
