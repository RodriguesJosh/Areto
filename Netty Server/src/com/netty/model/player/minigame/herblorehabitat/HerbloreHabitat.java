package com.netty.model.player.minigame.herblorehabitat;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class HerbloreHabitat extends MiniGame {

	private Area area;

	public HerbloreHabitat(Player player) {
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
		return ThreateningState.SAFE;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Area getArea() {
		return this.area;
	}
}
