package com.netty.model.combat.magic;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;

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
 * @since Sep 21, 2011 10:34:28 AM
 */
public class MagicCombat extends Combat {

	/**
	 * 
	 */
	private ConcurrentMap<Short, Spell> spellMap;

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
	public MagicCombat(Player entityPlayer, Entity entityEnemy, CombatType combatType, AttackType attackType) {
		super(entityPlayer, entityEnemy, combatType, attackType);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.combat.Combat#mageDamage()
	 */
	@Override
	public void mageDamage() {
		Random random = new Random();
		byte skillID = ((Player) this.getEntityEnemy()).getSkills()[SkillType.HITPOINT.getID()].getID();
		Skill skill = ((Player) this.getEntityEnemy()).getSkills()[skillID];
		byte damage = (byte) random.nextInt(skillID);
		if (skill.getLevel() <= damage) {
			damage = skill.getLevel();
		}
		short entityLevel = (short) (skill.getLevel() - damage);
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
		return;
	}

	/**
	 * 
	 * @param spellMap
	 * 			The id to set.
	 */
	public void setSpellMap(ConcurrentMap<Short, Spell> spellMap) {
		this.spellMap = spellMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ConcurrentMap<Short, Spell> getSpellMap() {
		return this.spellMap;
	}
}