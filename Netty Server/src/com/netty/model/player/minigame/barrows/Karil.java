package com.netty.model.player.minigame.barrows;

import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.RangeCombat;
import com.netty.model.combat.magic.MagicCombat;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.item.Item;
import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;
import com.netty.world.World;

public class Karil extends Brother {

	private Location startLocation;
	private Location endLocation;
	private NPC npc;
	private Teleport teleportLocation;

	public Karil(Player player) {
		super(player);
		this.setStartLocation(new Location((short) 3570, (short) 3293, (byte) 1));
		this.setEndLocation(new Location((short) 3576, (short) 3299, (byte) 1));
		this.setNPC(World.getWorld().getNPCList().get(0));
		this.setTeleportLocation(Teleport.LUMBRIDGE);
		if (this.getNPC().isDead()) {
			this.getNPC().setItemDrops(new Item[] {
					new Item(1, 1), new Item(2, 2) /** Random drops. Needs more accuracy. */
			});
		} else {
			if (player.isMaging()) {
				player.setCombat(new MagicCombat(player, this.getNPC(), CombatType.MAGIC, AttackType.ACCURATE));
			} else if (player.isMeleeing()) {
				player.setCombat(new MeleeCombat(player, this.getNPC(), CombatType.MELEE, AttackType.ACCURATE));
			} else if (player.isRanging()) {
				player.setCombat(new RangeCombat(player, this.getNPC(), CombatType.RANGE, AttackType.ACCURATE));
			}
		}
	}

	@Override
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	@Override
	public Location getStartLocation() {
		return this.startLocation;
	}

	@Override
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	@Override
	public Location getEndLocation() {
		return this.endLocation;
	}

	@Override
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	@Override
	public NPC getNPC() {
		return this.npc;
	}

	@Override
	public void setTeleportLocation(Teleport teleportLocation) {
		this.teleportLocation = teleportLocation;
	}

	@Override
	public Teleport getTeleportLocation() {
		return this.teleportLocation;
	}
}