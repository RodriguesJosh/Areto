package com.netty.stuff;

import com.netty.game.graphics.DrawingArea;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class IndexedImage extends DrawingArea {

	public IndexedImage(JagexArchive jagexArchive, String s, int i) {
		Packet packet = new Packet(jagexArchive.getDataForName(s + ".dat"));
		Packet stream_1 = new Packet(jagexArchive.getDataForName("index.dat"));
		stream_1.setPosition(packet.getUnsignedShort());
		this.libWidth = stream_1.getUnsignedShort();
		this.libHeight = stream_1.getUnsignedShort();
		int j = stream_1.getUnsignedByte();
		this.palette = new int[j];
		for (int k = 0; k < (j - 1); k++) {
			this.palette[k + 1] = stream_1.getTriBytes();
		}
		int position = stream_1.getPosition();
		int secondPosition = packet.getPosition();
		for (int l = 0; l < i; l++) {
			position = position + 2;
			secondPosition = secondPosition + (stream_1.getUnsignedShort() * stream_1.getUnsignedShort());
			position++;
		}
		this.xDrawOffset = stream_1.getUnsignedByte();
		this.yDrawOffset = stream_1.getUnsignedByte();
		this.imgWidth = stream_1.getUnsignedShort();
		this.imgHeight = stream_1.getUnsignedShort();
		int i1 = stream_1.getUnsignedByte();
		int j1 = this.imgWidth * this.imgHeight;
		this.imgPixels = new byte[j1];
		if (i1 == 0) {
			for (int k1 = 0; k1 < j1; k1++) {
				this.imgPixels[k1] = packet.getByte();
			}
			return;
		}
		if (i1 == 1) {
			for (int l1 = 0; l1 < this.imgWidth; l1++) {
				for (int i2 = 0; i2 < this.imgHeight; i2++) {
					this.imgPixels[l1 + (i2 * this.imgWidth)] = packet.getByte();
				}

			}
		}
	}

	public void method356() {
		this.libWidth /= 2;
		this.libHeight /= 2;
		byte abyte0[] = new byte[this.libWidth * this.libHeight];
		int i = 0;
		for (int j = 0; j < this.imgHeight; j++) {
			for (int k = 0; k < this.imgWidth; k++) {
				abyte0[((k + this.xDrawOffset) >> 1) + (((j + this.yDrawOffset) >> 1) * this.libWidth)] = this.imgPixels[i++];
			}
		}
		this.imgPixels = abyte0;
		this.imgWidth = this.libWidth;
		this.imgHeight = this.libHeight;
		this.xDrawOffset = 0;
		this.yDrawOffset = 0;
	}

	public void method357() {
		if ((this.imgWidth == this.libWidth) && (this.imgHeight == this.libHeight)) {
			return;
		}
		byte abyte0[] = new byte[this.libWidth * this.libHeight];
		int i = 0;
		for (int j = 0; j < this.imgHeight; j++) {
			for (int k = 0; k < this.imgWidth; k++) {
				abyte0[k + this.xDrawOffset + ((j + this.yDrawOffset) * this.libWidth)] = this.imgPixels[i++];
			}
		}
		this.imgPixels = abyte0;
		this.imgWidth = this.libWidth;
		this.imgHeight = this.libHeight;
		this.xDrawOffset = 0;
		this.yDrawOffset = 0;
	}

	public void method358() {
		byte abyte0[] = new byte[this.imgWidth * this.imgHeight];
		int j = 0;
		for (int k = 0; k < this.imgHeight; k++) {
			for (int l = this.imgWidth - 1; l >= 0; l--) {
				abyte0[j++] = this.imgPixels[l + (k * this.imgWidth)];
			}
		}
		this.imgPixels = abyte0;
		this.xDrawOffset = this.libWidth - this.imgWidth - this.xDrawOffset;
	}

	public void method359() {
		byte abyte0[] = new byte[this.imgWidth * this.imgHeight];
		int i = 0;
		for (int j = this.imgHeight - 1; j >= 0; j--) {
			for (int k = 0; k < this.imgWidth; k++) {
				abyte0[i++] = this.imgPixels[k + (j * this.imgWidth)];
			}
		}
		this.imgPixels = abyte0;
		this.yDrawOffset = this.libHeight - this.imgHeight - this.yDrawOffset;
	}

	public void method360(int i, int j, int k) {
		for (int i1 = 0; i1 < this.palette.length; i1++) {
			int j1 = (this.palette[i1] >> 16) & 0xff;
			j1 += i;
			if (j1 < 0) {
				j1 = 0;
			} else if (j1 > 255) {
				j1 = 255;
			}
			int k1 = (this.palette[i1] >> 8) & 0xff;
			k1 += j;
			if (k1 < 0) {
				k1 = 0;
			} else if (k1 > 255) {
				k1 = 255;
			}
			int l1 = this.palette[i1] & 0xff;
			l1 += k;
			if (l1 < 0) {
				l1 = 0;
			} else if (l1 > 255) {
				l1 = 255;
			}
			this.palette[i1] = (j1 << 16) + (k1 << 8) + l1;
		}
	}

	public void method361(int i, int k) {
		i += this.xDrawOffset;
		k += this.yDrawOffset;
		int l = i + (k * DrawingArea.width);
		int i1 = 0;
		int j1 = this.imgHeight;
		int k1 = this.imgWidth;
		int l1 = DrawingArea.width - k1;
		int i2 = 0;
		if (k < DrawingArea.topY) {
			int j2 = DrawingArea.topY - k;
			j1 -= j2;
			k = DrawingArea.topY;
			i1 += j2 * k1;
			l += j2 * DrawingArea.width;
		}
		if ((k + j1) > DrawingArea.viewportHeight) {
			j1 -= (k + j1) - DrawingArea.viewportHeight;
		}
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k1 -= k2;
			i = DrawingArea.topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if ((i + k1) > DrawingArea.viewportWidth) {
			int l2 = (i + k1) - DrawingArea.viewportWidth;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (!((k1 <= 0) || (j1 <= 0))) {
			this.method362(j1, DrawingArea.pixels, this.imgPixels, l1, l, k1, i1, this.palette, i2);
		}
	}

	private void method362(int i, int ai[], byte abyte0[], int j, int k, int l, int i1, int ai1[], int j1) {
		int k1 = -(l >> 2);
		l = -(l & 3);
		for (int l1 = -i; l1 < 0; l1++) {
			for (int i2 = k1; i2 < 0; i2++) {
				byte byte1 = abyte0[i1++];
				if (byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
				byte1 = abyte0[i1++];
				if (byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
				byte1 = abyte0[i1++];
				if(byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
				byte1 = abyte0[i1++];
				if(byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
			}

			for(int j2 = l; j2 < 0; j2++)
			{
				byte byte2 = abyte0[i1++];
				if(byte2 != 0) {
					ai[k++] = ai1[byte2 & 0xff];
				} else {
					k++;
				}
			}
			k += j;
			i1 += j1;
		}
	}

	public byte imgPixels[];
	public int[] palette;
	public int imgWidth;
	public int imgHeight;
	public int xDrawOffset;
	public int yDrawOffset;
	public int libWidth;
	private int libHeight;
}