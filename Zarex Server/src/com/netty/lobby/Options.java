package com.netty.lobby;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;
import com.netty.lobby.options.AnimatedBackground;
import com.netty.lobby.options.Quality;
import com.netty.lobby.options.ScreenSize;
import com.netty.lobby.options.Volume;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:45:23 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class Options {

	/**
	 * The type of quality you wish to use.
	 */
	private Quality quality;

	/**
	 * The type of screen size you wish to
	 * use.
	 */
	private ScreenSize screenSize;

	/**
	 * The volume of the music/sounds from
	 * the client.
	 */
	private Volume volume;

	/**
	 * An animated background for the client.
	 */
	private AnimatedBackground animatedBackground;

	/**
	 * 
	 * 
	 * @param quality
	 * 			The quality to set.
	 * @param screenSize
	 * 			The screen size to set.
	 * @param volume
	 * 			The volume to set.
	 * @param animatedBackground
	 * 			The animated background to set.
	 */
	public Options(Quality quality, ScreenSize screenSize, Volume volume, AnimatedBackground animatedBackground) {
		this.setQuality(quality);
		this.setScreenSize(screenSize);
		this.setVolume(volume);
		this.setAnimatedBackground(animatedBackground);
	}

	/**
	 * 
	 * 
	 * @param quality
	 * 			The quality to set.
	 */
	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			Returns the quality.
	 */
	public Quality getQuality() {
		return this.quality;
	}

	/**
	 * 
	 * 
	 * @param screenSize
	 * 			The screen size to set.
	 */
	public void setScreenSize(ScreenSize screenSize) {
		this.screenSize = screenSize;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			Returns the screen size.
	 */
	public ScreenSize getScreenSize() {
		return this.screenSize;
	}

	/**
	 * 
	 * 
	 * @param volume
	 * 			The volume to set.
	 */
	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			Returns the volume.
	 */
	public Volume getVolume() {
		return this.volume;
	}

	/**
	 * 
	 * 
	 * @param animatedBackground
	 * 			The animated background to set.
	 */
	public void setAnimatedBackground(AnimatedBackground animatedBackground) {
		this.animatedBackground = animatedBackground;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			Returns the animated background.
	 */
	public AnimatedBackground getAnimatedBackground() {
		return this.animatedBackground;
	}
}