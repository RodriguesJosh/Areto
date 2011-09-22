package com.netty.net.packet;

public class PacketConstants {

	public static final String GAME_XML = "data/packets/game-packets.xml";
	public static final String LOGIN_XML = "data/packets/login-packets.xml";
	public static final byte OPCODE_KEY = 14;
	public static final byte OPCODE_UPDATE = 15;
	public static final byte OPCODE_CONNECT = 16;
	public static final byte OPCODE_RECONNECT = 18;
	public static final short MAGIC_CODE = 255;
	public static final short VERSION = 317;
	public static final byte MEMORY = 1;
	public static final byte RSA_OPCODE = 10;
	public static final short PLAYER_INFORMATION = 249;
	public static final byte RESET_CAMERA = 107;
	public static final byte SKILL_INTERFACE = 71;
	public static final byte MAP_REGION = 73;
	public static final short MESSAGE = 253;
	public static final short SKILLS = 134;
	public static final short PRIVATE_MESSAGE = 196;
	public static final byte LOGOUT = 109;
	public static final byte TYPE_CONTAINER = 53;
	public static final byte EQUIPMENT = 34;
	public static final short BANK = 248;
	public static final byte TEXT = 126;
	public static final byte INTERFACE = 97;
	public static final short PRIVATE_MESSAGE_STATUS = 221;
	public static final short REMOVE_WINDOWS = 219;
	public static final byte ENTITY_LOCATION = 85;
	public static final byte OBJECT_DEFINITION = 101;
	public static final short OBJECT_ID = 151;
	public static final byte ENERGY = 110;
	public static final short PACKET_200 = 200;
	public static final short PACKET_164 = 164;
	public static final short PACKET_248 = 248;
	public static final short PACKET_185 = 185;
	public static final byte PACKET_75 = 75;
	public static final byte MENU_OPTION = 104;
	public static final short INVENTORY = 248;
	public static final byte ITEM_DEFINITION = 44;
	public static final short ITEM_ID = 156;
	public static final short BANK_PIN = 218;

	public static final byte[] PACKET_SIZES = {
		0, 0, 0, 1, -1, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 8, 0, 6, 2, 2, 0,
		0, 2, 0, 6, 0, 12, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 8, 4, 0, 0, 2,
		2, 6, 0, 6, 0, -1, 0, 0, 0, 0,
		0, 0, 0, 12, 0, 0, 0, 0, 8, 0,
		0, 8, 0, 0, 0, 0, 0, 0, 0, 0,
		6, 0, 2, 2, 8, 6, 0, -1, 0, 6,
		0, 0, 0, 0, 0, 1, 4, 6, 0, 0,
		0, 0, 0, 0, 0, 3, 0, 0, -1, 0,
		0, 13, 0, -1, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 6, 0, 0,
		1, 0, 6, 0, 0, 0, -1, 0, 2, 6,
		0, 4, 6, 8, 0, 6, 0, 0, 0, 2,
		0, 0, 0, 0, 0, 6, 0, 0, 0, 0,
		0, 0, 1, 2, 0, 2, 6, 0, 0, 0,
		0, 0, 0, 0, -1, -1, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 8, 0, 3, 0, 2, 0, 0, 8, 1,
		0, 0, 12, 0, 0, 0, 0, 0, 0, 0,
		2, 0, 0, 0, 0, 0, 0, 0, 4, 0,
		4, 0, 0, 0, 7, 8, 0, 0, 10, 0,
		0, 0, 0, 0, 0, 0, -1, 0, 6, 0,
		1, 0, 0, 0, 6, 0, 6, 8, 1, 0,
		0, 4, 0, 0, 0, 0, -1, 0, -1, 4,
		0, 0, 6, 6, 0, 0, 0
	};
}