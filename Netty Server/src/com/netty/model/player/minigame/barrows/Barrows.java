package com.netty.model.player.minigame.barrows;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.update.Animation;
import com.netty.world.World;

public class Barrows extends MiniGame {

	private Brother brother;
	private Chest chest;

	public Barrows(Player player, Brother brother) {
		super(player);
		this.setBrother(brother);
	}

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

	@Override
	public void end() {
		this.setChest(new Chest());
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setBrother(Brother brother) {
		this.brother = brother;
	}

	public Brother getBrother() {
		return this.brother;
	}

	public void setChest(Chest chest) {
		this.chest = chest;
	}

	public Chest getChest() {
		return this.chest;
	}
}
