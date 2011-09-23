package com.netty.model.item;

import com.netty.model.Entity;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:44:23 AM
 */
public class Item extends Entity {

	/**
	 * 
	 */
	private int amount;

	/**
	 * 
	 */
	private short attackStab;

	/**
	 * 
	 */
	private short attackSlash;

	/**
	 * 
	 */
	private short attackCrush;

	/**
	 * 
	 */
	private short attackMagic;

	/**
	 * 
	 */
	private short attackRange;

	/**
	 * 
	 */
	private short defenceStab;

	/**
	 * 
	 */
	private short defenceSlash;

	/**
	 * 
	 */
	private short defenceCrush;

	/**
	 * 
	 */
	private short defenceMagic;

	/**
	 * 
	 */
	private short defenceRange;

	/**
	 * 
	 */
	private short strength;

	/**
	 * 
	 */
	private short prayer;

	/**
	 * 
	 */
	private short weight;

	/**
	 * 
	 */
	private boolean isActivated;

	/**
	 * 
	 */
	private int price;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param amount
	 * 			The id to set.
	 */
	public Item(int id, int amount) {
		this.setID(id);
		this.setAmount(amount);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isRangeItem() {
		return false;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMageItem() {
		return false;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMeleeItem() {
		return false;
	}

	/**
	 * 
	 * @param amount
	 * 			The id to set.
	 */
	public void setAmount(int amount) {
		if (amount < 1) {
			throw new IllegalArgumentException("Amount cannot be lower than 1.");
		}
		this.amount = amount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param attackStab
	 * 			The id to set.
	 */
	public void setAttackStab(short attackStab) {
		this.attackStab = attackStab;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getAttackStab() {
		return this.attackStab;
	}

	/**
	 * 
	 * @param attackSlash
	 * 			The id to set.
	 */
	public void setAttackSlash(short attackSlash) {
		this.attackSlash = attackSlash;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getAttackSlash() {
		return this.attackSlash;
	}

	/**
	 * 
	 * @param attackCrush
	 * 			The id to set.
	 */
	public void setAttackCrush(short attackCrush) {
		this.attackCrush = attackCrush;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getAttackCrush() {
		return this.attackCrush;
	}

	/**
	 * 
	 * @param attackMagic
	 * 			The id to set.
	 */
	public void setAttackMagic(short attackMagic) {
		this.attackMagic = attackMagic;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getAttackMagic() {
		return this.attackMagic;
	}

	/**
	 * 
	 * @param attackRange
	 * 			The id to set.
	 */
	public void setAttackRange(short attackRange) {
		this.attackRange = attackRange;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getAttackRange() {
		return this.attackRange;
	}

	/**
	 * 
	 * @param defenceStab
	 * 			The id to set.
	 */
	public void setDefenceStab(short defenceStab) {
		this.defenceStab = defenceStab;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getDefenceStab() {
		return this.defenceStab;
	}

	/**
	 * 
	 * @param defenceSlash
	 * 			The id to set.
	 */
	public void setDefenceSlash(short defenceSlash) {
		this.defenceSlash = defenceSlash;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getDefenceSlash() {
		return this.defenceSlash;
	}

	/**
	 * 
	 * @param defenceCrush
	 * 			The id to set.
	 */
	public void setDefenceCrush(short defenceCrush) {
		this.defenceCrush = defenceCrush;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getDefenceCrush() {
		return this.defenceCrush;
	}

	/**
	 * 
	 * @param defenceMagic
	 * 			The id to set.
	 */
	public void setDefenceMagic(short defenceMagic) {
		this.defenceMagic = defenceMagic;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getDefenceMagic() {
		return this.defenceMagic;
	}

	/**
	 * 
	 * @param defenceRange
	 * 			The id to set.
	 */
	public void setDefenceRange(short defenceRange) {
		this.defenceRange = defenceRange;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getDefenceRange() {
		return this.defenceRange;
	}

	/**
	 * 
	 * @param strength
	 * 			The id to set.
	 */
	public void setStrength(short strength) {
		this.strength = strength;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getStrength() {
		return this.strength;
	}

	/**
	 * 
	 * @param prayer
	 * 			The id to set.
	 */
	public void setPrayer(short prayer) {
		this.prayer = prayer;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getPrayer() {
		return this.prayer;
	}

	/**
	 * 
	 * @param weight
	 * 			The id to set.
	 */
	public void setWeight(short weight) {
		this.weight = weight;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getWeight() {
		return this.weight;
	}

	/**
	 * 
	 * @param isActivated
	 * 			The id to set.
	 */
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isActivated() {
		return this.isActivated;
	}

	/**
	 * 
	 * @param price
	 * 			The id to set.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getPrice() {
		return this.price;
	}
}