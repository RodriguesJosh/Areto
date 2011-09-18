package com.netty.model.player.minigame.soulwars;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class SoulWars extends MiniGame {

	private WaitingRoom waitingRoom;

	public SoulWars(Player player) {
		super(player);
		this.setWaitingRoom(new WaitingRoom(new Nomad(), new Zimberfizz()));
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

	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}
}
