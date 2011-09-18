package com.netty.model.player.minigame.tearsofguthix;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class TearsOfGuthix extends MiniGame {

	private Reward reward;

	public TearsOfGuthix(Player player) {
		super(player);
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
		return ThreateningState.SAFE;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
