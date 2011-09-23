package com.netty.model.player.skill.woodcutting;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.tab.equipment.Equipment;
import com.netty.model.update.Animation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:18:52 AM
 */
public class Woodcutting {

	/**
	 * 
	 */
	private Hatchet hatchet;

	/**
	 * 
	 */
	private Tree tree;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param treeID
	 * 			The id to set.
	 */
	public Woodcutting(Player player, int treeID) {
		this.execute(player, treeID);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param treeID
	 * 			The id to set.
	 */
	private void execute(Player player, int treeID) {
		if (!this.hasHatchet()) {
			player.getPacketSender().getMessage("You must have an axe in order to woodcut.");
		}
		this.setTree(this.getTree(treeID));
		if (player.getSkills()[SkillType.WOODCUTTING.getID()].getLevel() < this.getTree(treeID).getLevel()) {
			player.getPacketSender().getMessage("You must have a level of " + this.getTree(treeID).getLevel() + " in order to chop this tree.");
		}
		this.setHatchet(this.getHatchet(Equipment.getSlotWeapon()));
		player.setAnimation(new Animation(this.getHatchet().getAnimationID(), 0));
		Item item = new Item(treeID, 1);
		if (player.getInventory().hasRoomFor(item) && (player.getInventory().getInventoryContainer().getFreeSlots() > 0)) {
			player.getInventory().registerItem(item);
			player.getPacketSender().getMessage("You managed to cut some " + this.getTree().getName() + " logs.");
		}
	}

	/**
	 * 
	 * @param treeID
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private Tree getTree(int treeID) {
		int[] treeIDs = { 1281, 1308, 1307, 1309, 1306 };
		Tree[] treeTypes = { Tree.OAK, Tree.WILLOW, Tree.MAPLE, Tree.YEW, Tree.MAGIC };
		for (int i : treeIDs) {
			if (treeID == i) {
				return treeTypes[i];
			}
		}
		return Tree.NORMAL;
	}

	/**
	 * 
	 * @param hatchetID
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	private Hatchet getHatchet(int hatchetID) {
		int[] hatchetIDs = { 1281, 1308, 1307, 1309, 1306 };
		Hatchet[] hatchetTypes = {
				Hatchet.IRON, Hatchet.STEEL, Hatchet.BLACK, Hatchet.MITHRIL, Hatchet.ADAMANT,
				Hatchet.RUNE, Hatchet.DRAGON
		};
		for (int i : hatchetIDs) {
			if (hatchetID == i) {
				return hatchetTypes[i];
			}
		}
		return Hatchet.BRONZE;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	private boolean hasHatchet() {
		int[] hatchetIDs = { 1349, 1351, 1353, 1361, 1355, 1357, 1359, 6739 };
		for (int i : hatchetIDs) {
			return Equipment.getSlotWeapon() == hatchetIDs[i];
		}
		return false;
	}

	/**
	 * 
	 * @param hatchet
	 * 			The id to set.
	 */
	public void setHatchet(Hatchet hatchet) {
		this.hatchet = hatchet;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Hatchet getHatchet() {
		return this.hatchet;
	}

	/**
	 * 
	 * @param tree
	 * 			The id to set.
	 */
	public void setTree(Tree tree) {
		this.tree = tree;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Tree getTree() {
		return this.tree;
	}
}