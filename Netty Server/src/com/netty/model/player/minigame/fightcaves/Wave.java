package com.netty.model.player.minigame.fightcaves;

public class Wave {

	private Monster[] monsters;

	public Wave(Monster... monsters) {
		this.setMonsters(monsters);
	}

	public void setMonsters(Monster... monsters) {
		this.monsters = monsters;
	}

	public Monster[] getMonsters() {
		return this.monsters;
	}

	public boolean isFinished() {
		for (Monster monster : this.getMonsters()) {
			return monster.getNPC().isDead();
		}
		return false;
	}
}