package com.netty.net.cache;

import java.io.IOException;
import java.io.RandomAccessFile;

public class JagexResourceCache {

	public JagexResourceCache(RandomAccessFile randomaccessfile, RandomAccessFile randomaccessfile1, int j) {
		this.storeID = j;
		this.dataFile = randomaccessfile;
		this.indexFile = randomaccessfile1;
	}

	public synchronized byte[] decompress(int i) {
		try {
			this.seekTo(this.indexFile, i * 6);
			int l;
			for (int j = 0; j < 6; j += l) {
				l = this.indexFile.read(JagexResourceCache.buffer, j, 6 - j);
				if (l == -1) {
					return null;
				}
			}
			int i1 = ((JagexResourceCache.buffer[0] & 0xff) << 16) + ((JagexResourceCache.buffer[1] & 0xff) << 8) + (JagexResourceCache.buffer[2] & 0xff);
			int j1 = ((JagexResourceCache.buffer[3] & 0xff) << 16) + ((JagexResourceCache.buffer[4] & 0xff) << 8) + (JagexResourceCache.buffer[5] & 0xff);
			if ((j1 <= 0) || (j1 > (this.dataFile.length() / 520L))) {
				return null;
			}
			byte abyte0[] = new byte[i1];
			int k1 = 0;
			for (int l1 = 0; k1 < i1; l1++) {
				if (j1 == 0) {
					return null;
				}
				this.seekTo(this.dataFile, j1 * 520);
				int k = 0;
				int i2 = i1 - k1;
				if (i2 > 512) {
					i2 = 512;
				}
				int j2;
				for (; k < (i2 + 8); k += j2) {
					j2 = this.dataFile.read(JagexResourceCache.buffer, k, (i2 + 8) - k);
					if (j2 == -1) {
						return null;
					}
				}
				int k2 = ((JagexResourceCache.buffer[0] & 0xff) << 8) + (JagexResourceCache.buffer[1] & 0xff);
				int l2 = ((JagexResourceCache.buffer[2] & 0xff) << 8) + (JagexResourceCache.buffer[3] & 0xff);
				int i3 = ((JagexResourceCache.buffer[4] & 0xff) << 16) + ((JagexResourceCache.buffer[5] & 0xff) << 8) + (JagexResourceCache.buffer[6] & 0xff);
				int j3 = JagexResourceCache.buffer[7] & 0xff;
				if ((k2 != i) || (l2 != l1) || (j3 != this.storeID)) {
					return null;
				}
				if ((i3 < 0) || (i3 > (this.dataFile.length() / 520L))) {
					return null;
				}
				for (int k3 = 0; k3 < i2; k3++) {
					abyte0[k1++] = JagexResourceCache.buffer[k3 + 8];
				}
				j1 = i3;
			}
			return abyte0;
		} catch (IOException ioe) {
			return null;
		}
	}

	public synchronized boolean method234(int i, byte abyte0[], int j) {
		boolean flag = this.method235(true, j, i, abyte0);
		if (!flag) {
			flag = this.method235(false, j, i, abyte0);
		}
		return flag;
	}

	private synchronized boolean method235(boolean flag, int j, int k, byte abyte0[]) {
		try {
			int l;
			if (flag) {
				this.seekTo(this.indexFile, j * 6);
				int k1;
				for (int i1 = 0; i1 < 6; i1 += k1) {
					k1 = this.indexFile.read(JagexResourceCache.buffer, i1, 6 - i1);
					if (k1 == -1) {
						return false;
					}
				}
				l = ((JagexResourceCache.buffer[3] & 0xff) << 16) + ((JagexResourceCache.buffer[4] & 0xff) << 8) + (JagexResourceCache.buffer[5] & 0xff);
				if ((l <= 0) || (l > (this.dataFile.length() / 520L))) {
					return false;
				}
			} else {
				l = (int) ((this.dataFile.length() + 519L) / 520L);
				if (l == 0) {
					l = 1;
				}
			}
			JagexResourceCache.buffer[0] = (byte) (k >> 16);
			JagexResourceCache.buffer[1] = (byte) (k >> 8);
			JagexResourceCache.buffer[2] = (byte) k;
			JagexResourceCache.buffer[3] = (byte) (l >> 16);
			JagexResourceCache.buffer[4] = (byte) (l >> 8);
			JagexResourceCache.buffer[5] = (byte) l;
			this.seekTo(this.indexFile, j * 6);
			this.indexFile.write(JagexResourceCache.buffer, 0, 6);
			int j1 = 0;
			for (int l1 = 0; j1 < k; l1++) {
				int i2 = 0;
				if (flag) {
					this.seekTo(this.dataFile, l * 520);
					int j2;
					int l2;
					for (j2 = 0; j2 < 8; j2 += l2) {
						l2 = this.dataFile.read(JagexResourceCache.buffer, j2, 8 - j2);
						if (l2 == -1) {
							break;
						}
					}
					if (j2 == 8) {
						int i3 = ((JagexResourceCache.buffer[0] & 0xff) << 8) + (JagexResourceCache.buffer[1] & 0xff);
						int j3 = ((JagexResourceCache.buffer[2] & 0xff) << 8) + (JagexResourceCache.buffer[3] & 0xff);
						i2 = ((JagexResourceCache.buffer[4] & 0xff) << 16) + ((JagexResourceCache.buffer[5] & 0xff) << 8) + (JagexResourceCache.buffer[6] & 0xff);
						int k3 = JagexResourceCache.buffer[7] & 0xff;
						if ((i3 != j) || (j3 != l1) || (k3 != this.storeID)) {
							return false;
						}
						if ((i2 < 0) || (i2 > (this.dataFile.length() / 520L))) {
							return false;
						}
					}
				}
				if (i2 == 0) {
					flag = false;
					i2 = (int)((this.dataFile.length() + 519L) / 520L);
					if (i2 == 0) {
						i2++;
					}
					if (i2 == l) {
						i2++;
					}
				}
				if ((k - j1) <= 512) {
					i2 = 0;
				}
				JagexResourceCache.buffer[0] = (byte)(j >> 8);
				JagexResourceCache.buffer[1] = (byte)j;
				JagexResourceCache.buffer[2] = (byte)(l1 >> 8);
				JagexResourceCache.buffer[3] = (byte)l1;
				JagexResourceCache.buffer[4] = (byte)(i2 >> 16);
				JagexResourceCache.buffer[5] = (byte)(i2 >> 8);
				JagexResourceCache.buffer[6] = (byte)i2;
				JagexResourceCache.buffer[7] = (byte)this.storeID;
				this.seekTo(this.dataFile, l * 520);
				this.dataFile.write(JagexResourceCache.buffer, 0, 8);
				int k2 = k - j1;
				if (k2 > 512) {
					k2 = 512;
				}
				this.dataFile.write(abyte0, j1, k2);
				j1 += k2;
				l = i2;
			}
			return true;
		} catch (IOException ioe) {
			return false;
		}
	}

	private synchronized void seekTo(RandomAccessFile randomaccessfile, int j) throws IOException {
		if ((j < 0) || (j > 0x3c00000)) {
			System.out.println("Badseek - pos:" + j + " len:" + randomaccessfile.length());
			j = 0x3c00000;
			try {
				Thread.sleep(1000L);
			} catch (Exception e) {}
		}
		randomaccessfile.seek(j);
	}

	private static byte[] buffer = new byte[520];
	private RandomAccessFile dataFile;
	private RandomAccessFile indexFile;
	private int storeID;
}