package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.world.Location;

public class CastleWars extends MiniGame {

	private Lobby lobby;
	private Team team;

	public CastleWars(Player player, Location location, Object object) {
		super(player);
		this.setLobby(new Lobby(player, location, object));
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

	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	public Lobby getLobby() {
		return this.lobby;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return this.team;
	}
}
