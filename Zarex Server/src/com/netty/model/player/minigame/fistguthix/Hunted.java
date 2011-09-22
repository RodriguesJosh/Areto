package com.netty.model.player.minigame.fistguthix;

import java.util.concurrent.TimeUnit;

import com.netty.model.player.Player;
import com.netty.model.player.tab.equipment.Equipment;
import com.netty.util.Constants;
import com.netty.util.Execution;
import com.netty.util.Timing;

public class Hunted implements Runnable {

	private Player player;
	private int chargesGained;
	private Timing time;

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

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setChargesGained(int chargesGained) {
		this.chargesGained = chargesGained;
	}

	public int getChargesGained() {
		return this.chargesGained;
	}

	public void setTime(Timing time) {
		this.time = time;
	}

	public Timing getTime() {
		return this.time;
	}

	@Override
	public void run() {
		this.setChargesGained(this.getChargesGained() + 3);
	}
}