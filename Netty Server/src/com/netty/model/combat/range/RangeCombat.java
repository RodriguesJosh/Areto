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

public class RangeCombat extends Combat {

	private Bow bow;
	private List<Amo> amoList;

	public RangeCombat(Player entityPlayer, Entity entityEnemy, CombatType combatType, AttackType attackType) {
		super(entityPlayer, entityEnemy, combatType, attackType);
	}

	@Override
	public void mageDamage() {
		return;
	}

	@Override
	public void meleeDamage() {
		return;
	}

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

	public void setBow(Bow bow) {
		this.bow = bow;
	}

	public Bow getBow() {
		return this.bow;
	}

	public void setAmoList(List<Amo> amoList) {
		this.amoList = amoList;
	}

	public List<Amo> getAmoList() {
		return this.amoList;
	}
}