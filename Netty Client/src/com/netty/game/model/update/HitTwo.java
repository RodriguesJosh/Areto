package com.netty.game.model.update;

public class HitTwo {

	private byte damage;
	private HitType hitType;

	public HitTwo(byte damage, HitType hitType) {
		this.setDamage(damage);
		this.setHitType(hitType);
	}

	public void setDamage(byte damage) {
		this.damage = damage;
	}

	public byte getDamage() {
		return this.damage;
	}

	public void setHitType(HitType hitType) {
		this.hitType = hitType;
	}

	public HitType getHitType() {
		return this.hitType;
	}
}