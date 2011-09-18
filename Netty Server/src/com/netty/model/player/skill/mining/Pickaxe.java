package com.netty.model.player.skill.mining;

public enum Pickaxe {

	BRONZE(1349, 879, 1), IRON(1351, 877, 1), STEEL(1353, 875, 6), MITHRIL(1355, 871, 21), ADAMANT(1357, 869, 31), RUNE(1359, 867, 41),
	DRAGON(6739, 2846, 61), SACRED_CLAY(0, 0, 40), INFERNO_ADZE(0, 0, 41);

	private int pickaxeID;
	private int animationID;
	private int level;

	private Pickaxe(int pickaxeID, int animationID, int level) {
		this.setPickaxeID(pickaxeID);
		this.setAnimationID(animationID);
		this.setLevel(level);
	}

	public void setPickaxeID(int pickaxeID) {
		this.pickaxeID = pickaxeID;
	}

	public int getPickaxeID() {
		return this.pickaxeID;
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