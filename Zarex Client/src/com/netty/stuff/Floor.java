package com.netty.stuff;

import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class Floor {

	public static void unpackConfig(JagexArchive jagexArchive) {
		Packet packet = new Packet(jagexArchive.getDataForName("flo.dat"));
		int cacheSize = packet.getUnsignedShort();
		if (Floor.cache == null) {
			Floor.cache = new Floor[cacheSize];
		}
		for (int j = 0; j < cacheSize; j++) {
			if (Floor.cache[j] == null) {
				Floor.cache[j] = new Floor();
			}
			Floor.cache[j].readValues(packet);
		}
	}

	private void readValues(Packet packet) {
		do {
			int i = packet.getUnsignedByte();
			@SuppressWarnings("unused")
			boolean dummy;
			if (i == 0) {
				return;
			} else if (i == 1) {
				this.colourTwo = packet.getTriBytes();
				this.method262(this.colourTwo);
			} else if (i == 2) {
				this.texture = packet.getUnsignedByte();
			} else if (i == 3) {
				dummy = true;
			} else if (i == 5) {
				this.occlude = false;
			} else if (i == 6) {
				packet.getString();
			} else if (i == 7) {
				int j = this.hue;
				int k = this.saturation;
				int l = this.lightness;
				int i1 = this.hue2;
				int j1 = packet.getTriBytes();
				this.method262(j1);
				this.hue = j;
				this.saturation = k;
				this.lightness = l;
				this.hue2 = i1;
				this.pCDivider = i1;
			} else {
				System.out.println("Error unrecognised config code: " + i);
			}
		} while (true);
	}

	private void method262(int i) {
		double d = ((i >> 16) & 0xff) / 256D;
		double d1 = ((i >> 8) & 0xff) / 256D;
		double d2 = (i & 0xff) / 256D;
		double d3 = d;
		if (d1 < d3) {
			d3 = d1;
		}
		if (d2 < d3) {
			d3 = d2;
		}
		double d4 = d;
		if (d1 > d4) {
			d4 = d1;
		}
		if (d2 > d4) {
			d4 = d2;
		}
		double d5 = 0.0D;
		double d6 = 0.0D;
		double d7 = (d3 + d4) / 2D;
		if (d3 != d4) {
			if (d7 < 0.5D) {
				d6 = (d4 - d3) / (d4 + d3);
			}
			if (d7 >= 0.5D) {
				d6 = (d4 - d3) / (2D - d4 - d3);
			}
			if (d == d4) {
				d5 = (d1 - d2) / (d4 - d3);
			} else if (d1 == d4) {
				d5 = 2D + ((d2 - d) / (d4 - d3));
			} else if (d2 == d4) {
				d5 = 4D + ((d - d1) / (d4 - d3));
			}
		}
		d5 /= 6D;
		this.hue = (int)(d5 * 256D);
		this.saturation = (int)(d6 * 256D);
		this.lightness = (int)(d7 * 256D);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}
		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}
		if (d7 > 0.5D) {
			this.pCDivider = (int)((1.0D - d7) * d6 * 512D);
		} else {
			this.pCDivider = (int)(d7 * d6 * 512D);
		}
		if (this.pCDivider < 1) {
			this.pCDivider = 1;
		}
		this.hue2 = (int)(d5 * this.pCDivider);
		int k = (this.hue + (int)(Math.random() * 16D)) - 8;
		if (k < 0) {
			k = 0;
		} else if (k > 255) {
			k = 255;
		}
		int l = (this.saturation + (int)(Math.random() * 48D)) - 24;
		if (l < 0) {
			l = 0;
		} else if (l > 255) {
			l = 255;
		}
		int i1 = (this.lightness + (int)(Math.random() * 48D)) - 24;
		if (i1 < 0) {
			i1 = 0;
		} else if (i1 > 255) {
			i1 = 255;
		}
		this.anInt399 = this.method263(k, l, i1);
	}

	private int method263(int i, int j, int k) {
		if (k > 179) {
			j /= 2;
		}
		if (k > 192) {
			j /= 2;
		}
		if (k > 217) {
			j /= 2;
		}
		if (k > 243) {
			j /= 2;
		}
		return ((i / 4) << 10) + ((j / 32) << 7) + (k / 2);
	}

	private Floor() {
		this.texture = -1;
		this.occlude = true;
	}

	public static Floor cache[];
	public int colourTwo;
	public int texture;
	public boolean occlude;
	public int hue;
	public int saturation;
	public int lightness;
	public int hue2;
	public int pCDivider;
	public int anInt399;
}