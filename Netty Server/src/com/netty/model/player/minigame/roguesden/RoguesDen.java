package com.netty.model.player.minigame.roguesden;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class RoguesDen extends MiniGame {

	public RoguesDen(Player player) {
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
}
