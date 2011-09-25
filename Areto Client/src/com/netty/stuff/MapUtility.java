package com.netty.stuff;

public class MapUtility {

	public static int getRotatedMapX(int rotation, int y, int x) {
		rotation &= 3;
		if (rotation == 0) {
			return x;
		}
		if (rotation == 1) {
			return y;
		}
		if (rotation == 2) {
			return 7 - x;
		}
		return 7 - y;
	}

	public static int getRotatedMapY(int y, int rotation, int x) {
		rotation &= 3;
		if (rotation == 0) {
			return y;
		}
		if (rotation == 1) {
			return 7 - x;
		}
		if (rotation == 2) {
			return 7 - y;
		}
		return x;
	}

	public static int getRotatedLandScapeX(int rotation, int objectSizeY, int x, int y, int objectSizeX) {
		rotation &= 3;
		if (rotation == 0) {
			return x;
		}
		if (rotation == 1) {
			return y;
		}
		if (rotation == 2) {
			return 7 - x - (objectSizeX - 1);
		}
		return 7 - y - (objectSizeY - 1);
	}

	public static int getRotatedLandScapeY(int y, int objectSizeY, int rotation, int objectSizeX, int x) {
		rotation &= 3;
		if (rotation == 0) {
			return y;
		}
		if (rotation == 1) {
			return 7 - x - (objectSizeX - 1);
		}
		if (rotation == 2) {
			return 7 - y - (objectSizeY - 1);
		}
		return x;
	}
}