package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.agility;

import com.netty.model.update.Animation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 2:15:34 PM
 */
public enum TightropeTricks {

	/**
	 * 
	 */
	SMALL_HOP,

	/**
	 * 
	 */
	ONE_LEG_BALANCE,

	/**
	 * 
	 */
	TWIRL,

	/**
	 * 
	 */
	HANDSTAND,

	/**
	 * 
	 */
	CARTWHEEL,

	/**
	 * 
	 */
	SMALL_LEAP,

	/**
	 * 
	 */
	NO_HAND_CARTWHEEL,

	/**
	 * 
	 */
	FORWARD_ROLL,

	/**
	 * 
	 */
	LARGE_LEAP,

	/**
	 * 
	 */
	BACKFLIP,

	/**
	 * 
	 */
	JUGGLE;

	/**
	 * 
	 */
	private Animation animation;

	/**
	 * 
	 * @param animation
	 * 			The animation to set.
	 */
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	/**
	 * 
	 * @return animation
	 * 			Returns the animation to get.
	 */
	public Animation getAnimation() {
		return this.animation;
	}
}