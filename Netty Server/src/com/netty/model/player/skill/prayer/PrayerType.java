package com.netty.model.player.skill.prayer;

import com.netty.model.player.skill.SkillType;

public enum PrayerType {

	NONE((byte) -1), THICK_SKIN((byte) 0), BURST_OF_STRENGTH((byte) 1), CLARITY_OF_THOUGHT((byte) 2), ROCK_SKIN((byte) 3), SUPERHUMAN_STRENGTH((byte) 4), IMPROVED_REFLEXES((byte) 5), RAPID_RESTORE((byte) 6),
	RAPID_HEAL((byte) 7), PROTECT_ITEM((byte) 8), STEEL_SKIN((byte) 9), ULTIMATE_STRENGTH((byte) 10), INCREDIBLE_REFLEXES((byte) 11), PROTECT_FROM_MAGIC((byte) 12), PROTECT_FROM_MISSILES((byte) 13),
	PROTECT_FROM_MELEE((byte) 14), RETRIBUTION((byte) 15), REDEMPTION((byte) 16), SMITE((byte) 17);

	private byte id;
	private SkillType skillType;
	private byte percentage;

	private PrayerType(byte id) {
		this.setID(id);
		this.setSkillType(SkillType.ATTACK);
		this.setPercentage((byte) 0);
	}

	public void setID(byte  id) {
		this.id = id;
	}

	public byte getID() {
		return this.id;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public SkillType getSkillType() {
		return this.skillType;
	}

	public void setPercentage(byte percentage) {
		this.percentage = percentage;
	}

	public byte getPercentage() {
		return this.percentage;
	}
}