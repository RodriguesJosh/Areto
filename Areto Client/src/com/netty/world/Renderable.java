package com.netty.world;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:51:06 PM
 */
public interface Renderable {

	/**
	 * 
	 * @param renderable
	 * 			The id to set.
	 */
	public void render(Renderable renderable);

	/**
	 * 
	 * @param renderable
	 * 			The id to set.
	 */
	public void unrender(Renderable renderable);
}