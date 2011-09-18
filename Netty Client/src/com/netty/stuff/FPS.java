package com.netty.stuff;

public class FPS {

	private int fps;

	public FPS(int fps) {
		this.setFPS(fps);
	}

	public void setFPS(int fps) {
		this.fps = fps;
	}

	public int getFPS() {
		return this.fps;
	}
}