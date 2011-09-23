package com.netty.lobby.options;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:30:49 PM
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
	 * 			The music to set.
	 * @param soundEffects
	 * 			The sound effects to set.
	 * @param areaSounds
	 * 			The area sounds to set.
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
	 * 			The music to set.
	 */
	public void setMusic(int music) {
		this.music = music;
	}

	/**
	 * 
	 * 
	 * @return music
	 */
	public int getMusic() {
		return this.music;
	}

	/**
	 * 
	 * 
	 * @param soundEffects
	 * 			The sound effects to set.
	 */
	public void setSoundEffects(int soundEffects) {
		this.soundEffects = soundEffects;
	}

	/**
	 * 
	 * 
	 * @return soundEffects
	 */
	public int getSoundEffects() {
		return this.soundEffects;
	}

	/**
	 * 
	 * 
	 * @param areaSounds
	 * 			The area sounds to set.
	 */
	public void setAreaSounds(int areaSounds) {
		this.areaSounds = areaSounds;
	}

	/**
	 * 
	 * 
	 * @return areaSounds
	 */
	public int getAreaSounds() {
		return this.areaSounds;
	}
}