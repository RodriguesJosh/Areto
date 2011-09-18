package com.netty.model.player.eat;

import com.netty.model.update.Animation;

public class Eat {

	private Food food;
	private Animation animation;

	public Eat(Food food) {
		this.setFood(food);
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Food getFood() {
		return this.food;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Animation getAnimation() {
		return this.animation;
	}
}