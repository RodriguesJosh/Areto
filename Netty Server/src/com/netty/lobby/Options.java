package com.netty.lobby;

import com.netty.lobby.settings.AnimatedBackground;
import com.netty.lobby.settings.Quality;
import com.netty.lobby.settings.ScreenSize;
import com.netty.lobby.settings.Volume;

public class Options {

	private Quality quality;
	private ScreenSize screenSize;
	private Volume volume;
	private AnimatedBackground animatedBackground;

	public Options(Quality quality, ScreenSize screenSize, Volume volume, AnimatedBackground animatedBackground) {
		this.setQuality(quality);
		this.setScreenSize(screenSize);
		this.setVolume(volume);
		this.setAnimatedBackground(animatedBackground);
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public Quality getQuality() {
		return this.quality;
	}

	public void setScreenSize(ScreenSize screenSize) {
		this.screenSize = screenSize;
	}

	public ScreenSize getScreenSize() {
		return this.screenSize;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public Volume getVolume() {
		return this.volume;
	}

	public void setAnimatedBackground(AnimatedBackground animatedBackground) {
		this.animatedBackground = animatedBackground;
	}

	public AnimatedBackground getAnimatedBackground() {
		return this.animatedBackground;
	}
}