package com.netty.model.player.minigame.burthorpegamesroom;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:17:33 PM
 */
public class BurthorpeGamesRoom extends MiniGame {

	/**
	 * 
	 */
	private Game game;

	/**
	 * 
	 */
	private Sam sam;

	/**
	 * 
	 */
	private Rachael rachael;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public BurthorpeGamesRoom(Player player) {
		super(player);
		this.setSam(new Sam());
		this.setRachael(new Rachael());
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getThreateningState()
	 */
	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	/**
	 * 
	 * @param game
	 * 			The id to set.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Game getGame() {
		return this.game;
	}

	/**
	 * 
	 * @param sam
	 * 			The id to set.
	 */
	public void setSam(Sam sam) {
		this.sam = sam;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Sam getSam() {
		return this.sam;
	}

	/**
	 * 
	 * @param rachael
	 * 			The id to set.
	 */
	public void setRachael(Rachael rachael) {
		this.rachael = rachael;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Rachael getRachael() {
		return this.rachael;
	}
}