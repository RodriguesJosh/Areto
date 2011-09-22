package com.netty.model.combat.melee;

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

public class MeleeCombat extends Combat {

	private Weapon weapon;

	public MeleeCombat(Player entityPlayer, Entity entityEnemy, CombatType combatType, AttackType attackType) {
		super(entityPlayer, entityEnemy, combatType, attackType);
	}

	@Override
	public void mageDamage() {
		return;
	}

	@Override
	public void meleeDamage() {
		Random random = new Random();
		byte skillID = ((Player) this.getEntityEnemy()).getSkills()[SkillType.HITPOINT.getID()].getID();
		Skill skill = ((Player) this.getEntityEnemy()).getSkills()[skillID];
		byte damage = (byte) random.nextInt(skill.getLevel());
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

	@Override
	public void rangeDamage() {
		return;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}
}