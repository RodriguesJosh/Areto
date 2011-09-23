package com.netty.net.packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:12:52 PM
 */
public class PacketConstants {

	/**
	 * 
	 */
	public static final String GAME_XML = "data/packets/game-packets.xml";

	/**
	 * 
	 */
	public static final String LOGIN_XML = "data/packets/login-packets.xml";

	/**
	 * 
	 */
	public static final byte OPCODE_KEY = 14;

	/**
	 * 
	 */
	public static final byte OPCODE_UPDATE = 15;

	/**
	 * 
	 */
	public static final byte OPCODE_CONNECT = 16;

	/**
	 * 
	 */
	public static final byte OPCODE_RECONNECT = 18;

	/**
	 * 
	 */
	public static final short MAGIC_CODE = 255;

	/**
	 * 
	 */
	public static final short VERSION = 317;

	/**
	 * 
	 */
	public static final byte MEMORY = 1;

	/**
	 * 
	 */
	public static final byte RSA_OPCODE = 10;

	/**
	 * 
	 */
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