package com.netty.model.player.skill.runecrafting;

import com.netty.model.item.Item;

public enum Talisman {

	AIR_TALISMAN, MIND_TALISMAN, WATER_TALISMAN, EARTH_TALISMAN, FIRE_TALISMAN, BODY_TALISMAN, COSMIC_TALISMAN, CHAOS_TALISMAN, NATURE_TALISMAN,
	LAW_TALISMAN, DEATH_TALISMAN, BLOOD_TALISMAN, SOUL_TALISMAN, ELEMENTAL_TALISMAN, OMNI_TALISMAN;

	private Item item;
	private boolean isMembers;

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
}