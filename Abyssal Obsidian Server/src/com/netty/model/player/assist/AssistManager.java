package com.netty.model.player.assist;

import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:07:19 PM
 */
public class AssistManager {

	/**
	 * 
	 */
	private Assist assist;

	/**
	 * 
	 */
	private SkillType[] restrictedSkills;

	/**
	 * 
	 */
	public void restrictions() {
		/**
		 * It cannot be used for any combat skills except the noncombat aspects of Magic.
		 * It cannot be used for Woodcutting, Fishing, Mining, Hunter, Thieving, Firemaking, Agility, Summoning or Dungeoneering.
		 * Does not work for Quests and Activities.
		 * Once 30,000 experience has been gained, the interface changes.
		 * Only 30,000 experience can be gained in any 24-hour period through assisting others. Once this limit is reached, it is impossible to assist any further.
		 * Assist requests can only be sent if the target player has set the "assist" option at the bottom of the interface to a group that includes you ("friends" if on their friend list, otherwise "on").
		 * The player that is being lent a skill must remain within 20 squares of the player they are being assisted by. However, if the assisted player teleports away, then they shall still be assisted.
		 * The player lending their skills cannot do anything except use the player chat interfaces; they can't move, use items, etc.
		 * It cannot be used to process untradeable items; ancient effigies and crafting urns are exceptions.

		 * Construction
		 * Only flat-packed items can be made
		 * Rooms cannot be made
		 * Servants cannot be hired below the required level with assistance.
		 * In the Herblore Habitat Activity you can assist Construction but no exp will be earned

		 * Cooking
		 * Gnome foods cannot be prepared because they are used in the Gnome Restaurant activity.
		 * Lava eel cannot be prepared because it is non tradeable.

		 * Crafting
		 * Demonic sigils, lightning rods, slayer helmets and silvthrill rods cannot be crafted, because they are untradeable quest items.
		 * Banner easels cannot be used.
		 * After a recent update, the Feather headdress now can be made with the assist system.
		 * Sapphire Lanterns can't be made using the assist system because they are non-tradeable.
		 * A Dramen branch cannot be crafted into a Dramen staff with assistance.

		 * Farming
		 * Trees and calquats cannot be planted because the potted versions of these are untradeable, bushes and cacti are also unable to be planted.
		 * Experience will not be given for harvesting if you are not assisted during that process.

		 * Fletching
		 * Ogre arrows and Lyres cannot be fletched using the Assist System because they are quest-related.

		 * Herblore	The Assist System cannot be used to make Sanfew serum, Guthix balance potion, Magic essence potion, Shrink-me-quick potion, Super truth serum or Relicym's balm, nor be used to grow the Yommi tree in Legends' Quest, as these are all used in quests.
		 * Some Quests (For example, the Heroes' Quest) do work with the assist system.
		 * Also, blamish oil cannot be made as said above with lava eels.
		 * Players cannot make any of the extreme potions, nor the dangerous overload potion with the assist system.

		 * Magic
		 * The only Lunar Spells that cannot be used are Vengeance and Vengeance Other, Teleport and Tele Group spells.
		 * No spells from the Ancient Magics spellbook can be cast, as all the spells in the spellbook are either teleportation or combat spells.
		 * From the normal spellbook, only the following spells can be cast:
		 * Enchant jewellery spells (all)
		 * Charge orbs (water, earth, fire, air)
		 * Alchemy (low and high level)
		 * Bones to Bananas
		 * Bones to Peaches
		 * Superheat item
		 * Making Magic Tablets (From POH).
		 * Enchant bolt spells (all)

		 * Runecrafting
		 * Higher level pouches (large and giant) cannot be filled by using assist.
		 * Multiple runes per essence can be crafted if the assister has a high enough level.

		 * Smithing
		 * Darts cannot be made unless Tourist Trap is completed by the assisted player, claws cannot be made unless Death Plateau is completed and pickaxes cannot be made unless Perils of Ice Mountain is completed.
		 * Does not work on Between a Rock... to make the gold helmet required for the quest.
		 */
	}

	/**
	 * 
	 * @param assist
	 * 			The assist to set.
	 */
	public void setAssist(Assist assist) {
		this.assist = assist;
	}

	/**
	 * 
	 * @return assist
	 * 			Returns the assist to get.
	 */
	public Assist getAssist() {
		return this.assist;
	}

	/**
	 * 
	 * @param restrictedSkills
	 * 			The restrictedSkills to set.
	 */
	public void setRestrictedSkills(SkillType[] restrictedSkills) {
		this.restrictedSkills = restrictedSkills;
	}

	/**
	 * 
	 * @return restrictedSkills
	 * 			Returns the restrictedSkills to get.
	 */
	public SkillType[] getRestrictedSkills() {
		return this.restrictedSkills;
	}
}