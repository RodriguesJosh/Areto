package com.netty.model.player.quest.deserttreasure;

import com.netty.model.item.Item;

public class Diamond {

	private Boss boss;
	private Item diamondItem;

	public Diamond(Boss boss) {
		this.setBoss(boss);
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Boss getBoss() {
		return this.boss;
	}

	public void setDiamondItem(Item diamondItem) {
		this.diamondItem = diamondItem;
	}

	public Item getDiamondItem() {
		return this.diamondItem;
	}
}