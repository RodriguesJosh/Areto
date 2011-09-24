package com.netty.model.player.minigame.barbarianassault;

import java.awt.Color;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:01:27 PM
 */
public enum Role {

	/**
	 * 
	 */
	ATTACKER(Color.RED),

	/**
	 * 
	 */
	COLLECTOR(Color.YELLOW),

	/**
	 * 
	 */
	DEFENDER(Color.BLUE),

	/**
	 * 
	 */
	HEALER(Color.GREEN);

	/**
	 * 
	 */
	private Item[] lureFood;

	/**
	 * 
	 */
	private Color color;

	/**
	 * 
	 */
	private Role callRole;

	/**
	 * 
	 * @param color
	 * 			The id to set.
	 */
	private Role(Color color) {
		this.setColor(color);
	}

	/**
	 * 
	 * @param lureFood
	 * 			The id to set.
	 */
	public void setLureFood(Item[] lureFood) {
		this.lureFood = lureFood;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item[] getLureFood() {
		return this.lureFood;
	}

	/**
	 * 
	 * @param color
	 * 			The id to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * 
	 * @param callRole
	 * 			The id to set.
	 */
	public void setCallRole(Role callRole) {
		this.callRole = callRole;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Role getCallRole() {
		return this.callRole;
	}
}