package com.netty.util;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:03:44 PM
 */
public class DirectionUtility {

	/**
	 * 
	 * 
	 * @param dx
	 * 			The id to set.
	 * @param dy
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static byte getDirection(byte dx, byte dy) {
		if (dx < 0) {
			if (dy < 0) {
				return 5;
			} else if (dy > 0) {
				return 0;
			} else {
				return 3;
			}
		} else if (dx > 0) {
			if (dy < 0) {
				return 7;
			} else if (dy > 0) {
				return 2;
			} else {
				return 4;
			}
		} else {
			if (dy < 0) {
				return 6;
			} else if (dy > 0) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}