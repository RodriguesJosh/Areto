package com.netty.model.player.skill.construction;

public enum RoomType {

	GARDEN, PARLOUR, KITCHEN, DINING_ROOM, WORKSHOP, BEDROOM, SKILL_HALL, GAMES_ROOM, COMBAT_ROOM, QUEST_HALL, MENAGERIE, STUDY, COSTUME_ROOM, CHAPEL,
	PORTAL_CHAMBER, FORMAL_GARDEN, THRONE_ROOM, OUBLIETTE, DUNGEON_CORRIDOR, DUNGEON_JUNCTION, DUNGEON_STAIRS, PIT_DUNGEON, TREASURE_ROOM;

	private int level;
	private int price;
	private int doorways;

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setDoorways(int doorways) {
		this.doorways = doorways;
	}

	public int getDoorways() {
		return this.doorways;
	}
}