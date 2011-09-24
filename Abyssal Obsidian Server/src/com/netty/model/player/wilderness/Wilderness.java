package com.netty.model.player.wilderness;

import com.netty.model.object.impl.Obelisk;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:45:57 PM
 */
public class Wilderness {

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private Skull skull;

	/**
	 * 
	 */
	private Revenant[] revenants;

	/**
	 * 
	 */
	private Obelisk[] obelisks;

	/**
	 * 
	 */
	public Wilderness() {
		this.setLevel(0);
		this.setSkull(null);
		this.setRevenants(new Revenant[] {
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0)),
				new Revenant(World.getWorld().getNPCList().get(0))
		});
		this.setObelisks(new Obelisk[] {
				new Obelisk(0, (byte) 1, (byte) 10),
				new Obelisk(0, (byte) 2, (byte) 10)
		});
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param skull
	 * 			The id to set.
	 */
	public void setSkull(Skull skull) {
		this.skull = skull;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Skull getSkull() {
		return this.skull;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isSkulling() {
		return this.getSkull() != null;
	}

	/**
	 * 
	 */
	public void resetSkull() {
		this.setSkull(null);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isSkulled() {
		return this.getSkull() != null;
	}

	/**
	 * 
	 * @param revenants
	 * 			The id to set.
	 */
	public void setRevenants(Revenant[] revenants) {
		this.revenants = revenants;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Revenant[] getRevenants() {
		return this.revenants;
	}

	/**
	 * 
	 * @param obelisks
	 * 			The id to set.
	 */
	public void setObelisks(Obelisk[] obelisks) {
		this.obelisks = obelisks;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Obelisk[] getObelisks() {
		return this.obelisks;
	}
}