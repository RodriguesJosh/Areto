package com.netty.util;

import com.netty.model.player.minigame.fistguthix.FistOfGuthix;

/**
 * Contains constant fields throughout the
 * RuneScape Netty Server.
 * @author Josh
 * @since 0.1
 */
public class Constants {

	/**
	 * An array contains with x coordinates
	 * for the direction to walk or run in.
	 */
	public static final byte[] DIRECTION_DELTA_X = { -1, 0, 1, -1, 1, -1, 0, 1 };

	/**
	 * An array contains with y coordinates
	 * for the direction to walk or run in.
	 */
	public static final byte[] DIRECTION_DELTA_Y = { 1, 1, 1, 0, 0, -1, -1, -1 };

	/**
	 * The maximum amount of stone charges
	 * you can obtain in the {@link FistOfGuthix}
	 * minigame.
	 */
	public static final short MAX_STONE_POWER_CHARGES = 5000;

	/**
	 * The maximum amount of zeal experience
	 * you can receive.
	 */
	public static final short MAX_ZEAL_EXPERIENCE = 8400;

	/**
	 * 
	 * 
	 */
	public static final char[] VALID_CHARACTERS = {
		'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@',
		'#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', ':', ';',
		'.', '>', '<', ',', '"', '[', ']', '|', '?', '/', '`'
	};

	/**
	 * 
	 * 
	 */
	public static final char[] XLATE_TABLE = {
		' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u',
		'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q',
		'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!',
		'?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@',
		'#', '+', '=', '\243', '$', '%', '"', '[', ']'
	};
}
