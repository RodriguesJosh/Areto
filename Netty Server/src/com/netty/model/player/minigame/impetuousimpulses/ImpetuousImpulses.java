package com.netty.model.player.minigame.impetuousimpulses;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class ImpetuousImpulses extends MiniGame {

	private PuroPuro puroPuro;
	private Reward reward;

	public ImpetuousImpulses(Player player) {
		super(player);
	}

	@Override
	public void start() {}

	@Override
	public void end() {}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setPuroPuro(PuroPuro puroPuro) {
		this.puroPuro = puroPuro;
	}

	public PuroPuro getPuroPuro() {
		return this.puroPuro;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
