package com.netty.model.player.minigame.fightpits;

import com.netty.model.Entity;
import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.RangeCombat;
import com.netty.model.combat.magic.MagicCombat;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:41:39 PM
 */
public class FightPits extends MiniGame {

	/**
	 * 
	 */
	private WaitingRoom waitingRoom;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param waitingRoom
	 *			The id to set.
	 */
	public FightPits(Player player, WaitingRoom waitingRoom) {
		super(player);
		this.setWaitingRoom(waitingRoom);
		this.getWaitingRoom().getPlayerList().add(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		this.getPlayer().setTeleport(Teleport.FIGHT_PITS);
		if (this.getWaitingRoom().getPlayerList().size() < 2) {
			return;
		}
		Entity entity = this.getWaitingRoom().getPlayerList().get(0);
		if (this.getPlayer().isRanging()) {
			this.getPlayer().setCombat(new RangeCombat(this.getPlayer(), entity, CombatType.RANGE, AttackType.ACCURATE));
		} else if (this.getPlayer().isMaging()) {
			this.getPlayer().setCombat(new MagicCombat(this.getPlayer(), entity, CombatType.MAGIC, AttackType.ACCURATE));
		} else if (this.getPlayer().isMeleeing()) {
			this.getPlayer().setCombat(new MeleeCombat(this.getPlayer(), entity, CombatType.MELEE, AttackType.ACCURATE));
		}
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
		return MembershipState.FREE;
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
	 * @param waitingRoom
	 *			The id to set.
	 */
	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}
}
