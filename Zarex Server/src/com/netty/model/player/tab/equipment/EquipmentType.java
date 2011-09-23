package com.netty.model.player.tab.equipment;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:13:09 AM
 */
public enum EquipmentType {

	/**
	 * 
	 */
	CAPE(Equipment.getSlotCape()),

	/**
	 * 
	 */
	BOOTS(Equipment.getSlotBoots()),

	/**
	 * 
	 */
	GLOVES(Equipment.getSlotGloves()),

	/**
	 * 
	 */
	SHIELD(Equipment.getSlotShield()),
	/**
	 * 
	 */
	HAT(Equipment.getSlotHelm()),

	/**
	 * 
	 */
	AMULET(Equipment.getSlotAmulet()),

	/**
	 * 
	 */
	ARROWS(Equipment.getSlotArrows()),

	/**
	 * 
	 */
	RING(Equipment.getSlotRing()),

	/**
	 * 
	 */
	BODY(Equipment.getSlotChest()),

	/**
	 * 
	 */
	LEGS(Equipment.getSlotLegs()),

	/**
	 * 
	 */
	PLATEBODY(Equipment.getSlotChest()),

	/**
	 * 
	 */
	FULL_HELM(Equipment.getSlotHelm()),

	/**
	 * 
	 */
	FULL_MASK(Equipment.getSlotHelm()),

	/**
	 * 
	 */
	WEAPON(Equipment.getSlotWeapon());

	/**
	 * 
	 */
	private byte slot;

	/**
	 * 
	 * @param slot
	 * 			The id to set.
	 */
	private EquipmentType(byte slot) {
		this.setSlot(slot);
	}

	/**
	 * 
	 * @param slot
	 * 			The id to set.
	 */
	public void setSlot(byte slot) {
		this.slot = slot;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getSlot() {
		return this.slot;
	}
}