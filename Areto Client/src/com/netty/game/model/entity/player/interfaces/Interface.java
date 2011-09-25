package com.netty.game.model.entity.player.interfaces;

import com.netty.game.graphics.image.RGBImage;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:49:20 PM
 */
public class Interface {

	/**
	 * 
	 */
	private String[] text;

	/**
	 * 
	 */
	private RGBImage[] rgbImages;

	/**
	 * 
	 */
	private InterfaceLocation interfaceLocation;

	/**
	 * 
	 * @param text
	 * 			The id to set.
	 */
	public void setText(String[] text) {
		this.text = text;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String[] getText() {
		return this.text;
	}

	/**
	 * 
	 * @param rgbImages
	 * 			The id to set.
	 */
	public void setRGBImages(RGBImage[] rgbImages) {
		this.rgbImages = rgbImages;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RGBImage[] getRGBImages() {
		return this.rgbImages;
	}

	/**
	 * 
	 * @param interfaceLocation
	 * 			The id to set.
	 */
	public void setInterfaceLocation(InterfaceLocation interfaceLocation) {
		this.interfaceLocation = interfaceLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public InterfaceLocation getInterfaceLocation() {
		return this.interfaceLocation;
	}
}