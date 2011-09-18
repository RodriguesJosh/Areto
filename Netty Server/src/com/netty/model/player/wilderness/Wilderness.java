package com.netty.model.player.wilderness;

import com.netty.model.object.impl.Obelisk;
import com.netty.world.World;

public class Wilderness {

	private int level;
	private Skull skull;
	private Revenant[] revenants;
	private Obelisk[] obelisks;

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

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setSkull(Skull skull) {
		this.skull = skull;
	}

	public Skull getSkull() {
		return this.skull;
	}

	public boolean isSkulling() {
		return this.getSkull() != null;
	}

	public void resetSkull() {
		this.setSkull(null);
	}

	public boolean isSkulled() {
		return this.getSkull() != null;
	}

	public void setRevenants(Revenant[] revenants) {
		this.revenants = revenants;
	}

	public Revenant[] getRevenants() {
		return this.revenants;
	}

	public void setObelisks(Obelisk[] obelisks) {
		this.obelisks = obelisks;
	}

	public Obelisk[] getObelisks() {
		return this.obelisks;
	}
}