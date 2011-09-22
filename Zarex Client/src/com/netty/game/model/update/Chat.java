package com.netty.game.model.update;

public class Chat {

	private String text;
	private int effects;
	private int color;

	public Chat(String text, int effects, int color) {
		this.setText(text);
		this.setEffects(effects);
		this.setColor(color);
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setEffects(int effects) {
		this.effects = effects;
	}

	public int getEffects() {
		return this.effects;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getColor() {
		return this.color;
	}
}