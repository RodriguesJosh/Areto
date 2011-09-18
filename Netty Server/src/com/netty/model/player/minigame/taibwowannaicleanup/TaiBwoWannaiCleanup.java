package com.netty.model.player.minigame.taibwowannaicleanup;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class TaiBwoWannaiCleanup extends MiniGame {

	public TaiBwoWannaiCleanup(Player player) {
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
}
