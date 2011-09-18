package com.netty.model.player.minigame.mobilisingarmies;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class MobilisingArmies extends MiniGame {

	private Squad squad;
	private GameType gameType;
	private Reward reward;

	public MobilisingArmies(Player player, Squad squad, GameType gameType) {
		super(player);
		this.setSquad(squad);
		this.setGameType(gameType);
	}

	@Override
	public void start() {
		this.getPlayer().setTeleport(this.getGameType().getGame().getTeleport());
	}

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

	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	public Squad getSquad() {
		return this.squad;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public GameType getGameType() {
		return this.gameType;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
