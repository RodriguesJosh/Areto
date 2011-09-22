package com.netty.model.player.skill.prayer;

import com.netty.model.player.Player;
import com.netty.model.update.Animation;

public class Prayer {

	private PrayerType prayerType;
	private CursePrayerType cursePrayerType;
	private Ectofuntus ectofuntus;

	public Prayer(Ectofuntus ectofuntus) {
		this.setPrayerType(PrayerType.NONE);
		this.setCursePrayerType(CursePrayerType.NONE);
		this.setEctofuntus(ectofuntus);
	}

	public void execute(Player player, int boneID) {
		Bone bone = this.getBone(boneID);
		if (player.getEquipment().containsItem(boneID)) {
			player.setAnimation(new Animation(bone.getAnimationID(), 0));
		}
	}

	public void switchPrayer(PrayerType prayerType) {
		switch (prayerType) {
		case NONE:
			break;
		case THICK_SKIN:
			if ((PrayerType.ROCK_SKIN.getID() != -1) && (PrayerType.STEEL_SKIN.getID() != -1)) {
				PrayerType.ROCK_SKIN.setID((byte) -1);
				PrayerType.STEEL_SKIN.setID((byte) -1);
			}
			break;
		case BURST_OF_STRENGTH:
			if ((PrayerType.SUPERHUMAN_STRENGTH.getID() != -1) && (PrayerType.ULTIMATE_STRENGTH.getID() != -1)) {
				PrayerType.SUPERHUMAN_STRENGTH.setID((byte) -1);
				PrayerType.ULTIMATE_STRENGTH.setID((byte) -1);
			}
			break;
		case CLARITY_OF_THOUGHT:
			if ((PrayerType.IMPROVED_REFLEXES.getID() != -1) && (PrayerType.INCREDIBLE_REFLEXES.getID() != -1)) {
				PrayerType.IMPROVED_REFLEXES.setID((byte) -1);
				PrayerType.INCREDIBLE_REFLEXES.setID((byte) -1);
			}
			break;
		case ROCK_SKIN:
			if ((PrayerType.THICK_SKIN.getID() != -1) && (PrayerType.STEEL_SKIN.getID() != -1)) {
				PrayerType.THICK_SKIN.setID((byte) -1);
				PrayerType.STEEL_SKIN.setID((byte) -1);
			}
			break;
		case SUPERHUMAN_STRENGTH:
			if ((PrayerType.BURST_OF_STRENGTH.getID() != -1) && (PrayerType.ULTIMATE_STRENGTH.getID() != 1)) {
				PrayerType.BURST_OF_STRENGTH.setID((byte) -1);
				PrayerType.ULTIMATE_STRENGTH.setID((byte) -1);
			}
			break;
		case IMPROVED_REFLEXES:
			if (PrayerType.CLARITY_OF_THOUGHT.getID() != -1) {
				PrayerType.CLARITY_OF_THOUGHT.setID((byte) -1);
			}
			break;
		case RAPID_RESTORE:
			break;
		case RAPID_HEAL:
			break;
		case PROTECT_ITEM:
			break;
		case STEEL_SKIN:
			if ((PrayerType.THICK_SKIN.getID() != -1) && (PrayerType.ROCK_SKIN.getID() != -1)) {
				PrayerType.THICK_SKIN.setID((byte) -1);
				PrayerType.ROCK_SKIN.setID((byte) -1);
			}
			break;
		case ULTIMATE_STRENGTH:
			if ((PrayerType.BURST_OF_STRENGTH.getID() != -1) && (PrayerType.SUPERHUMAN_STRENGTH.getID() != -1)) {
				PrayerType.BURST_OF_STRENGTH.setID((byte) -1);
				PrayerType.SUPERHUMAN_STRENGTH.setID((byte) -1);
			}
			break;
		case INCREDIBLE_REFLEXES:
			break;
		case PROTECT_FROM_MAGIC:
			break;
		case PROTECT_FROM_MISSILES:
			break;
		case PROTECT_FROM_MELEE:
			break;
		case RETRIBUTION:
			break;
		case REDEMPTION:
			break;
		case SMITE:
			break;
		}
	}

	public void switchCursePrayer(CursePrayerType cursePrayerType) {
		switch (cursePrayerType) {

		}
	}

	private Bone getBone(int boneID) {
		int[] boneIDs = { 0 };
		Bone[] boneTypes = {
				Bone.ANCIENT_BONES, Bone.BABY_DRAGON_BONES, Bone.BAT_BONES, Bone.BIG_BONES, Bone.BURNT_BONES,
				Bone.DAGANNOTH_BONES, Bone.DRAGON_BONES, Bone.FAYRG_BONES, Bone.FROST_DRAGON_BONES, Bone.JOGRE_BONES,
				Bone.LARGE_MONKEY_BONES, Bone.MONKEY_BONES, Bone.MONKEY_BONES, Bone.MONKEY_ZOMBIE_BONES,
				Bone.OURG_BONES, Bone.RAURG_BONES, Bone.SHAIKAHAN_BONES, Bone.WOLF_BONES, Bone.WYVERN_BONES,
				Bone.ZOGRE_BONES
		};
		for (int i : boneIDs) {
			if (boneID == i) {
				return boneTypes[i];
			}
		}
		return Bone.NORMAL_BONES;
	}

	public void setPrayerType(PrayerType prayerType) {
		this.prayerType = prayerType;
	}

	public PrayerType getPrayerType() {
		return this.prayerType;
	}

	public void setCursePrayerType(CursePrayerType cursePrayerType) {
		this.cursePrayerType = cursePrayerType;
	}

	public CursePrayerType getCursePrayerType() {
		return this.cursePrayerType;
	}

	public void setEctofuntus(Ectofuntus ectofuntus) {
		this.ectofuntus = ectofuntus;
	}

	public Ectofuntus getEctofuntus() {
		return this.ectofuntus;
	}
}