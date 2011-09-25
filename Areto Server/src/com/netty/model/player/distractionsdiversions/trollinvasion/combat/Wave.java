package com.netty.model.player.distractionsdiversions.trollinvasion.combat;

import com.netty.model.player.distractionsdiversions.trollinvasion.EnemyTrolls;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 4:46:53 PM
 */
public class Wave {

	/**
	 * 
	 */
	private EnemyTrolls[] enemyTrolls;

	/**
	 * 
	 * @param enemyTrolls
	 * 			The enemyTrolls to set.
	 */
	public void setEnemyTrolls(EnemyTrolls[] enemyTrolls) {
		this.enemyTrolls = enemyTrolls;
	}

	/**
	 * 
	 * @return enemyTrolls
	 * 			Returns the enemyTrolls to get.
	 */
	public EnemyTrolls[] getEnemyTrolls() {
		return this.enemyTrolls;
	}
}