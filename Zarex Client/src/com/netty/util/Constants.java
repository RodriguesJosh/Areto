package com.netty.util;

public class Constants {

	public static final int PORT = 43594;
	public static final short CYCLE_TIME = 600;
	public static final String SCRIPTS_PATH = "data/scripts/";
	public static final String JAVA_SCRIPT_PATH = Constants.SCRIPTS_PATH + "javascript/";
	public static final String PYTHON_PATH = Constants.SCRIPTS_PATH + "python/";
	public static final String RUBY_PATH = Constants.SCRIPTS_PATH + "ruby/";
	public static final int GARBAGE_COLLECTOR_TIME = 300000;
	public static final short MAX_PLAYERS = 2000;
	public static final short MAX_ITEMS = 2000;
	public static final short MAX_NPCS = 2000;
	public static final short MAX_OBJECTS = 2000;
	public static final short MAX_FRIENDS = 200;
	public static final short MAX_IGNORES = 200;
	public static final short MAX_CLANS = 2000;
	public static final short MAX_CLAN_NAMES = 200;
	public static final short MAX_CLAN_WARS_PLAYERS = 200;
	public static final byte MAX_SKILLS = 21;
	public static final byte MAX_LEVEL = 99;
	public static final int MAX_EXPERIENCE = Integer.MAX_VALUE;
	public static final byte MAX_CASTLE_WARS_PLAYERS = 25;
	public static final short MAX_BOUNTY_PLAYERS = 200;
	public static final byte CASTLE_WARS_WAITING_TIME = 20;
	public static final byte CASTLE_WARS_GAME_TIME = 15;
	public static final byte MAX_BOAT_PLAYERS = 25;
	public static final byte[] DIRECTION_DELTA_X = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static final byte[] DIRECTION_DELTA_Y = { 1, 1, 1, 0, 0, -1, -1, -1 };
	public static final String NPC_SPAWN_PATH = "data/spawns/npc-spawns.xml";
	public static final String OBJECT_SPAWN_PATH = "data/spawns/object-spawns.xml";
	public static final String ITEM_SPAWN_PATH = "data/spawns/item-spawns.xml";
	public static final String NPC_DROP_PATH = "data/drops/npc-drops.xml";
	public static final String ITEM_DROP_PATH = "data/drops/item-drops.xml";
	public static final String JAVA_SCRIPT_XML = Constants.SCRIPTS_PATH + "javascript-scripts.xml";
	public static final String PYTHON_XML = Constants.SCRIPTS_PATH + "python-scripts.xml";
	public static final String RUBY_XML = Constants.SCRIPTS_PATH + "ruby-scripts.xml";
	public static final short MAX_NPC_DROPS = 2000;
	public static final short MAX_ITEM_DROPS = 2000;
	public static final String GAME_XML = "data/packets/game-packets.xml";
	public static final String LOGIN_XML = "data/packets/login-packets.xml";
	public static final byte OPCODE_KEY = 14;
	public static final byte OPCODE_UPDATE = 15;
	public static final byte OPCODE_CONNECT = 16;
	public static final byte OPCODE_RECONNECT = 18;
	public static final String SAVE_CHARACTER_XML = "data/characters/";
	public static final String LOAD_CHARACTER_XML = "data/characters/";
	public static final short MAGIC_CODE = 255;
	public static final short VERSION = 317;
	public static final byte MEMORY = 1;
	public static final byte RSA_OPCODE = 10;
	public static final byte MAX_FIGHT_CAVE_WAVES = 63;
	public static final char[] VALID_CHARACTERS = {
		'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@',
		'#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', ':', ';',
		'.', '>', '<', ',', '"', '[', ']', '|', '?', '/', '`'
	};
	public static final char[] XLATE_TABLE = {
		' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u',
		'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q',
		'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!',
		'?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@',
		'#', '+', '=', '\243', '$', '%', '"', '[', ']'
	};
	public static final short MAX_STONE_POWER_CHARGES = 5000;
	public static final short MAX_ZEAL_EXPERIENCE = 8400;
	public static final String BANNED_STATUS_FILE = "data/status/banned-status.xml";
	public static final String MUTED_STATUS_FILE = "data/status/muted-status.xml";
	public static final String COMMANDS_XML = "data/commands/commands-packets.xml";
}