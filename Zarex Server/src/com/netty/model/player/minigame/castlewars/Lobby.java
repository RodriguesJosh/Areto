package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.tab.equipment.Equipment;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:24:27 PM
 */
public class Lobby {

	/**
	 * 
	 */
	private ZamorakTeam zamorakTeam;

	/**
	 * 
	 */
	private SaradominTeam saradominTeam;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param location
	 *			The id to set.
	 * @param object
	 *			The id to set.
	 */
	public Lobby(Player player, Location location, Object object) {
		switch (object.getID()) {
			case 7272: // Castle Wars leave portal
				player.setLocation(new Location((short) 0, (short) 0, (byte) 0));
				break;
			case 1519:
				player.getPacketSender().getMessage("You cannot leave Castle Wars this way!");
				break;
			case 1516:
				player.getPacketSender().getMessage("You cannot leave Castle Wars this way!");
				break;
			case 4388:
				this.setZamorakTeam(new ZamorakTeam(player));
				this.getZamorakTeam().getEnterPortal();
				break;
			case 4408:
				new GuthixPortal(player, this.getSaradominTeam().getPlayerList().size() < this.getZamorakTeam().getPlayerList().size() ? this.getSaradominTeam() : this.getZamorakTeam());
				break;
			case 4387:
				this.setSaradominTeam(new SaradominTeam(player));
				this.getSaradominTeam().getEnterPortal();
				break;
			case 4390:
				this.getZamorakTeam().getLeaveLobbyPortal();
				break;
			case 4389:
				this.getSaradominTeam().getLeaveLobbyPortal();
				break;
			case 4406:
				this.getSaradominTeam().getLeaveGamePortal();
				break;
			case 4458:
				/** if(player.tableWait == 0) {
				player.playAnimation(Animation.create(881));
				player.getInventory().add(new Item(4049, 1));
				player.tableWait += 2;
			} */
				break;
			case 6280:
				player.setLocation(new Location((short) 2429, (short) 3075, (byte) 2));
				break;
			case 4471:
				player.setLocation(new Location((short) 2429, (short) 3075, (byte) 1));
				break;
			case 4469:
				if ((player.getLocation().getX() == 2426) && (player.getLocation().getY() == 3080)) {
					player.setLocation(new Location((short) 2426, (short) 3081, (byte) 1));
				}
				if ((player.getLocation().getX() == 2426) && (player.getLocation().getY() == 3081)) {
					player.setLocation(new Location((short) 2426, (short) 3080, (byte) 1));
				}
				if ((player.getLocation().getX() == 2423) && (player.getLocation().getY() == 3076)) {
					player.setLocation(new Location((short) 2422, (short) 3076, (byte) 1));
				}
				if ((player.getLocation().getX() == 2422) && (player.getLocation().getY() == 3076)) {
					player.setLocation(new Location((short) 2423, (short) 3076, (byte) 1));
				}
				break;
			case 354:
			case 366:
				player.getPacketSender().getMessage("You search the create... but find nothing!");
				break;
			case 4417:
				if ((player.getLocation().getX() == 2425) && (player.getLocation().getY() == 3077)) {
					player.setLocation(new Location((short) 2425, (short) 3074, (byte) 3));
				}
				if ((player.getLocation().getX() == 2426) && (player.getLocation().getY() == 3074)) {
					player.setLocation(new Location((short) 2425, (short) 3077, (byte) 2));
				}
				break;
			case 4902: //Capture Saradomin Flag
				if (player.getEquipment().isSlotUsed(Equipment.getSlotWeapon())) {
					player.getPacketSender().getMessage("Remove your weapon before taking the flag!");
					return;
				}
				/** if(player.getInventory().hasRoomFor(player.getEquipment().getById(Equipment.SLOT_WEAPON), Inventory.SIZE)) {
				player.getInventory().add(player.getEquipment().getById(Equipment.SLOT_WEAPON));
				player.getEquipment().add(new Item(4037));
				for(Player all : World.getWorld().getPlayers()) {
					if(cwPlayers.contains(all.getName())) {

					}
				}
			} */
				break;
		}
	}

	/**
	 * 
	 * @param zamorakTeam
	 *			The id to set.
	 */
	public void setZamorakTeam(ZamorakTeam zamorakTeam) {
		this.zamorakTeam = zamorakTeam;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public ZamorakTeam getZamorakTeam() {
		return this.zamorakTeam;
	}

	/**
	 * 
	 * @param saradominTeam
	 *			The id to set.
	 */
	public void setSaradominTeam(SaradominTeam saradominTeam) {
		this.saradominTeam = saradominTeam;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public SaradominTeam getSaradominTeam() {
		return this.saradominTeam;
	}
}