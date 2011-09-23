package com.netty.model.player.minigame.barrows;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.update.Animation;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:03:17 PM
 */
public class Barrows extends MiniGame {

	/**
	 * 
	 */
	private Brother brother;

	/**
	 * 
	 */
	private Chest chest;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param brother
	 * 			The id to set.
	 */
	public Barrows(Player player, Brother brother) {
		super(player);
		this.setBrother(brother);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		for (Item item : this.getPlayer().getEquipment().getItems()) {
			if (item.getID() == 952) {
				this.getPlayer().setAnimation(new Animation(831, 0));
				if ((this.getBrother().getTeleportLocation() != null) &&
						(this.getPlayer().getLocation().getX() >= this.getBrother().getStartLocation().getX()) &&
						(this.getPlayer().getLocation().getX() <= this.getBrother().getEndLocation().getX()) &&
						(this.getPlayer().getLocation().getY() >= this.getBrother().getStartLocation().getY()) &&
						(this.getPlayer().getLocation().getY() <= this.getBrother().getEndLocation().getY())) {
					this.getPlayer().setTeleport(this.getBrother().getTeleportLocation());
				}
			} else {
				break;
			}
		}
		int[] coffinIDs = { 6821, 6822, 6823, 6771, 6772, 6773 };
		for (int i = 0; i < coffinIDs.length; i++) {
			if (World.getWorld().getObjectList().get(coffinIDs[i]).isClicked()) {
				/** Spawn the barrows brother and fight him; then he'll drop loot and then we move onto the others. */
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		this.setChest(new Chest());
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getThreateningState()
	 */
	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	/**
	 * 
	 * @param brother
	 * 			The id to set.
	 */
	public void setBrother(Brother brother) {
		this.brother = brother;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Brother getBrother() {
		return this.brother;
	}

	/**
	 * 
	 * @param chest
	 * 			The id to set.
	 */
	public void setChest(Chest chest) {
		this.chest = chest;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Chest getChest() {
		return this.chest;
	}
}