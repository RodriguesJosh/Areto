package com.netty.model.player.tab.equipment;

public enum EquipmentType {

	CAPE(Equipment.getSlotCape()), BOOTS(Equipment.getSlotBoots()), GLOVES(Equipment.getSlotGloves()), SHIELD(Equipment.getSlotShield()),
	HAT(Equipment.getSlotHelm()), AMULET(Equipment.getSlotAmulet()), ARROWS(Equipment.getSlotArrows()), RING(Equipment.getSlotRing()),
	BODY(Equipment.getSlotChest()), LEGS(Equipment.getSlotLegs()), PLATEBODY(Equipment.getSlotChest()), FULL_HELM(Equipment.getSlotHelm()),
	FULL_MASK(Equipment.getSlotHelm()), WEAPON(Equipment.getSlotWeapon());

	private byte slot;

	private EquipmentType(byte slot) {
		this.setSlot(slot);
	}

	public void setSlot(byte slot) {
		this.slot = slot;
	}

	public byte getSlot() {
		return this.slot;
	}
}