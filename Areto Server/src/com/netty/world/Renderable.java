package com.netty.world;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:59:30 AM
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