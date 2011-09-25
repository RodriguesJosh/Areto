package com.netty.model.player.minigame.templetrekking;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:19:00 PM
 */
public class TempleTrekking extends MiniGame {

	/**
	 * 
	 */
	private Follower follower;

	/**
	 * 
	 */
	private EscortPeople escortPeople;

	/**
	 * 
	 */
	private Route route;

	/**
	 * 
	 */
	private Event event;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param follower
	 * 			The id to set.
	 * @param escortPeople
	 * 			The id to set.
	 */
	public TempleTrekking(Player player, Follower follower, EscortPeople escortPeople) {
		super(player);
		this.setFollower(follower);
		this.setEscortPeople(escortPeople);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		this.setReward(Reward.NONE);
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
	 * @param follower
	 * 			The id to set.
	 */
	public void setFollower(Follower follower) {
		this.follower = follower;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Follower getFollower() {
		return this.follower;
	}

	/**
	 * 
	 * @param escortPeople
	 * 			The id to set.
	 */
	public void setEscortPeople(EscortPeople escortPeople) {
		this.escortPeople = escortPeople;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EscortPeople getEscortPeople() {
		return this.escortPeople;
	}

	/**
	 * 
	 * @param route
	 * 			The id to set.
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Route getRoute() {
		return this.route;
	}

	/**
	 * 
	 * @param event
	 * 			The id to set.
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Event getEvent() {
		return this.event;
	}

	/**
	 * 
	 * @param reward
	 * 			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}
