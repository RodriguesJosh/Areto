package com.netty.model.combat.magic;

import com.netty.model.update.Animation;
import com.netty.model.update.Graphic;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:34:23 AM
 */
public abstract class Spell {

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Animation getAnimation();
	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Graphic getGraphic();
}