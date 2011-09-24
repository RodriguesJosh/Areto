package com.netty.model.player.minigame.fistguthix;

import java.util.concurrent.TimeUnit;

import com.netty.model.player.Player;
import com.netty.model.player.tab.equipment.Equipment;
import com.netty.util.Constants;
import com.netty.util.Execution;
import com.netty.util.Timing;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:44:32 PM
 */
public class Hunted implements Runnable {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private int chargesGained;

	/**
	 * 
	 */
	private Timing time;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public Hunted(Player player) {
		this.setPlayer(player);
		this.setChargesGained(0);
		this.getPlayer().getEquipment();
		if (Equipment.getSlotWeapon() == 1000) { /** Stone of Power item goes here. */
			Execution.getScheduledExecutorService().scheduleAtFixedRate(this, 0, 1000, TimeUnit.MILLISECONDS);
			if (this.getChargesGained() == Constants.MAX_STONE_POWER_CHARGES) {
				return;
			}
			if (Equipment.getSlotWeapon() != 1000) { /** Stone of Power item goes here. */
				return;
			}
		}
	}

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param chargesGained
	 *			The id to set.
	 */
	public void setChargesGained(int chargesGained) {
		this.chargesGained = chargesGained;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getChargesGained() {
		return this.chargesGained;
	}

	/**
	 * 
	 * @param time
	 *			The id to set.
	 */
	public void setTime(Timing time) {
		this.time = time;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Timing getTime() {
		return this.time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.setChargesGained(this.getChargesGained() + 3);
	}
}