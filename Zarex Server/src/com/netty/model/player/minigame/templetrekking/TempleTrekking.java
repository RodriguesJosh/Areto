package com.netty.model.player.minigame.templetrekking;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class TempleTrekking extends MiniGame {

	private Follower follower;
	private EscortPeople escortPeople;
	private Route route;
	private Event event;
	private Reward reward;

	public TempleTrekking(Player player, Follower follower, EscortPeople escortPeople) {
		super(player);
		this.setFollower(follower);
		this.setEscortPeople(escortPeople);
	}

	@Override
	public void start() {}

	@Override
	public void end() {
		this.setReward(Reward.NONE);
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.DANGEROUS;
	}

	public void setFollower(Follower follower) {
		this.follower = follower;
	}

	public Follower getFollower() {
		return this.follower;
	}

	public void setEscortPeople(EscortPeople escortPeople) {
		this.escortPeople = escortPeople;
	}

	public EscortPeople getEscortPeople() {
		return this.escortPeople;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Route getRoute() {
		return this.route;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
