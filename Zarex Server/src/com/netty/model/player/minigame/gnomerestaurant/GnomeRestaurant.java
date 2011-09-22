package com.netty.model.player.minigame.gnomerestaurant;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class GnomeRestaurant extends MiniGame {

	private Gnomebowls gnomebowls;
	private Battas battas;
	private Crunchies crunchies;
	private Cocktails cocktails;
	private Reward reward;

	public GnomeRestaurant(Player player) {
		super(player);
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

	public void setGnomebowls(Gnomebowls gnomebowls) {
		this.gnomebowls = gnomebowls;
	}

	public Gnomebowls getGnomebowls() {
		return this.gnomebowls;
	}

	public void setBattas(Battas battas) {
		this.battas = battas;
	}

	public Battas getBattas() {
		return this.battas;
	}

	public void setCrunchies(Crunchies crunchies) {
		this.crunchies = crunchies;
	}

	public Crunchies getCrunchies() {
		return this.crunchies;
	}

	public void setCocktails(Cocktails cocktails) {
		this.cocktails = cocktails;
	}

	public Cocktails getCocktails() {
		return this.cocktails;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
