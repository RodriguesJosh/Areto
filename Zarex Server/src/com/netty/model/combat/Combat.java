package com.netty.model.combat;

import com.netty.model.Entity;
import com.netty.model.player.Player;
import com.netty.model.update.Animation;
import com.netty.model.update.FaceEntity;
import com.netty.model.update.UpdateFlag;

public abstract class Combat {

	private Player player;
	private Entity entityEnemy;
	private CombatType combatType;
	private AttackType attackType;
	private AutoRetaliate autoRetaliate;
	private Poison poison;

	public Combat(Player player, Entity entityEnemy, CombatType combatType, AttackType attackType) {
		this.setPlayer(player);
		this.setEntityEnemy(entityEnemy);
		this.setCombatType(combatType);
		this.setAttackType(attackType);
	}

	public void attackEntityEnemy() {
		if (!this.canAttackEntityEnemy()) {
			return;
		}
		this.getPlayer().setFaceEntity(new FaceEntity(this.getEntityEnemy()));
		this.getPlayer().getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_ENTITY);
		if (this.getPlayer().isMeleeing()) {
			this.getPlayer().setAnimation(new Animation(806, 0));
			this.meleeDamage();
		} else if (this.getPlayer().isMaging()) {
			this.getPlayer().setAnimation(new Animation(806, 0));
			this.mageDamage();
		} else if (this.getPlayer().isRanging()) {
			this.getPlayer().setAnimation(new Animation(806, 0));
			this.rangeDamage();
		}
	}

	private boolean canAttackEntityEnemy() {
		if (this.getPlayer() == null) {
			return false;
		}
		if (this.getPlayer().getLocation() == null) {
			return false;
		}
		if (this.getEntityEnemy() == null) {
			return false;
		}
		if (this.getEntityEnemy().getLocation() == null) {
			return false;
		}
		if ((this instanceof MagicCombat) && (this.getCombatType() != CombatType.MAGIC)) {
			return false;
		}
		if ((this instanceof MeleeCombat) && (this.getCombatType() != CombatType.MELEE)) {
			return false;
		}
		if ((this instanceof RangeCombat) && (this.getCombatType() != CombatType.RANGE)) {
			return false;
		}
		if (this.getPlayer().isDead()) {
			this.resetAttack();
			/** Drop items from the player. */
			return false;
		}
		if (this.getEntityEnemy().isDead()) {
			this.resetAttack();
			/** Drop items from the NPC. */
			return false;
		}
		if (!this.getPlayer().getLocation().isWithinDistance(this.getEntityEnemy().getLocation()) && !this.getPlayer().isRanging() && !this.getPlayer().isMaging()) {
			return false;
		}
		return true;
	}

	public void resetAttack() {
		if (this.getPlayer() == null) {
			return;
		}
		if (this.getPlayer().getUpdateFlags() == null) {
			return;
		}
		if (this.getEntityEnemy() == null) {
			return;
		}
		if (this.getEntityEnemy().getUpdateFlags() == null) {
			return;
		}
		this.getPlayer().resetFaceEntity();
		this.getPlayer().getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_ENTITY, false);
		this.getPlayer().resetAnimation();
		this.getEntityEnemy().resetFaceEntity();
		this.getEntityEnemy().getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_ENTITY, false);
		if (this.getEntityEnemy() instanceof Player) {
			this.getEntityEnemy().resetAnimation();
		}
	}

	public abstract void mageDamage();
	public abstract void meleeDamage();
	public abstract void rangeDamage();

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setEntityEnemy(Entity entityEnemy) {
		this.entityEnemy = entityEnemy;
	}

	public Entity getEntityEnemy() {
		return this.entityEnemy;
	}

	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	public CombatType getCombatType() {
		return this.combatType;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public AttackType getAttackType() {
		return this.attackType;
	}

	public void setAutoRetaliate(AutoRetaliate autoRetaliate) {
		this.autoRetaliate = autoRetaliate;
	}

	public AutoRetaliate getAutoRetaliate() {
		return this.autoRetaliate;
	}

	public void setPoison(Poison poison) {
		this.poison = poison;
	}

	public Poison getPoison() {
		return this.poison;
	}
}