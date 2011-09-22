package com.netty.game.model.entity.player.interfaces;

import com.netty.game.graphics.image.RGBImage;

public class Interface {

	private String[] text;
	private RGBImage[] rgbImages;
	private InterfaceLocation interfaceLocation;

	public void setText(String[] text) {
		this.text = text;
	}

	public String[] getText() {
		return this.text;
	}

	public void setRGBImages(RGBImage[] rgbImages) {
		this.rgbImages = rgbImages;
	}

	public RGBImage[] getRGBImages() {
		return this.rgbImages;
	}

	public void setInterfaceLocation(InterfaceLocation interfaceLocation) {
		this.interfaceLocation = interfaceLocation;
	}

	public InterfaceLocation getInterfaceLocation() {
		return this.interfaceLocation;
	}
}