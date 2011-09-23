package com.netty.model.player.minigame.godwars;

import com.netty.model.npc.NPC;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:48:35 PM
 */
public class Minions {

	/**
	 * 
	 */
	private Boss boss;

	/**
	 * 
	 */
	private NPC[] npc;

	/**
	 * 
	 */
	private byte killCount;

	/**
	 * 
	 * @param boss
	 *			The id to set.
	 */
	public Minions(Boss boss) {
		this.setBoss(boss);
		if (this.getBoss() instanceof Bandos) {
			this.setNPC(new NPC[] {
					World.getWorld().getNPCList().get(2), World.getWorld().getNPCList().get(3)
			});
		} else if (this.getBoss() instanceof Zamorak) {
			this.setNPC(new NPC[] {
					World.getWorld().getNPCList().get(2), World.getWorld().getNPCList().get(3)
			});
		} else if (this.getBoss() instanceof Saradomin) {
			this.setNPC(new NPC[] {
					World.getWorld().getNPCList().get(2), World.getWorld().getNPCList().get(3)
			});
		} else if (this.getBoss() instanceof Armadyl) {
			this.setNPC(new NPC[] {
					World.getWorld().getNPCList().get(2), World.getWorld().getNPCList().get(3)
			});
		}
		this.setKillCount((byte) 0);
		for (NPC npc : this.getNPC()) {
			if (npc.isDead()) {
				int killCount = this.getKillCount();
				this.setKillCount((byte) killCount++);
			}
		}
	}

	/**
	 * 
	 * @param boss
	 *			The id to set.
	 */
	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Boss getBoss() {
		return this.boss;
	}

	/**
	 * 
	 * @param npc
	 *			The id to set.
	 */
	public void setNPC(NPC[] npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public NPC[] getNPC() {
		return this.npc;
	}

	/**
	 * 
	 * @param killCount
	 *			The id to set.
	 */
	public void setKillCount(byte killCount) {
		this.killCount = killCount;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public byte getKillCount() {
		return this.killCount;
	}
}