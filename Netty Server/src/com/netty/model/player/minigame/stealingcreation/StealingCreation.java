package com.netty.model.player.minigame.stealingcreation;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class StealingCreation extends MiniGame {

	private Tutorial tutorial;
	private Team redTeam;
	private Team blueTeam;

	public StealingCreation(Player player) {
		super(player);
		this.setRedTeam(new RedTeam());
		this.setBlueTeam(new BlueTeam());
	}

	@Override
	public void start() {}

	@Override
	public void end() {
		this.getRedTeam().setReward(Reward.NONE);
		this.getBlueTeam().setReward(Reward.NONE);
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	public Tutorial getTutorial() {
		return this.tutorial;
	}

	public void setRedTeam(Team redTeam) {
		this.redTeam = redTeam;
	}

	public Team getRedTeam() {
		return this.redTeam;
	}

	public void setBlueTeam(Team blueTeam) {
		this.blueTeam = blueTeam;
	}

	public Team getBlueTeam() {
		return this.blueTeam;
	}
}
