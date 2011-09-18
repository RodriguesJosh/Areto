package com.netty.model.player.skill.woodcutting;

public enum Hatchet {

	BRONZE(1349, 879, 1), IRON(1351, 877, 1), STEEL(1353, 875, 6), BLACK(1351, 873, 6), MITHRIL(1355, 871, 21), ADAMANT(1357, 869, 31),
	RUNE(1359, 867, 41), DRAGON(6739, 2846, 61);

	private int hatchetID;
	private int animationID;
	private int level;

	private Hatchet(int hatchetID, int animationID, int level) {
		this.setHatchetID(hatchetID);
		this.setAnimationID(animationID);
		this.setLevel(level);
	}

	public void setHatchetID(int hatchetID) {
		this.hatchetID = hatchetID;
	}

	public int getHatchetID() {
		return this.hatchetID;
	}

	public void setAnimationID(int animationID) {
		this.animationID = animationID;
	}

	public int getAnimationID() {
		return this.animationID;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}