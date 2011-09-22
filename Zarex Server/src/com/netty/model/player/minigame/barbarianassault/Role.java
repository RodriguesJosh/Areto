package com.netty.model.player.minigame.barbarianassault;

import java.awt.Color;

import com.netty.model.item.Item;

public enum Role {

	ATTACKER(Color.RED), COLLECTOR(Color.YELLOW), DEFENDER(Color.BLUE), HEALER(Color.GREEN);

	private Item[] lureFood;
	private Color color;
	private Role callRole;

	private Role(Color color) {
		this.setColor(color);
	}

	public void setLureFood(Item[] lureFood) {
		this.lureFood = lureFood;
	}

	public Item[] getLureFood() {
		return this.lureFood;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public void setCallRole(Role callRole) {
		this.callRole = callRole;
	}

	public Role getCallRole() {
		return this.callRole;
	}
}