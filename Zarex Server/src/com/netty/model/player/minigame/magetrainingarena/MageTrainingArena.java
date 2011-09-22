package com.netty.model.player.minigame.magetrainingarena;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;
import com.netty.model.player.tab.equipment.Equipment;

public class MageTrainingArena extends MiniGame {

	private TelekineticTheatre telekineticTheatre;
	private AlchemistsPlayground alchemistsPlayground;
	private EnchantingChamber enchantingChamber;
	private CreatureGraveyard creatureGraveyard;

	public MageTrainingArena(Player player) {
		super(player);
	}

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

	@Override
	public void end() {}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setTelekineticTheatre(TelekineticTheatre telekineticTheatre) {
		this.telekineticTheatre = telekineticTheatre;
	}

	public TelekineticTheatre getTelekineticTheatre() {
		return this.telekineticTheatre;
	}

	public void setAlchemistsPlayground(AlchemistsPlayground alchemistsPlayground) {
		this.alchemistsPlayground = alchemistsPlayground;
	}

	public AlchemistsPlayground getAlchemistsPlayground() {
		return this.alchemistsPlayground;
	}

	public void setEnchantingChamber(EnchantingChamber enchantingChamber) {
		this.enchantingChamber = enchantingChamber;
	}

	public EnchantingChamber getEnchantingChamber() {
		return this.enchantingChamber;
	}

	public void setCreatureGraveyard(CreatureGraveyard creatureGraveyard) {
		this.creatureGraveyard = creatureGraveyard;
	}

	public CreatureGraveyard getCreatureGraveyard() {
		return this.creatureGraveyard;
	}
}
