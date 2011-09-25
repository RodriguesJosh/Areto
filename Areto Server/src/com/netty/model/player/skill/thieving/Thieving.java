package com.netty.model.player.skill.thieving;

import java.util.Random;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillType;
import com.netty.model.update.Animation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:24:27 AM
 */
public class Thieving {

	/**
	 * 
	 */
	private Pickpocket pickpocket;

	/**
	 * 
	 */
	private Stall stall;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param stallID
	 * 			The id to set.
	 * @param npcID
	 * 			The id to set.
	 */
	public Thieving(Player player, int stallID, int npcID) {
		this.executePickpocket(player, npcID);
		this.executeStall(player, stallID);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param npcID
	 * 			The id to set.
	 */
	private void executePickpocket(Player player, int npcID) {
		if (npcID == -1) {
			return;
		}
		this.setPickpocket(this.getPickpocket(npcID));
		// this.setPickpocketChance(player);
		if (player.getSkills()[SkillType.THIEVING.getID()].getLevel() < this.getPickpocket().getLevel()) {
			player.getPacketSender().getMessage("You must have a level of " + this.getPickpocket().getLevel() + " in order to pickpocket from this NPC.");
			return;
		}
		player.setAnimation(new Animation(422, 0));
		Random random = new Random();
		Item item = this.getPickpocket().getLoot()[random.nextInt(this.getStall().getLoot().length)];
		if (player.getInventory().hasRoomFor(item) && (player.getInventory().getInventoryContainer().getFreeSlots() > 0)) {
			player.getInventory().registerItem(item);
			player.getPacketSender().getMessage("You managed to pickpocket some " + item.getName() + "s.");
		}
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param stallID
	 * 			The id to set.
	 */
	private void executeStall(Player player, int stallID) {
		if (stallID == -1) {
			return;
		}
		this.setStall(this.getStall(stallID));
		// this.setStallChance(player);
		if (player.getSkills()[SkillType.THIEVING.getID()].getLevel() < this.getStall().getLevel()) {
			player.getPacketSender().getMessage("You must have a level of " + this.getStall().getLevel() + " in order to steal from this stall.");
			return;
		}
		player.setAnimation(new Animation(422, 0));
		Random random = new Random();
		Item item = this.getStall().getLoot()[random.nextInt(this.getStall().getLoot().length)];
		if (player.getInventory().hasRoomFor(item) && (player.getInventory().getInventoryContainer().getFreeSlots() > 0)) {
			player.getInventory().registerItem(item);
			player.getPacketSender().getMessage("You managed to steal some " + item.getName() + "s.");
		}
	}

	/**
	 * 
	 * @param stallID
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private Stall getStall(int stallID) {
		int[] stallIDs = { 1281, 1308, 1307, 1309, 1306 };
		Stall[] stallTypes = {
				Stall.BAKERS, Stall.CRAFTING, Stall.MONKEY_FOOD, Stall.MONKEY_GENERAL_STORE, Stall.TEA, Stall.SILK,
				Stall.WINE, Stall.SEED, Stall.FUR, Stall.FISH, Stall.CROSSBOW, Stall.SILVER, Stall.EVIDENCE_FILES,
				Stall.SPICE, Stall.MAGIC, Stall.SCIMITAR, Stall.GEM
		};
		for (int i : stallIDs) {
			if (stallID == i) {
				return stallTypes[i];
			}
		}
		return Stall.VEGETABLE;
	}

	/**
	 * 
	 * @param pickpocketID
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private Pickpocket getPickpocket(int pickpocketID) {
		int[] pickpocketIDs = { 1281, 1308, 1307, 1309, 1306 };
		Pickpocket[] pickpocketTypes = Pickpocket.values();
		for (int i : pickpocketIDs) {
			if (pickpocketID == i) {
				return pickpocketTypes[i];
			}
		}
		return Pickpocket.MAN_WOMAN;
	}

	/**
	 * 
	 * @param pickpocket
	 * 			The id to set.
	 */
	public void setPickpocket(Pickpocket pickpocket) {
		this.pickpocket = pickpocket;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Pickpocket getPickpocket() {
		return this.pickpocket;
	}

	/**
	 * 
	 * @param stall
	 * 			The id to set.
	 */
	public void setStall(Stall stall) {
		this.stall = stall;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Stall getStall() {
		return this.stall;
	}
}