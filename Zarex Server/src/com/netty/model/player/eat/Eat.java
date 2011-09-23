package com.netty.model.player.eat;

import com.netty.model.update.Animation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:50:49 PM
 */
public class Eat {

	/**
	 * 
	 */
	private Food food;

	/**
	 * 
	 */
	private Animation animation;

	/**
	 * 
	 * @param food
	 * 			The id to set.
	 */
	public Eat(Food food) {
		this.setFood(food);
	}

	/**
	 * 
	 * @param food
	 * 			The id to set.
	 */
	public void setFood(Food food) {
		this.food = food;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Food getFood() {
		return this.food;
	}

	/**
	 * 
	 * @param animation
	 * 			The id to set.
	 */
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Animation getAnimation() {
		return this.animation;
	}
}