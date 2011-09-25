package com.netty.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:35:42 PM
 */
public class Appearance {

	/**
	 * 
	 */
	private byte gender;

	/**
	 * 
	 */
	private byte chest;

	/**
	 * 
	 */
	private byte arms;

	/**
	 * 
	 */
	private byte legs;

	/**
	 * 
	 */
	private byte head;

	/**
	 * 
	 */
	private byte hands;

	/**
	 * 
	 */
	private byte feet;

	/**
	 * 
	 */
	private byte beard;

	/**
	 * 
	 */
	private byte hairColor;

	/**
	 * 
	 */
	private byte torsoColor;

	/**
	 * 
	 */
	private byte legColor;

	/**
	 * 
	 */
	private byte feetColor;

	/**
	 * 
	 */
	private byte skinColor;

	/**
	 * 
	 */
	public Appearance() {
		this.setGender((byte) 0);
		this.setHead((byte) 0);
		this.setChest((byte) 18);
		this.setArms((byte) 26);
		this.setHands((byte) 33);
		this.setLegs((byte) 36);
		this.setFeet((byte) 42);
		this.setBeard((byte) 10);
		this.setHairColor((byte) 7);
		this.setTorsoColor((byte) 8);
		this.setLegColor((byte) 9);
		this.setFeetColor((byte) 5);
		this.setSkinColor((byte) 0);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte[] getAppearance() {
		return new byte[] {
				this.getGender(), this.getHairColor(), this.getTorsoColor(), this.getLegColor(), this.getFeetColor(),
				this.getSkinColor(), this.getHead(), this.getChest(), this.getArms(), this.getHands(), this.getLegs(),
				this.getFeet(), this.getBeard()
		};
	}

	/**
	 * 
	 * @param appearance
	 * 			The id to set.
	 */
	public void setAppearance(byte[] appearance) {
		this.setGender(appearance[0]);
		this.setHairColor(appearance[1]);
		this.setTorsoColor(appearance[2]);
		this.setLegColor(appearance[3]);
		this.setFeetColor(appearance[4]);
		this.setSkinColor(appearance[5]);
		this.setHead(appearance[6]);
		this.setChest(appearance[7]);
		this.setArms(appearance[8]);
		this.setHands(appearance[9]);
		this.setLegs(appearance[10]);
		this.setFeet(appearance[11]);
		this.setBeard(appearance[12]);
	}

	/**
	 * 
	 * @param hairColor
	 * 			The id to set.
	 */
	public void setHairColor(byte hairColor) {
		this.hairColor = hairColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getHairColor() {
		return this.hairColor;
	}

	/**
	 * 
	 * @param torsoColor
	 * 			The id to set.
	 */
	public void setTorsoColor(byte torsoColor) {
		this.torsoColor = torsoColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getTorsoColor() {
		return this.torsoColor;
	}

	/**
	 * 
	 * @param legColor
	 * 			The id to set.
	 */
	public void setLegColor(byte legColor) {
		this.legColor = legColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLegColor() {
		return this.legColor;
	}

	/**
	 * 
	 * @param feetColor
	 * 			The id to set.
	 */
	public void setFeetColor(byte feetColor) {
		this.feetColor = feetColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getFeetColor() {
		return this.feetColor;
	}

	/**
	 * 
	 * @param skinColor
	 * 			The id to set.
	 */
	public void setSkinColor(byte skinColor) {
		this.skinColor = skinColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getSkinColor() {
		return this.skinColor;
	}

	/**
	 * 
	 * @param gender
	 * 			The id to set.
	 */
	public void setGender(byte gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param chest
	 * 			The id to set.
	 */
	public void setChest(byte chest) {
		this.chest = chest;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getChest() {
		return this.chest;
	}

	/**
	 * 
	 * @param arms
	 * 			The id to set.
	 */
	public void setArms(byte arms) {
		this.arms = arms;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getArms() {
		return this.arms;
	}

	/**
	 * 
	 * @param head
	 * 			The id to set.
	 */
	public void setHead(byte head) {
		this.head = head;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getHead() {
		return this.head;
	}

	/**
	 * 
	 * @param hands
	 * 			The id to set.
	 */
	public void setHands(byte hands) {
		this.hands = hands;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getHands() {
		return this.hands;
	}

	/**
	 * 
	 * @param legs
	 * 			The id to set.
	 */
	public void setLegs(byte legs) {
		this.legs = legs;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLegs() {
		return this.legs;
	}

	/**
	 * 
	 * @param feet
	 * 			The id to set.
	 */
	public void setFeet(byte feet) {
		this.feet = feet;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getFeet() {
		return this.feet;
	}

	/**
	 * 
	 * @param beard
	 * 			The id to set.
	 */
	public void setBeard(byte beard) {
		this.beard = beard;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getBeard() {
		return this.beard;
	}
}