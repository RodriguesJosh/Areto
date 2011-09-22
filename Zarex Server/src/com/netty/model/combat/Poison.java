package com.netty.model.combat;

public class Poison {

	private byte damage;
	private byte time;

	public Poison(byte damage, byte time) {
		this.setDamage(damage);
		this.setTime(time);
	}

	public void setDamage(byte damage) {
		this.damage = damage;
	}

	public byte getDamage() {
		return this.damage;
	}

	public void setTime(byte time) {
		this.time = time;
	}

	public byte getTime() {
		return this.time;
	}
}