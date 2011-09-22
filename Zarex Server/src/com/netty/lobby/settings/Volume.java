package com.netty.lobby.settings;

public class Volume {

	private int music;
	private int soundEffects;
	private int areaSounds;

	public Volume(int music, int soundEffects, int areaSounds) {
		this.setMusic(music);
		this.setSoundEffects(soundEffects);
		this.setAreaSounds(areaSounds);
	}

	public void setMusic(int music) {
		this.music = music;
	}

	public int getMusic() {
		return this.music;
	}

	public void setSoundEffects(int soundEffects) {
		this.soundEffects = soundEffects;
	}

	public int getSoundEffects() {
		return this.soundEffects;
	}

	public void setAreaSounds(int areaSounds) {
		this.areaSounds = areaSounds;
	}

	public int getAreaSounds() {
		return this.areaSounds;
	}
}