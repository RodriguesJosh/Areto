package com.netty.model.player.minigame.godwars;

import com.netty.model.npc.NPC;
import com.netty.world.World;

public class Minions {

	private Boss boss;
	private NPC[] npc;
	private byte killCount;

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

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Boss getBoss() {
		return this.boss;
	}

	public void setNPC(NPC[] npc) {
		this.npc = npc;
	}

	public NPC[] getNPC() {
		return this.npc;
	}

	public void setKillCount(byte killCount) {
		this.killCount = killCount;
	}

	public byte getKillCount() {
		return this.killCount;
	}
}