package com.netty.game.model.entity.player.inventory;

import com.netty.game.graphics.image.RGBImage;

public class Tab {

	private short id;
	private RGBImage tabRGBImage;
	private RGBImage clickedTabRGBImage;

	public Tab(short id) {
		this.setID(id);
	}

	public void setID(short id) {
		this.id = id;
	}

	public short getID() {
		return this.id;
	}

	public void setTabRGBImage(RGBImage tabRGBImage) {
		this.tabRGBImage = tabRGBImage;
	}

	public RGBImage getTabRGBImage() {
		return this.tabRGBImage;
	}

	public void setClickedTabRGBImage(RGBImage clickedTabRGBImage) {
		this.clickedTabRGBImage = clickedTabRGBImage;
	}

	public RGBImage getClickedTabRGBImage() {
		return this.clickedTabRGBImage;
	}
}