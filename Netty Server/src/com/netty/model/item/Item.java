package com.netty.model.item;

import com.netty.model.Entity;

public class Item extends Entity {

	private int amount;
	private short attackStab;
	private short attackSlash;
	private short attackCrush;
	private short attackMagic;
	private short attackRange;
	private short defenceStab;
	private short defenceSlash;
	private short defenceCrush;
	private short defenceMagic;
	private short defenceRange;
	private short strength;
	private short prayer;
	private short weight;
	private boolean isActivated;
	private int price;

	public Item(int id, int amount) {
		this.setID(id);
		this.setAmount(amount);
	}

	public boolean isRangeItem() {
		return false;
	}

	public boolean isMageItem() {
		return false;
	}

	public boolean isMeleeItem() {
		return false;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		if (amount < 1) {
			amount = 1;
		}
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAttackStab(short attackStab) {
		this.attackStab = attackStab;
	}

	public short getAttackStab() {
		return this.attackStab;
	}

	public void setAttackSlash(short attackSlash) {
		this.attackSlash = attackSlash;
	}

	public short getAttackSlash() {
		return this.attackSlash;
	}

	public void setAttackCrush(short attackCrush) {
		this.attackCrush = attackCrush;
	}

	public short getAttackCrush() {
		return this.attackCrush;
	}

	public void setAttackMagic(short attackMagic) {
		this.attackMagic = attackMagic;
	}

	public short getAttackMagic() {
		return this.attackMagic;
	}

	public void setAttackRange(short attackRange) {
		this.attackRange = attackRange;
	}

	public short getAttackRange() {
		return this.attackRange;
	}

	public void setDefenceStab(short defenceStab) {
		this.defenceStab = defenceStab;
	}

	public short getDefenceStab() {
		return this.defenceStab;
	}

	public void setDefenceSlash(short defenceSlash) {
		this.defenceSlash = defenceSlash;
	}

	public short getDefenceSlash() {
		return this.defenceSlash;
	}

	public void setDefenceCrush(short defenceCrush) {
		this.defenceCrush = defenceCrush;
	}

	public short getDefenceCrush() {
		return this.defenceCrush;
	}

	public void setDefenceMagic(short defenceMagic) {
		this.defenceMagic = defenceMagic;
	}

	public short getDefenceMagic() {
		return this.defenceMagic;
	}

	public void setDefenceRange(short defenceRange) {
		this.defenceRange = defenceRange;
	}

	public short getDefenceRange() {
		return this.defenceRange;
	}

	public void setStrength(short strength) {
		this.strength = strength;
	}

	public short getStrength() {
		return this.strength;
	}

	public void setPrayer(short prayer) {
		this.prayer = prayer;
	}

	public short getPrayer() {
		return this.prayer;
	}

	public void setWeight(short weight) {
		this.weight = weight;
	}

	public short getWeight() {
		return this.weight;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean isActivated() {
		return this.isActivated;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
}