package com.netty.model.player.minigame.brimhavenagilityarena;

import java.util.LinkedList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.agility.Ticket;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:11:46 PM
 */
public class BrimhavenAgilityArena extends MiniGame {

	/**
	 * 
	 */
	private List<Ticket> ticketList;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public BrimhavenAgilityArena(Player player) {
		super(player);
		this.setTicketList(new LinkedList<Ticket>());
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getThreateningState()
	 */
	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.DANGEROUS;
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
