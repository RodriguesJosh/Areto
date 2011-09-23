package com.netty.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:36:45 PM
 */
public class Chat {

	/**
	 * 
	 */
	private String text;

	/**
	 * 
	 */
	private int effects;

	/**
	 * 
	 */
	private int color;

	/**
	 * 
	 * @param text
	 * 			The id to set.
	 * @param effects
	 * 			The id to set.
	 * @param color
	 * 			The id to set.
	 */
	public Chat(String text, int effects, int color) {
		this.setText(text);
		this.setEffects(effects);
		this.setColor(color);
	}

	/**
	 * 
	 * @param text
	 * 			The id to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * 
	 * @param effects
	 * 			The id to set.
	 */
	public void setEffects(int effects) {
		this.effects = effects;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getEffects() {
		return this.effects;
	}

	/**
	 * 
	 * @param color
	 * 			The id to set.
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getColor() {
		return this.color;
	}
}