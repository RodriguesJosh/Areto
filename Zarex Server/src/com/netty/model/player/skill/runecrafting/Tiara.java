package com.netty.model.player.skill.runecrafting;

import com.netty.model.item.Item;

public enum Tiara {

	AIR_TIARA, MIND_TIARA, WATER_TIARA, EARTH_TIARA, FIRE_TIARA, BODY_TIARA, COSMIC_TIARA, CHAOS_TIARA, NATURE_TIARA, LAW_TIARA, DEATH_TIARA,
	BLOOD_TIARA, SOUL_TIARA, OMNI_TIARA;

	private Item item;
	private boolean isMembers;
	private int experience;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setMembers(boolean isMembers) {
		this.isMembers = isMembers;
	}

	public boolean isMembers() {
		return this.isMembers;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}
}