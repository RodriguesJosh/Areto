package com.netty.model.player.minigame.duelarena;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class DuelArena extends MiniGame {

	private Staking staking;
	private Tournament tournament;

	public DuelArena(Player player) {
		super(player);
	}

	@Override
	public void start() {
		this.getPlayer().setTeleport(Teleport.DUEL_ARENA);
	}

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

	public void setStaking(Staking staking) {
		this.staking = staking;
	}

	public Staking getStaking() {
		return this.staking;
	}

	public boolean isStaking() {
		return this.getStaking() != null;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public boolean isTournament() {
		return this.getTournament() != null;
	}
}
