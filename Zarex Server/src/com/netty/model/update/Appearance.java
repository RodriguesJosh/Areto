package com.netty.model.update;

public class Appearance {

	private byte gender;
	private byte chest;
	private byte arms;
	private byte legs;
	private byte head;
	private byte hands;
	private byte feet;
	private byte beard;
	private byte hairColor;
	private byte torsoColor;
	private byte legColor;
	private byte feetColor;
	private byte skinColor;

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

	public byte[] getAppearance() {
		return new byte[] {
				this.getGender(), this.getHairColor(), this.getTorsoColor(), this.getLegColor(), this.getFeetColor(),
				this.getSkinColor(), this.getHead(), this.getChest(), this.getArms(), this.getHands(), this.getLegs(),
				this.getFeet(), this.getBeard()
		};
	}

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

	public void setHairColor(byte hairColor) {
		this.hairColor = hairColor;
	}

	public byte getHairColor() {
		return this.hairColor;
	}

	public void setTorsoColor(byte torsoColor) {
		this.torsoColor = torsoColor;
	}

	public byte getTorsoColor() {
		return this.torsoColor;
	}

	public void setLegColor(byte legColor) {
		this.legColor = legColor;
	}

	public byte getLegColor() {
		return this.legColor;
	}

	public void setFeetColor(byte feetColor) {
		this.feetColor = feetColor;
	}

	public byte getFeetColor() {
		return this.feetColor;
	}

	public void setSkinColor(byte skinColor) {
		this.skinColor = skinColor;
	}

	public byte getSkinColor() {
		return this.skinColor;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setChest(byte chest) {
		this.chest = chest;
	}

	public byte getChest() {
		return this.chest;
	}

	public void setArms(byte arms) {
		this.arms = arms;
	}

	public byte getArms() {
		return this.arms;
	}

	public void setHead(byte head) {
		this.head = head;
	}

	public byte getHead() {
		return this.head;
	}

	public void setHands(byte hands) {
		this.hands = hands;
	}

	public byte getHands() {
		return this.hands;
	}

	public void setLegs(byte legs) {
		this.legs = legs;
	}

	public byte getLegs() {
		return this.legs;
	}

	public void setFeet(byte feet) {
		this.feet = feet;
	}

	public byte getFeet() {
		return this.feet;
	}

	public void setBeard(byte beard) {
		this.beard = beard;
	}

	public byte getBeard() {
		return this.beard;
	}
}