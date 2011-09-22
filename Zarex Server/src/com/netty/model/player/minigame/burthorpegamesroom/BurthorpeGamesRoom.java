package com.netty.model.player.minigame.burthorpegamesroom;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class BurthorpeGamesRoom extends MiniGame {

	private Game game;
	private Sam sam;
	private Rachael rachael;

	public BurthorpeGamesRoom(Player player) {
		super(player);
		this.setSam(new Sam());
		this.setRachael(new Rachael());
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

	public void setGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return this.game;
	}

	public void setSam(Sam sam) {
		this.sam = sam;
	}

	public Sam getSam() {
		return this.sam;
	}

	public void setRachael(Rachael rachael) {
		this.rachael = rachael;
	}

	public Rachael getRachael() {
		return this.rachael;
	}
}
