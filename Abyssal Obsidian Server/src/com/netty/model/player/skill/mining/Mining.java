package com.netty.model.player.skill.mining;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.tab.equipment.Equipment;
import com.netty.model.update.Animation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:51:19 AM
 */
public class Mining {

	/**
	 * 
	 */
	private Pickaxe pickaxe;

	/**
	 * 
	 */
	private Ore ore;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param oreID
	 * 			The id to set.
	 */
	public Mining(Player player, int oreID) {
		this.execute(player, oreID);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param oreID
	 * 			The id to set.
	 */
	private void execute(Player player, int oreID) {
		if (!this.hasPickaxe()) {
			player.getPacketSender().getMessage("You must have a pickaxe in order to mine.");
			return;
		}
		this.setOre(this.getOre(oreID));
		if (player.getSkills()[SkillType.MINING.getID()].getLevel() < this.getOre().getLevel()) {
			player.getPacketSender().getMessage("You must have a level of " + this.getOre().getLevel() + " in order to mine this ore.");
			return;
		}
		this.setPickaxe(this.getPickaxe(Equipment.getSlotWeapon()));
		player.setAnimation(new Animation(this.getPickaxe().getAnimationID(), 0));
		Item item = new Item(oreID, 1);
		if (player.getInventory().hasRoomFor(item) && (player.getInventory().getInventoryContainer().getFreeSlots() > 0)) {
			player.getInventory().registerItem(item);
			player.getPacketSender().getMessage("You managed to mine some " + this.getOre().getName() + " ore.");
		}
	}

	/**
	 * 
	 * @param oreID
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private Ore getOre(int oreID) {
		int[] oreIDs = { 1281, 1308, 1307, 1309, 1306 };
		Ore[] oreTypes = {
				Ore.RUNE_ESSENCE, Ore.COPPER, Ore.TIN, Ore.LIMESTONE, Ore.BLURITE, Ore.IRON, Ore.ELEMENTAL,
				Ore.DAEYALT, Ore.SILVER, Ore.PURE_ESSENCE, Ore.COAL, Ore.SANDSTONE, Ore.GEM_ROCK, Ore.GOLD,
				Ore.PERFECT_GOLD, Ore.GRANITE, Ore.RUBIUM, Ore.MITHRIL, Ore.LUNAR, Ore.ADAMANTITE, Ore.LIVING_MINERALS,
				Ore.CONCENTRATED_COAL, Ore.CONCENTRATED_GOLD, Ore.RUNITE
		};
		for (int i : oreIDs) {
			if (oreID == i) {
				return oreTypes[i];
			}
		}
		return Ore.CLAY;
	}

	/**
	 * 
	 * @param pickaxeID
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private Pickaxe getPickaxe(int pickaxeID) {
		int[] pickaxeIDs = { 1281, 1308, 1307, 1309, 1306 };
		Pickaxe[] pickaxeTypes = {
				Pickaxe.IRON, Pickaxe.STEEL, Pickaxe.MITHRIL, Pickaxe.ADAMANT,
				Pickaxe.RUNE, Pickaxe.DRAGON, Pickaxe.SACRED_CLAY, Pickaxe.INFERNO_ADZE
		};
		for (int i : pickaxeIDs) {
			if (pickaxeID == i) {
				return pickaxeTypes[i];
			}
		}
		return Pickaxe.BRONZE;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	private boolean hasPickaxe() {
		int[] pickaxeIDs = { 1349, 1351, 1353, 1361, 1355, 1357, 1359, 6739 };
		for (int i : pickaxeIDs) {
			return Equipment.getSlotWeapon() == pickaxeIDs[i];
		}
		return false;
	}

	/**
	 * 
	 * @param pickaxe
	 * 			The id to set.
	 */
	public void setPickaxe(Pickaxe pickaxe) {
		this.pickaxe = pickaxe;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Pickaxe getPickaxe() {
		return this.pickaxe;
	}

	/**
	 * 
	 * @param ore
	 * 			The id to set.
	 */
	public void setOre(Ore ore) {
		this.ore = ore;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Ore getOre() {
		return this.ore;
	}
}