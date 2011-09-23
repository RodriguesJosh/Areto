package com.netty.model.player.minigame.gnomerestaurant;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:47:09 PM
 */
public class GnomeRestaurant extends MiniGame {

	/**
	 * 
	 */
	private Gnomebowls gnomebowls;

	/**
	 * 
	 */
	private Battas battas;

	/**
	 * 
	 */
	private Crunchies crunchies;

	/**
	 * 
	 */
	private Cocktails cocktails;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public GnomeRestaurant(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		this.setReward(Reward.NONE);
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
	 * @param gnomebowls
	 *			The id to set.
	 */
	public void setGnomebowls(Gnomebowls gnomebowls) {
		this.gnomebowls = gnomebowls;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Gnomebowls getGnomebowls() {
		return this.gnomebowls;
	}

	/**
	 * 
	 * @param battas
	 *			The id to set.
	 */
	public void setBattas(Battas battas) {
		this.battas = battas;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Battas getBattas() {
		return this.battas;
	}

	/**
	 * 
	 * @param crunchies
	 *			The id to set.
	 */
	public void setCrunchies(Crunchies crunchies) {
		this.crunchies = crunchies;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Crunchies getCrunchies() {
		return this.crunchies;
	}

	/**
	 * 
	 * @param cocktails
	 *			The id to set.
	 */
	public void setCocktails(Cocktails cocktails) {
		this.cocktails = cocktails;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Cocktails getCocktails() {
		return this.cocktails;
	}

	/**
	 * 
	 * @param reward
	 *			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}
