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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:06:08 PM
 */
public class Guthan extends Brother {

	/**
	 * 
	 */
	private Location startLocation;

	/**
	 * 
	 */
	private Location endLocation;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private Teleport teleportLocation;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Guthan(Player player) {
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

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#setStartLocation(com.netty.world.Location)
	 */
	@Override
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#getStartLocation()
	 */
	@Override
	public Location getStartLocation() {
		return this.startLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#setEndLocation(com.netty.world.Location)
	 */
	@Override
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#getEndLocation()
	 */
	@Override
	public Location getEndLocation() {
		return this.endLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#setNPC(com.netty.model.npc.NPC)
	 */
	@Override
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#getNPC()
	 */
	@Override
	public NPC getNPC() {
		return this.npc;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#setTeleportLocation(com.netty.model.player.Teleport)
	 */
	@Override
	public void setTeleportLocation(Teleport teleportLocation) {
		this.teleportLocation = teleportLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.barrows.Brother#getTeleportLocation()
	 */
	@Override
	public Teleport getTeleportLocation() {
		return this.teleportLocation;
	}
}