package com.netty.model.player.minigame.conquest;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class Conquest extends MiniGame {

	private WaitingRoom waitingRoom;
	private Unit unit;
	private Command command;
	private Reward reward;

	public Conquest(Player player, WaitingRoom waitingRoom) {
		super(player);
		this.setWaitingRoom(waitingRoom);
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

	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return this.command;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
