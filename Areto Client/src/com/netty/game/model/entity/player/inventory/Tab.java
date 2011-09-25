package com.netty.game.model.entity.player.inventory;

import com.netty.game.graphics.image.RGBImage;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:53:38 PM
 */
public class Tab {

	/**
	 * 
	 */
	private short id;

	/**
	 * 
	 */
	private RGBImage tabRGBImage;

	/**
	 * 
	 */
	private RGBImage clickedTabRGBImage;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public Tab(short id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(short id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getID() {
		return this.id;
	}

	/**
	 * 
	 * @param tabRGBImage
	 * 			The id to set.
	 */
	public void setTabRGBImage(RGBImage tabRGBImage) {
		this.tabRGBImage = tabRGBImage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RGBImage getTabRGBImage() {
		return this.tabRGBImage;
	}

	/**
	 * 
	 * @param clickedTabRGBImage
	 * 			The id to set.
	 */
	public void setClickedTabRGBImage(RGBImage clickedTabRGBImage) {
		this.clickedTabRGBImage = clickedTabRGBImage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RGBImage getClickedTabRGBImage() {
		return this.clickedTabRGBImage;
	}
}