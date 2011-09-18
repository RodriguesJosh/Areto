package com.netty.model.player.skill.smithing;

import com.netty.model.item.Item;

public enum Forging {

	DAGGER, AXE, CHAIN_BODY, MEDIUM_HELM, DART_TIPS, BOLTS, SWORD, MACE, PLATE_LEGS, FULL_HELM, ARROWTIPS, LIMBS, SCIMITAR, WARHAMMER, PLATE_SKIRT,
	SQUARE_SHIELD, THROWING_KNIVES, LONG_SWORD, BATTLE_AXE, PLATE_BODY, KITE_SHIELD, STUDS, TWO_HAND_SWORD, CLAWS, BULLSEYE_LANTERN, NAILS;

	private Item item;
	private int level;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}