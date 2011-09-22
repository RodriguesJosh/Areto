package com.netty.util.text;

import java.util.Random;

import com.netty.game.graphics.DrawingArea;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class RSFont extends DrawingArea {

	public RSFont(boolean flag, String s, JagexArchive jagexArchive) {
		this.glyphPixels = new byte[256][];
		this.glyphWidth = new int[256];
		this.glyphHeight = new int[256];
		this.horizontalKerning = new int[256];
		this.verticalKerning = new int[256];
		this.charEffectiveWidth = new int[256];
		this.random = new Random();
		this.isStrikeThrough = false;
		Packet packet = new Packet(jagexArchive.getDataForName(s + ".dat"));
		Packet stream_1 = new Packet(jagexArchive.getDataForName("index.dat"));
		stream_1.setPosition(packet.getUnsignedShort() + 4);
		int k = stream_1.getUnsignedByte();
		int position = stream_1.getPosition();
		if (k > 0) {
			position = position + (3 * (k - 1));
		}
		for (int l = 0; l < 256; l++) {
			this.horizontalKerning[l] = stream_1.getUnsignedByte();
			this.verticalKerning[l] = stream_1.getUnsignedByte();
			int i1 = this.glyphWidth[l] = stream_1.getUnsignedShort();
			int j1 = this.glyphHeight[l] = stream_1.getUnsignedShort();
			int k1 = stream_1.getUnsignedByte();
			int l1 = i1 * j1;
			this.glyphPixels[l] = new byte[l1];
			if (k1 == 0) {
				for(int i2 = 0; i2 < l1; i2++) {
					this.glyphPixels[l][i2] = packet.getByte();
				}

			} else if (k1 == 1) {
				for (int j2 = 0; j2 < i1; j2++) {
					for (int l2 = 0; l2 < j1; l2++) {
						this.glyphPixels[l][j2 + (l2 * i1)] = packet.getByte();
					}
				}
			}
			if ((j1 > this.charHeight) && (l < 128)) {
				this.charHeight = j1;
			}
			this.horizontalKerning[l] = 1;
			this.charEffectiveWidth[l] = i1 + 2;
			int k2 = 0;
			for (int i3 = j1 / 7; i3 < j1; i3++) {
				k2 += this.glyphPixels[l][i3 * i1];
			}
			if (k2 <= (j1 / 7)) {
				this.charEffectiveWidth[l]--;
				this.horizontalKerning[l] = 0;
			}
			k2 = 0;
			for (int j3 = j1 / 7; j3 < j1; j3++) {
				k2 += this.glyphPixels[l][(i1 - 1) + (j3 * i1)];
			}

			if (k2 <= (j1 / 7)) {
				this.charEffectiveWidth[l]--;
			}
		}
		if (flag) {
			this.charEffectiveWidth[32] = this.charEffectiveWidth[73];
		} else {
			this.charEffectiveWidth[32] = this.charEffectiveWidth[105];
		}
	}

	public void method380(String s, int i, int j, int k) {
		this.method385(j, s, k, i - this.method384(s));
	}

	public void drawText(int i, String s, int k, int l) {
		this.method385(i, s, k, l - (this.method384(s) / 2));
	}

	public void method382(int i, int j, String s, int l, boolean flag) {
		this.method389(flag, j - (this.getTextWidth(s) / 2), i, s, l);
	}

	public int getTextWidth(String s) {
		if (s == null) {
			return 0;
		}
		int j = 0;
		for (int k = 0; k < s.length(); k++) {
			if ((s.charAt(k) == '@') && ((k + 4) < s.length()) && (s.charAt(k + 4) == '@')) {
				k += 4;
			} else {
				j += this.charEffectiveWidth[s.charAt(k)];
			}
		}
		return j;
	}

	public int method384(String s) {
		if (s == null) {
			return 0;
		}
		int j = 0;
		for (int k = 0; k < s.length(); k++) {
			j += this.charEffectiveWidth[s.charAt(k)];
		}
		return j;
	}

	public void method385(int i, String s, int j, int l) {
		if (s == null) {
			return;
		}
		j -= this.charHeight;
		for (int i1 = 0; i1 < s.length(); i1++) {
			char c = s.charAt(i1);
			if (c != ' ') {
				this.method392(this.glyphPixels[c], l + this.horizontalKerning[c], j + this.verticalKerning[c], this.glyphWidth[c], this.glyphHeight[c], i);
			}
			l += this.charEffectiveWidth[c];
		}
	}

	public void method386(int i, String s, int j, int k, int l) {
		if (s == null) {
			return;
		}
		j -= this.method384(s) / 2;
		l -= this.charHeight;
		for (int i1 = 0; i1 < s.length(); i1++) {
			char c = s.charAt(i1);
			if (c != ' ') {
				this.method392(this.glyphPixels[c], j + this.horizontalKerning[c], l + this.verticalKerning[c] + (int)(Math.sin((i1 / 2D) + (k / 5D)) * 5D), this.glyphWidth[c], this.glyphHeight[c], i);
			}
			j += this.charEffectiveWidth[c];
		}
	}

	public void method387(int i, String s, int j, int k, int l) {
		if (s == null) {
			return;
		}
		i -= this.method384(s) / 2;
		k -= this.charHeight;
		for (int i1 = 0; i1 < s.length(); i1++) {
			char c = s.charAt(i1);
			if (c != ' ') {
				this.method392(this.glyphPixels[c], i + this.horizontalKerning[c] + (int)(Math.sin((i1 / 5D) + (j / 5D)) * 5D), k + this.verticalKerning[c] + (int)(Math.sin((i1 / 3D) + (j / 5D)) * 5D), this.glyphWidth[c], this.glyphHeight[c], l);
			}
			i += this.charEffectiveWidth[c];
		}
	}

	public void method388(int i, String s, int j, int k, int l, int i1) {
		if (s == null) {
			return;
		}
		double d = 7D - (i / 8D);
		if (d < 0.0D) {
			d = 0.0D;
		}
		l -= this.method384(s) / 2;
		k -= this.charHeight;
		for (int k1 = 0; k1 < s.length(); k1++) {
			char c = s.charAt(k1);
			if (c != ' ') {
				this.method392(this.glyphPixels[c], l + this.horizontalKerning[c], k + this.verticalKerning[c] + (int)(Math.sin((k1 / 1.5D) + j) * d), this.glyphWidth[c], this.glyphHeight[c], i1);
			}
			l += this.charEffectiveWidth[c];
		}
	}

	public void method389(boolean flag1, int i, int j, String s, int k) {
		this.isStrikeThrough = false;
		int l = i;
		if (s == null) {
			return;
		}
		k -= this.charHeight;
		for (int i1 = 0; i1 < s.length(); i1++) {
			if ((s.charAt(i1) == '@') && ((i1 + 4) < s.length()) && (s.charAt(i1 + 4) == '@')) {
				int j1 = this.getColorByName(s.substring(i1 + 1, i1 + 4));
				if(j1 != -1) {
					j = j1;
				}
				i1 += 4;
			} else {
				char c = s.charAt(i1);
				if (c != ' ') {
					if (flag1) {
						this.method392(this.glyphPixels[c], i + this.horizontalKerning[c] + 1, k + this.verticalKerning[c] + 1, this.glyphWidth[c], this.glyphHeight[c], 0);
					}
					this.method392(this.glyphPixels[c], i + this.horizontalKerning[c], k + this.verticalKerning[c], this.glyphWidth[c], this.glyphHeight[c], j);
				}
				i += this.charEffectiveWidth[c];
			}
		}
		if (this.isStrikeThrough) {
			DrawingArea.method339(k + (int)(this.charHeight * 0.69999999999999996D), 0x800000, i - l, l);
		}
	}

	public void method390(int i, int j, String s, int k, int i1) {
		if (s == null) {
			return;
		}
		this.random.setSeed(k);
		int j1 = 192 + (this.random.nextInt() & 0x1f);
		i1 -= this.charHeight;
		for (int k1 = 0; k1 < s.length(); k1++) {
			if ((s.charAt(k1) == '@') && ((k1 + 4) < s.length()) && (s.charAt(k1 + 4) == '@')) {
				int l1 = this.getColorByName(s.substring(k1 + 1, k1 + 4));
				if (l1 != -1) {
					j = l1;
				}
				k1 += 4;
			} else {
				char c = s.charAt(k1);
				if (c != ' ') {
					this.method394(192, i + this.horizontalKerning[c] + 1, this.glyphPixels[c], this.glyphWidth[c], i1 + this.verticalKerning[c] + 1, this.glyphHeight[c], 0);
					this.method394(j1, i + this.horizontalKerning[c], this.glyphPixels[c], this.glyphWidth[c], i1 + this.verticalKerning[c], this.glyphHeight[c], j);
				}
				i += this.charEffectiveWidth[c];
				if ((this.random.nextInt() & 3) == 0) {
					i++;
				}
			}
		}
	}

	private int getColorByName(String s) {
		if (s.equals("red")) {
			return 0xff0000;
		}
		if (s.equals("gre")) {
			return 65280;
		}
		if (s.equals("blu")) {
			return 255;
		}
		if (s.equals("yel")) {
			return 0xffff00;
		}
		if (s.equals("cya")) {
			return 65535;
		}
		if (s.equals("mag")) {
			return 0xff00ff;
		}
		if (s.equals("whi")) {
			return 0xffffff;
		}
		if (s.equals("bla")) {
			return 0;
		}
		if (s.equals("lre")) {
			return 0xff9040;
		}
		if (s.equals("dre")) {
			return 0x800000;
		}
		if (s.equals("dbl")) {
			return 128;
		}
		if (s.equals("or1")) {
			return 0xffb000;
		}
		if (s.equals("or2")) {
			return 0xff7000;
		}
		if (s.equals("or3")) {
			return 0xff3000;
		}
		if (s.equals("gr1")) {
			return 0xc0ff00;
		}
		if (s.equals("gr2")) {
			return 0x80ff00;
		}
		if (s.equals("gr3")) {
			return 0x40ff00;
		}
		if (s.equals("str")) {
			this.isStrikeThrough = true;
		}
		if (s.equals("end")) {
			this.isStrikeThrough = false;
		}
		return -1;
	}

	private void method392(byte abyte0[], int i, int j, int k, int l, int i1) {
		int j1 = i + (j * DrawingArea.width);
		int k1 = DrawingArea.width - k;
		int l1 = 0;
		int i2 = 0;
		if (j < DrawingArea.topY) {
			int j2 = DrawingArea.topY - j;
			l -= j2;
			j = DrawingArea.topY;
			i2 += j2 * k;
			j1 += j2 * DrawingArea.width;
		}
		if ((j + l) >= DrawingArea.viewportHeight) {
			l -= ((j + l) - DrawingArea.viewportHeight) + 1;
		}
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k -= k2;
			i = DrawingArea.topX;
			i2 += k2;
			j1 += k2;
			l1 += k2;
			k1 += k2;
		}
		if ((i + k) >= DrawingArea.viewportWidth) {
			int l2 = ((i + k) - DrawingArea.viewportWidth) + 1;
			k -= l2;
			l1 += l2;
			k1 += l2;
		}
		if (!((k <= 0) || (l <= 0))) {
			this.method393(DrawingArea.pixels, abyte0, i1, i2, j1, k, l, k1, l1);
		}
	}

	private void method393(int ai[], byte abyte0[], int i, int j, int k, int l, int i1,	int j1, int k1) {
		int l1 = -(l >> 2);
		l = -(l & 3);
		for (int i2 = -i1; i2 < 0; i2++) {
			for (int j2 = l1; j2 < 0; j2++) {
				if (abyte0[j++] != 0) {
					ai[k++] = i;
				} else {
					k++;
				}
				if (abyte0[j++] != 0) {
					ai[k++] = i;
				} else {
					k++;
				}
				if (abyte0[j++] != 0) {
					ai[k++] = i;
				} else {
					k++;
				}
				if (abyte0[j++] != 0) {
					ai[k++] = i;
				} else {
					k++;
				}
			}
			for (int k2 = l; k2 < 0; k2++) {
				if (abyte0[j++] != 0) {
					ai[k++] = i;
				} else {
					k++;
				}
			}
			k += j1;
			j += k1;
		}
	}

	private void method394(int i, int j, byte abyte0[], int k, int l, int i1, int j1) {
		int k1 = j + (l * DrawingArea.width);
		int l1 = DrawingArea.width - k;
		int i2 = 0;
		int j2 = 0;
		if (l < DrawingArea.topY) {
			int k2 = DrawingArea.topY - l;
			i1 -= k2;
			l = DrawingArea.topY;
			j2 += k2 * k;
			k1 += k2 * DrawingArea.width;
		}
		if ((l + i1) >= DrawingArea.viewportHeight) {
			i1 -= ((l + i1) - DrawingArea.viewportHeight) + 1;
		}
		if (j < DrawingArea.topX) {
			int l2 = DrawingArea.topX - j;
			k -= l2;
			j = DrawingArea.topX;
			j2 += l2;
			k1 += l2;
			i2 += l2;
			l1 += l2;
		}
		if ((j + k) >= DrawingArea.viewportWidth) {
			int i3 = ((j + k) - DrawingArea.viewportWidth) + 1;
			k -= i3;
			i2 += i3;
			l1 += i3;
		}
		if ((k <= 0) || (i1 <= 0)) {
			return;
		}
		this.method395(abyte0, i1, k1, DrawingArea.pixels, j2, k, i2, l1, j1, i);
	}

	private void method395(byte abyte0[], int i, int j, int ai[], int l, int i1, int j1, int k1, int l1, int i2) {
		l1 = ((((l1 & 0xff00ff) * i2) & 0xff00ff00) + (((l1 & 0xff00) * i2) & 0xff0000)) >> 8;
		i2 = 256 - i2;
		for (int j2 = -i; j2 < 0; j2++) {
			for (int k2 = -i1; k2 < 0; k2++) {
				if (abyte0[l++] != 0) {
					int l2 = ai[j];
					ai[j++] = (((((l2 & 0xff00ff) * i2) & 0xff00ff00) + (((l2 & 0xff00) * i2) & 0xff0000)) >> 8) + l1;
				} else {
					j++;
				}
			}
			j += k1;
			l += j1;
		}
	}

	private byte[][] glyphPixels;
	private int[] glyphWidth;
	private int[] glyphHeight;
	private int[] horizontalKerning;
	private int[] verticalKerning;
	private int[] charEffectiveWidth;
	public int charHeight;
	private Random random;
	private boolean isStrikeThrough;
}