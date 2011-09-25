package com.netty.model.combat.range;

import java.util.List;
import java.util.Random;

import com.netty.model.Entity;
import com.netty.model.combat.AttackType;
import com.netty.model.combat.Combat;
import com.netty.model.combat.CombatType;
import com.netty.model.player.Player;
import com.netty.model.player.skill.Skill;
import com.netty.model.player.skill.SkillType;
import com.netty.model.update.Animation;
import com.netty.model.update.Hit;
import com.netty.model.update.HitType;
import com.netty.model.update.UpdateFlag;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:42:53 AM
 */
public class RangeCombat extends Combat {

	/**
	 * 
	 */
	private Bow bow;
	/**
	 * 
	 */
	private List<Amo> amoList;

	/**
	 * 
	 * @param entityPlayer
	 * 			The id to set.
	 * @param entityEnemy
	 * 			The id to set.
	 * @param combatType
	 * 			The id to set.
	 * @param attackType
	 * 			The id to set.
	 */
	public RangeCombat(Player entityPlayer, Entity entityEnemy, CombatType combatType, AttackType attackType) {
		super(entityPlayer, entityEnemy, combatType, attackType);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.combat.Combat#mageDamage()
	 */
	@Override
	public void mageDamage() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.combat.Combat#meleeDamage()
	 */
	@Override
	public void meleeDamage() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.combat.Combat#rangeDamage()
	 */
	@Override
	public void rangeDamage() {
		Random random = new Random();
		byte skillID = ((Player) this.getEntityEnemy()).getSkills()[SkillType.HITPOINT.getID()].getID();
		Skill skill = ((Player) this.getEntityEnemy()).getSkills()[skillID];
		byte damage = (byte) random.nextInt(skill.getLevel());
		if (skill.getLevel() <= damage) {
			damage = skill.getLevel();
		}
		int entityLevel = skill.getLevel() - damage;
		skill.removeLevel(entityLevel);
		if (this.getAttackType() == AttackType.ACCURATE) {
			int experience = 1;
			skill.addExperience(experience);
		} else if (this.getAttackType() == AttackType.AGGRESIVE) {
			int experience = 1;
			skill.addExperience(experience);
		} else if (this.getAttackType() == AttackType.DEFENSIVE) {
			int experience = 1;
			skill.addExperience(experience);
		} else if (this.getAttackType() == AttackType.CONTROLLED) {
			int experience = 1;
			skill.addExperience(experience);
			skill.addExperience(experience);
			skill.addExperience(experience);
		}
		skill.addExperience(2 * damage);
		this.getPlayer().setAnimation(new Animation(424, 0));
		this.getEntityEnemy().setAnimation(new Animation(1659, 0));
		this.getEntityEnemy().setHit(new Hit(damage, HitType.NORMAL_DAMAGE));
		this.getEntityEnemy().getUpdateFlags().setUpdateFlag(UpdateFlag.HIT);
		this.getEntityEnemy().getUpdateFlags().setUpdateFlag(UpdateFlag.APPEARANCE);
		this.getPlayer().getUpdateFlags().setUpdateFlag(UpdateFlag.APPEARANCE);
	}

	/**
	 * 
	 * @param bow
	 * 			The id to set.
	 */
	public void setBow(Bow bow) {
		this.bow = bow;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Bow getBow() {
		return this.bow;
	}

	/**
	 * 
	 * @param amoList
	 * 			The id to set.
	 */
	public void setAmoList(List<Amo> amoList) {
		this.amoList = amoList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Amo> getAmoList() {
		return this.amoList;
	}
}