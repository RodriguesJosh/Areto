package com.netty.model.player.minigame.mobilisingarmies;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:35:29 PM
 */
public class MobilisingArmies extends MiniGame {

	/**
	 * 
	 */
	private Squad squad;

	/**
	 * 
	 */
	private GameType gameType;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param squad
	 * 			The id to set.
	 * @param gameType
	 * 			The id to set.
	 */
	public MobilisingArmies(Player player, Squad squad, GameType gameType) {
		super(player);
		this.setSquad(squad);
		this.setGameType(gameType);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		this.getPlayer().setTeleport(this.getGameType().getGame().getTeleport());
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
	 * @param squad
	 * 			The id to set.
	 */
	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Squad getSquad() {
		return this.squad;
	}

	/**
	 * 
	 * @param gameType
	 * 			The id to set.
	 */
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public GameType getGameType() {
		return this.gameType;
	}

	/**
	 * 
	 * @param reward
	 * 			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}
