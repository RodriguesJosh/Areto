package com.netty.model.player.skill.construction;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:04:06 PM
 */
public enum RoomType {

	/**
	 * 
	 */
	GARDEN,

	/**
	 * 
	 */
	PARLOUR,

	/**
	 * 
	 */
	KITCHEN,

	/**
	 * 
	 */
	DINING_ROOM,

	/**
	 * 
	 */
	WORKSHOP,

	/**
	 * 
	 */
	BEDROOM,

	/**
	 * 
	 */
	SKILL_HALL,

	/**
	 * 
	 */
	GAMES_ROOM,

	/**
	 * 
	 */
	COMBAT_ROOM,

	/**
	 * 
	 */
	QUEST_HALL,

	/**
	 * 
	 */
	MENAGERIE,

	/**
	 * 
	 */
	STUDY,

	/**
	 * 
	 */
	COSTUME_ROOM,

	/**
	 * 
	 */
	CHAPEL,
	/**
	 * 
	 */
	PORTAL_CHAMBER,

	/**
	 * 
	 */
	FORMAL_GARDEN,

	/**
	 * 
	 */
	THRONE_ROOM,

	/**
	 * 
	 */
	OUBLIETTE,

	/**
	 * 
	 */
	DUNGEON_CORRIDOR,

	/**
	 * 
	 */
	DUNGEON_JUNCTION,

	/**
	 * 
	 */
	DUNGEON_STAIRS,

	/**
	 * 
	 */
	PIT_DUNGEON,

	/**
	 * 
	 */
	TREASURE_ROOM;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int price;

	/**
	 * 
	 */
	private int doorways;

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param price
	 * 			The id to set.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param doorways
	 * 			The id to set.
	 */
	public void setDoorways(int doorways) {
		this.doorways = doorways;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getDoorways() {
		return this.doorways;
	}
}