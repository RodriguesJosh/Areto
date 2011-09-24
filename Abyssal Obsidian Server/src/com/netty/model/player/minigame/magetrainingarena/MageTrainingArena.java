package com.netty.model.player.minigame.magetrainingarena;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.tab.equipment.Equipment;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:36:59 PM
 */
public class MageTrainingArena extends MiniGame {

	/**
	 * 
	 */
	private TelekineticTheatre telekineticTheatre;

	/**
	 * 
	 */
	private AlchemistsPlayground alchemistsPlayground;

	/**
	 * 
	 */
	private EnchantingChamber enchantingChamber;

	/**
	 * 
	 */
	private CreatureGraveyard creatureGraveyard;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public MageTrainingArena(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		if (this.getPlayer().getSkills()[SkillType.MAGIC.getID()].getLevel() < 7) {
			return;
		}
		Item penanceHat = this.getPlayer().getInventory().getInventoryContainer().getItemList().get(1000);
		if ((Equipment.getSlotHelm() != 1000) || this.getPlayer().getInventory().getInventoryContainer().containsItem(penanceHat)) {
			return;
		}
		this.setTelekineticTheatre(new TelekineticTheatre());
		this.setAlchemistsPlayground(new AlchemistsPlayground());
		this.setEnchantingChamber(new EnchantingChamber());
		this.setCreatureGraveyard(new CreatureGraveyard());
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
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
	 * @param telekineticTheatre
	 * 			The id to set.
	 */
	public void setTelekineticTheatre(TelekineticTheatre telekineticTheatre) {
		this.telekineticTheatre = telekineticTheatre;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public TelekineticTheatre getTelekineticTheatre() {
		return this.telekineticTheatre;
	}

	/**
	 * 
	 * @param alchemistsPlayground
	 * 			The id to set.
	 */
	public void setAlchemistsPlayground(AlchemistsPlayground alchemistsPlayground) {
		this.alchemistsPlayground = alchemistsPlayground;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public AlchemistsPlayground getAlchemistsPlayground() {
		return this.alchemistsPlayground;
	}

	/**
	 * 
	 * @param enchantingChamber
	 * 			The id to set.
	 */
	public void setEnchantingChamber(EnchantingChamber enchantingChamber) {
		this.enchantingChamber = enchantingChamber;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EnchantingChamber getEnchantingChamber() {
		return this.enchantingChamber;
	}

	/**
	 * 
	 * @param creatureGraveyard
	 * 			The id to set.
	 */
	public void setCreatureGraveyard(CreatureGraveyard creatureGraveyard) {
		this.creatureGraveyard = creatureGraveyard;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public CreatureGraveyard getCreatureGraveyard() {
		return this.creatureGraveyard;
	}
}
