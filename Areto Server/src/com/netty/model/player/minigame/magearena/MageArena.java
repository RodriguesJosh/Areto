package com.netty.model.player.minigame.magearena;

import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.RangeCombat;
import com.netty.model.combat.magic.MagicCombat;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:38:27 PM
 */
public class MageArena extends MiniGame {

	/**
	 * 
	 */
	private Kolodion kolodion;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public MageArena(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		if (this.getPlayer().getSkills()[SkillType.MAGIC.getID()].getLevel() < 60) {
			return;
		}
		this.setKolodion(new Kolodion());
		NPC npc = this.getKolodion().getNPC();
		if (this.getPlayer().isMaging()) {
			this.getPlayer().setCombat(new MagicCombat(this.getPlayer(), npc, CombatType.MAGIC, AttackType.ACCURATE));
		} else if (this.getPlayer().isRanging()) {
			this.getPlayer().setCombat(new RangeCombat(this.getPlayer(), npc, CombatType.RANGE, AttackType.ACCURATE));
		} else if (this.getPlayer().isMeleeing()) {
			this.getPlayer().setCombat(new MeleeCombat(this.getPlayer(), npc, CombatType.MELEE, AttackType.ACCURATE));
		}
		npc.getCombat().setCombatType(CombatType.MAGIC);
		if (npc.getHealth() == 10) {
			this.getKolodion().setForm(Form.SECOND);
			npc.setHealth((byte) (npc.getHealth() + 50));
			if (npc.getHealth() > 100) {
				return;
			}
		}
		if (npc.getHealth() == 10) {
			this.getKolodion().setForm(Form.THIRD);
			npc.setHealth((byte) (npc.getHealth() + 50));
			if (npc.getHealth() > 100) {
				return;
			}
		}
		if (npc.getHealth() == 10) {
			this.getKolodion().setForm(Form.FOURTH);
			npc.setHealth((byte) (npc.getHealth() + 50));
			if (npc.getHealth() > 100) {
				return;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		if (this.getKolodion().getNPC().isDead()) {
			this.getPlayer().setTeleport(Teleport.MAGE_ARENA);
		}
		this.setReward(Reward.NONE);
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
	 * @param kolodion
	 * 			The id to set.
	 */
	public void setKolodion(Kolodion kolodion) {
		this.kolodion = kolodion;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Kolodion getKolodion() {
		return this.kolodion;
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
