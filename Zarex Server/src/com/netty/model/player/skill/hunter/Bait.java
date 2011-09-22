package com.netty.model.player.skill.hunter;

import com.netty.model.item.Item;

public enum Bait {

	TRACK, SNARE, BUTTERFLY_NET_AND_JAR, DEADFALL, BOXTRAP, FERRET_AND_RABBIT_SNARE, NET_TRAP, PITFALL, FALCONRY, NOOSE_WAND, MAGIC_BOX, RAW_MEAT,
	RAW_RAINBOWFISH, BARLEY, SMOUDLERING_FEVER_GRASS_LURE, RAW_COD_BAIT, BANANA, SMOULDERING_LAVENDER_LURE, SPICY_CHOPPED_TOMATO, RAW_COD,
	SPICY_MINCED_MEAT, PAPAYA, RAW_PAPAYA_MEAT, NUTS, GUAM_TAR, MARRENTILL_TAR, TARROMIN_TAR, HARRALANDER_TAR, MAGICAL_BEAD, SPRITE_LURE;

	private Item item;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}
}