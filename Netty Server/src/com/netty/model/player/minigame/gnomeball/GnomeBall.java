package com.netty.model.player.minigame.gnomeball;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class GnomeBall extends MiniGame {

	private Ball ball;

	public GnomeBall(Player player) {
		super(player);
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

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Ball getBall() {
		return this.ball;
	}
}
