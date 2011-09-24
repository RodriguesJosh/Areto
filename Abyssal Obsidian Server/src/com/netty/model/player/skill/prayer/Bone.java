package com.netty.model.player.skill.prayer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:44:44 AM
 */
public enum Bone {

	/**
	 * 
	 */
	NORMAL_BONES(0, 4, false),

	/**
	 * 
	 */
	WOLF_BONES(0, 4, true),

	/**
	 * 
	 */
	BURNT_BONES(0, 4, false),

	/**
	 * 
	 */
	MONKEY_BONES(0, 5, false),

	/**
	 * 
	 */
	MONKEY_ZOMBIE_BONES(0, 5, true),

	/**
	 * 
	 */
	BAT_BONES(0, 5, false),

	/**
	 * 
	 */
	BIG_BONES(0, 15, false),

	/**
	 * 
	 */
	JOGRE_BONES(0, 15, true),

	/**
	 * 
	 */
	LARGE_MONKEY_BONES(0, 18, true),

	/**
	 * 
	 */
	ZOGRE_BONES(0, 22, true),

	/**
	 * 
	 */
	SHAIKAHAN_BONES(0, 25, true),

	/**
	 * 
	 */
	BABY_DRAGON_BONES(0, 30, true),

	/**
	 * 
	 */
	WYVERN_BONES(0, 50, true),

	/**
	 * 
	 */
	DRAGON_BONES(0, 72, false),

	/**
	 * 
	 */
	FAYRG_BONES(0, 84, true),

	/**
	 * 
	 */
	RAURG_BONES(0, 96, true),

	/**
	 * 
	 */
	DAGANNOTH_BONES(0, 125, true),

	/**
	 * 
	 */
	OURG_BONES(0, 140, true),

	/**
	 * 
	 */
	FROST_DRAGON_BONES(0, 180, true),

	/**
	 * 
	 */
	ANCIENT_BONES(0, 200, false);

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private boolean isMember;

	/**
	 * 
	 */
	private int animationID;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 * @param isMember
	 * 			The id to set.
	 */
	private Bone(int id, int experience, boolean isMember) {
		this.setID(id);
		this.setExperience(experience);
		this.setMember(isMember);
		this.setAnimationID(0);
	}

	/**
	 * 
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getExperience() {
		return this.experience;
	}

	/**
	 * 
	 * 
	 * @param isMember
	 * 			The id to set.
	 */
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMember() {
		return this.isMember;
	}

	/**
	 * 
	 * @param animationID
	 * 			The id to set.
	 */
	public void setAnimationID(int animationID) {
		this.animationID = animationID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAnimationID() {
		return this.animationID;
	}
}