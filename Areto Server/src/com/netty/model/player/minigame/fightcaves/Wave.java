package com.netty.model.player.minigame.fightcaves;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:41:08 PM
 */
public class Wave {

	/**
	 * 
	 */
	private Monster[] monsters;

	/**
	 * 
	 * @param monsters
	 *			The id to set.
	 */
	public Wave(Monster... monsters) {
		this.setMonsters(monsters);
	}

	/**
	 * 
	 * @param monsters
	 *			The id to set.
	 */
	public void setMonsters(Monster... monsters) {
		this.monsters = monsters;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Monster[] getMonsters() {
		return this.monsters;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public boolean isFinished() {
		for (Monster monster : this.getMonsters()) {
			return monster.getNPC().isDead();
		}
		return false;
	}
}