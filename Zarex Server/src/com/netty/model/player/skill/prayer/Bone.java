package com.netty.model.player.skill.prayer;

public enum Bone {

	NORMAL_BONES(0, 4, false), WOLF_BONES(0, 4, true), BURNT_BONES(0, 4, false), MONKEY_BONES(0, 5, false), MONKEY_ZOMBIE_BONES(0, 5, true),
	BAT_BONES(0, 5, false), BIG_BONES(0, 15, false), JOGRE_BONES(0, 15, true), LARGE_MONKEY_BONES(0, 18, true), ZOGRE_BONES(0, 22, true),
	SHAIKAHAN_BONES(0, 25, true), BABY_DRAGON_BONES(0, 30, true), WYVERN_BONES(0, 50, true), DRAGON_BONES(0, 72, false), FAYRG_BONES(0, 84, true),
	RAURG_BONES(0, 96, true), DAGANNOTH_BONES(0, 125, true), OURG_BONES(0, 140, true), FROST_DRAGON_BONES(0, 180, true), ANCIENT_BONES(0, 200, false);

	private int id;
	private int experience;
	private boolean isMember;
	private int animationID;

	private Bone(int id, int experience, boolean isMember) {
		this.setID(id);
		this.setExperience(experience);
		this.setMember(isMember);
		this.setAnimationID(0);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public boolean isMember() {
		return this.isMember;
	}

	public void setAnimationID(int animationID) {
		this.animationID = animationID;
	}

	public int getAnimationID() {
		return this.animationID;
	}
}