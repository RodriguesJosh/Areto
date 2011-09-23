package com.netty.model.player.minigame.herblorehabitat;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:40:57 PM
 */
public class HerbloreHabitat extends MiniGame {

	/**
	 * 
	 */
	private Area area;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public HerbloreHabitat(Player player) {
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
		//
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
	 * @param area
	 * 			The id to set.
	 */
	public void setArea(Area area) {
		this.area = area;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Area getArea() {
		return this.area;
	}
}
