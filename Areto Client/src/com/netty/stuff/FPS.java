package com.netty.stuff;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:48:19 PM
 */
public class FPS {

	/**
	 * 
	 */
	private int fps;

	/**
	 * 
	 * @param fps
	 * 			The id to set.
	 */
	public FPS(int fps) {
		this.setFPS(fps);
	}

	/**
	 * 
	 * @param fps
	 * 			The id to set.
	 */
	public void setFPS(int fps) {
		this.fps = fps;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getFPS() {
		return this.fps;
	}
}