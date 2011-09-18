package com.netty.game.model.entity.player.chat;

public enum ChatColor {

	YELLOW(0), RED(1), GREEN(2), CYAN(3), PURPLE(4), WHITE(5), FLASH_ONE(6), FLASH_TWO(7), FLASH_THREE(8),
	GLOW_ONE(9), GLOW_TWO(10), GLOW_THREE(11);

	private int id;

	private ChatColor(int id) {
		this.setID(id);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}
}