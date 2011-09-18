package com.netty.model.player.skill.thieving;

import java.util.Random;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillType;
import com.netty.model.update.Animation;

public class Thieving {

	private Pickpocket pickpocket;
	private Stall stall;

	public Thieving(Player player, int stallID, int npcID) {
		this.executePickpocket(player, npcID);
		this.executeStall(player, stallID);
	}

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

	private Pickpocket getPickpocket(int pickpocketID) {
		int[] pickpocketIDs = { 1281, 1308, 1307, 1309, 1306 };
		Pickpocket[] pickpocketTypes = {
				Pickpocket.FARMER, Pickpocket.FEMALE_HAM, Pickpocket.MALE_HAM, Pickpocket.HAM_GUARD,
				Pickpocket.WOMAN_WARRIOR, Pickpocket.ROGUE, Pickpocket.CAVE_GOBLIN, Pickpocket.MASTER_FARMER,
				Pickpocket.GUARD, Pickpocket.FREMENNIK_CITIZEN, Pickpocket.BEARDED_POLLNIVIAN_BANDIT,
				Pickpocket.DESERT_BANDIT, Pickpocket.KNIGHT_ARDOUGNE, Pickpocket.POLLNIVIAN_BANDIT,
				Pickpocket.YANILLE_WATCHMAN, Pickpocket.MENAPHITE_THUG, Pickpocket.PALADIN, Pickpocket.GNOME,
				Pickpocket.HERO, Pickpocket.ELF, Pickpocket.DRAWF_TRADER
		};
		for (int i : pickpocketIDs) {
			if (pickpocketID == i) {
				return pickpocketTypes[i];
			}
		}
		return Pickpocket.MAN_WOMAN;
	}

	public void setPickpocket(Pickpocket pickpocket) {
		this.pickpocket = pickpocket;
	}

	public Pickpocket getPickpocket() {
		return this.pickpocket;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	public Stall getStall() {
		return this.stall;
	}
}