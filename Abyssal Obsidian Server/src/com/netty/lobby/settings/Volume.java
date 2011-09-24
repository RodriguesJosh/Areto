package com.netty.lobby.settings;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 8:15:52 PM
 */
public class Volume {

	/**
	 * 
	 */
	private int music;

	/**
	 * 
	 */
	private int soundEffects;

	/**
	 * 
	 */
	private int areaSounds;

	/**
	 * 
	 * 
	 * @param music
	 * 			The id to set.
	 * @param soundEffects
	 * 			The id to set.
	 * @param areaSounds
	 * 			The id to set.
	 */
	public Volume(int music, int soundEffects, int areaSounds) {
		this.setMusic(music);
		this.setSoundEffects(soundEffects);
		this.setAreaSounds(areaSounds);
	}

	/**
	 * 
	 * 
	 * @param music
	 * 			The id to set.
	 */
	public void setMusic(int music) {
		this.music = music;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getMusic() {
		return this.music;
	}

	/**
	 * 
	 * 
	 * @param soundEffects
	 * 			The id to set.
	 */
	public void setSoundEffects(int soundEffects) {
		this.soundEffects = soundEffects;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getSoundEffects() {
		return this.soundEffects;
	}

	/**
	 * 
	 * 
	 * @param areaSounds
	 * 			The id to set.
	 */
	public void setAreaSounds(int areaSounds) {
		this.areaSounds = areaSounds;
	}

	/**
	 * 
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAreaSounds() {
		return this.areaSounds;
	}
}