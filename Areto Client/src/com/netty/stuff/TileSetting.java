package com.netty.stuff;

public class TileSetting {

	public TileSetting() {
		this.anInt290 = 0;
		this.anInt291 = 0;
		this.sizeX = 104;
		this.sizeY = 104;
		this.clipData = new int[this.sizeX][this.sizeY];
		this.method210();
	}

	public void method210() {
		for (int i = 0; i < this.sizeX; i++) {
			for (int j = 0; j < this.sizeY; j++) {
				if ((i == 0) || (j == 0) || (i == (this.sizeX - 1)) || (j == (this.sizeY - 1))) {
					this.clipData[i][j] = 0xffffff;
				} else {
					this.clipData[i][j] = 0x1000000;
				}
			}
		}
	}

	public void method211(int i, int j, int k, int l, boolean flag) {
		k -= this.anInt290;
		i -= this.anInt291;
		if (l == 0) {
			if (j == 0) {
				this.method214(k, i, 128);
				this.method214(k - 1, i, 8);
			}
			if (j == 1) {
				this.method214(k, i, 2);
				this.method214(k, i + 1, 32);
			}
			if (j == 2) {
				this.method214(k, i, 8);
				this.method214(k + 1, i, 128);
			}
			if (j == 3) {
				this.method214(k, i, 32);
				this.method214(k, i - 1, 2);
			}
		}
		if ((l == 1) || (l == 3)) {
			if (j == 0) {
				this.method214(k, i, 1);
				this.method214(k - 1, i + 1, 16);
			}
			if (j == 1) {
				this.method214(k, i, 4);
				this.method214(k + 1, i + 1, 64);
			}
			if (j == 2) {
				this.method214(k, i, 16);
				this.method214(k + 1, i - 1, 1);
			}
			if (j == 3) {
				this.method214(k, i, 64);
				this.method214(k - 1, i - 1, 4);
			}
		}
		if (l == 2) {
			if (j == 0) {
				this.method214(k, i, 130);
				this.method214(k - 1, i, 8);
				this.method214(k, i + 1, 32);
			}
			if (j == 1) {
				this.method214(k, i, 10);
				this.method214(k, i + 1, 32);
				this.method214(k + 1, i, 128);
			}
			if (j == 2) {
				this.method214(k, i, 40);
				this.method214(k + 1, i, 128);
				this.method214(k, i - 1, 2);
			}
			if (j == 3) {
				this.method214(k, i, 160);
				this.method214(k, i - 1, 2);
				this.method214(k - 1, i, 8);
			}
		}
		if (flag) {
			if (l == 0) {
				if (j == 0) {
					this.method214(k, i, 0x10000);
					this.method214(k - 1, i, 4096);
				}
				if (j == 1) {
					this.method214(k, i, 1024);
					this.method214(k, i + 1, 16384);
				}
				if(j == 2) {
					this.method214(k, i, 4096);
					this.method214(k + 1, i, 0x10000);
				}
				if (j == 3) {
					this.method214(k, i, 16384);
					this.method214(k, i - 1, 1024);
				}
			}
			if ((l == 1) || (l == 3)) {
				if (j == 0) {
					this.method214(k, i, 512);
					this.method214(k - 1, i + 1, 8192);
				}
				if (j == 1)
				{
					this.method214(k, i, 2048);
					this.method214(k + 1, i + 1, 32768);
				}
				if (j == 2)
				{
					this.method214(k, i, 8192);
					this.method214(k + 1, i - 1, 512);
				}
				if (j == 3) {
					this.method214(k, i, 32768);
					this.method214(k - 1, i - 1, 2048);
				}
			}
			if (l == 2) {
				if (j == 0) {
					this.method214(k, i, 0x10400);
					this.method214(k - 1, i, 4096);
					this.method214(k, i + 1, 16384);
				}
				if (j == 1) {
					this.method214(k, i, 5120);
					this.method214(k, i + 1, 16384);
					this.method214(k + 1, i, 0x10000);
				}
				if (j == 2) {
					this.method214(k, i, 20480);
					this.method214(k + 1, i, 0x10000);
					this.method214(k, i - 1, 1024);
				}
				if (j == 3) {
					this.method214(k, i, 0x14000);
					this.method214(k, i - 1, 1024);
					this.method214(k - 1, i, 4096);
				}
			}
		}
	}

	public void method212(boolean flag, int j, int k, int l, int i1, int j1) {
		int k1 = 256;
		if (flag) {
			k1 += 0x20000;
		}
		l -= this.anInt290;
		i1 -= this.anInt291;
		if ((j1 == 1) || (j1 == 3)) {
			int l1 = j;
			j = k;
			k = l1;
		}
		for (int i2 = l; i2 < (l + j); i2++) {
			if ((i2 >= 0) && (i2 < this.sizeX)) {
				for (int j2 = i1; j2 < (i1 + k); j2++) {
					if ((j2 >= 0) && (j2 < this.sizeY)) {
						this.method214(i2, j2, k1);
					}
				}
			}
		}
	}

	public void method213(int i, int k) {
		k -= this.anInt290;
		i -= this.anInt291;
		this.clipData[k][i] |= 0x200000;
	}

	private void method214(int i, int j, int k) {
		this.clipData[i][j] |= k;
	}

	public void method215(int i, int j, boolean flag, int k, int l) {
		k -= this.anInt290;
		l -= this.anInt291;
		if (j == 0) {
			if (i == 0) {
				this.method217(128, k, l);
				this.method217(8, k - 1, l);
			}
			if (i == 1) {
				this.method217(2, k, l);
				this.method217(32, k, l + 1);
			}
			if (i == 2) {
				this.method217(8, k, l);
				this.method217(128, k + 1, l);
			}
			if (i == 3) {
				this.method217(32, k, l);
				this.method217(2, k, l - 1);
			}
		}
		if ((j == 1) || (j == 3)) {
			if (i == 0)
			{
				this.method217(1, k, l);
				this.method217(16, k - 1, l + 1);
			}
			if (i == 1) {
				this.method217(4, k, l);
				this.method217(64, k + 1, l + 1);
			}
			if (i == 2) {
				this.method217(16, k, l);
				this.method217(1, k + 1, l - 1);
			}
			if (i == 3) {
				this.method217(64, k, l);
				this.method217(4, k - 1, l - 1);
			}
		}
		if (j == 2) {
			if (i == 0) {
				this.method217(130, k, l);
				this.method217(8, k - 1, l);
				this.method217(32, k, l + 1);
			}
			if (i == 1) {
				this.method217(10, k, l);
				this.method217(32, k, l + 1);
				this.method217(128, k + 1, l);
			}
			if (i == 2) {
				this.method217(40, k, l);
				this.method217(128, k + 1, l);
				this.method217(2, k, l - 1);
			}
			if (i == 3) {
				this.method217(160, k, l);
				this.method217(2, k, l - 1);
				this.method217(8, k - 1, l);
			}
		}
		if (flag) {
			if (j == 0) {
				if(i == 0) {
					this.method217(0x10000, k, l);
					this.method217(4096, k - 1, l);
				}
				if (i == 1) {
					this.method217(1024, k, l);
					this.method217(16384, k, l + 1);
				}
				if (i == 2) {
					this.method217(4096, k, l);
					this.method217(0x10000, k + 1, l);
				}
				if (i == 3) {
					this.method217(16384, k, l);
					this.method217(1024, k, l - 1);
				}
			}
			if ((j == 1) || (j == 3)) {
				if (i == 0) {
					this.method217(512, k, l);
					this.method217(8192, k - 1, l + 1);
				}
				if (i == 1) {
					this.method217(2048, k, l);
					this.method217(32768, k + 1, l + 1);
				}
				if (i == 2) {
					this.method217(8192, k, l);
					this.method217(512, k + 1, l - 1);
				}
				if (i == 3) {
					this.method217(32768, k, l);
					this.method217(2048, k - 1, l - 1);
				}
			}
			if (j == 2) {
				if (i == 0) {
					this.method217(0x10400, k, l);
					this.method217(4096, k - 1, l);
					this.method217(16384, k, l + 1);
				}
				if (i == 1) {
					this.method217(5120, k, l);
					this.method217(16384, k, l + 1);
					this.method217(0x10000, k + 1, l);
				}
				if (i == 2) {
					this.method217(20480, k, l);
					this.method217(0x10000, k + 1, l);
					this.method217(1024, k, l - 1);
				}
				if (i == 3) {
					this.method217(0x14000, k, l);
					this.method217(1024, k, l - 1);
					this.method217(4096, k - 1, l);
				}
			}
		}
	}

	public void method216(int i, int j, int k, int l, int i1, boolean flag) {
		int j1 = 256;
		if (flag) {
			j1 += 0x20000;
		}
		k -= this.anInt290;
		l -= this.anInt291;
		if ((i == 1) || (i == 3)) {
			int k1 = j;
			j = i1;
			i1 = k1;
		}
		for (int l1 = k; l1 < (k + j); l1++) {
			if ((l1 >= 0) && (l1 < this.sizeX)) {
				for (int i2 = l; i2 < (l + i1); i2++) {
					if ((i2 >= 0) && (i2 < this.sizeY)) {
						this.method217(j1, l1, i2);
					}
				}
			}
		}
	}

	private void method217(int i, int j, int k) {
		this.clipData[j][k] &= 0xffffff - i;
	}

	public void method218(int j, int k) {
		k -= this.anInt290;
		j -= this.anInt291;
		this.clipData[k][j] &= 0xdfffff;
	}

	public boolean method219(int i, int j, int k, int i1, int j1, int k1) {
		if ((j == i) && (k == k1)) {
			return true;
		}
		j -= this.anInt290;
		k -= this.anInt291;
		i -= this.anInt290;
		k1 -= this.anInt291;
		if (j1 == 0) {
			if (i1 == 0) {
				if ((j == (i - 1)) && (k == k1)) {
					return true;
				}
				if ((j == i) && (k == (k1 + 1)) && ((this.clipData[j][k] & 0x1280120) == 0)) {
					return true;
				}
				if ((j == i) && (k == (k1 - 1)) && ((this.clipData[j][k] & 0x1280102) == 0)) {
					return true;
				}
			} else if (i1 == 1) {
				if ((j == i) && (k == (k1 + 1))) {
					return true;
				}
				if ((j == (i - 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280108) == 0)) {
					return true;
				}
				if ((j == (i + 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280180) == 0)) {
					return true;
				}
			} else if (i1 == 2) {
				if ((j == (i + 1)) && (k == k1)) {
					return true;
				}
				if ((j == i) && (k == (k1 + 1)) && ((this.clipData[j][k] & 0x1280120) == 0)) {
					return true;
				}
				if ((j == i) && (k == (k1 - 1)) && ((this.clipData[j][k] & 0x1280102) == 0)) {
					return true;
				}
			} else if (i1 == 3) {
				if ((j == i) && (k == (k1 - 1))) {
					return true;
				}
				if ((j == (i - 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280108) == 0)) {
					return true;
				}
				if ((j == (i + 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280180) == 0)) {
					return true;
				}
			}
		}
		if (j1 == 2) {
			if (i1 == 0) {
				if ((j == (i - 1)) && (k == k1)) {
					return true;
				}
				if ((j == i) && (k == (k1 + 1))) {
					return true;
				}
				if ((j == (i + 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280180) == 0)) {
					return true;
				}
				if ((j == i) && (k == (k1 - 1)) && ((this.clipData[j][k] & 0x1280102) == 0)) {
					return true;
				}
			} else if (i1 == 1) {
				if ((j == (i - 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280108) == 0)) {
					return true;
				}
				if ((j == i) && (k == (k1 + 1))) {
					return true;
				}
				if ((j == (i + 1)) && (k == k1)) {
					return true;
				}
				if ((j == i) && (k == (k1 - 1)) && ((this.clipData[j][k] & 0x1280102) == 0)) {
					return true;
				}
			} else if (i1 == 2) {
				if ((j == (i - 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280108) == 0)) {
					return true;
				}
				if ((j == i) && (k == (k1 + 1)) && ((this.clipData[j][k] & 0x1280120) == 0)) {
					return true;
				}
				if ((j == (i + 1)) && (k == k1)) {
					return true;
				}
				if ((j == i) && (k == (k1 - 1))) {
					return true;
				}
			} else if (i1 == 3) {
				if ((j == (i - 1)) && (k == k1)) {
					return true;
				}
				if ((j == i) && (k == (k1 + 1)) && ((this.clipData[j][k] & 0x1280120) == 0)) {
					return true;
				}
				if ((j == (i + 1)) && (k == k1) && ((this.clipData[j][k] & 0x1280180) == 0)) {
					return true;
				}
				if ((j == i) && (k == (k1 - 1))) {
					return true;
				}
			}
		}
		if (j1 == 9) {
			if ((j == i) && (k == (k1 + 1)) && ((this.clipData[j][k] & 0x20) == 0)) {
				return true;
			}
			if ((j == i) && (k == (k1 - 1)) && ((this.clipData[j][k] & 2) == 0)) {
				return true;
			}
			if ((j == (i - 1)) && (k == k1) && ((this.clipData[j][k] & 8) == 0)) {
				return true;
			}
			if ((j == (i + 1)) && (k == k1) && ((this.clipData[j][k] & 0x80) == 0)) {
				return true;
			}
		}
		return false;
	}

	public boolean method220(int i, int j, int k, int l, int i1, int j1) {
		if ((j1 == i) && (k == j)) {
			return true;
		}
		j1 -= this.anInt290;
		k -= this.anInt291;
		i -= this.anInt290;
		j -= this.anInt291;
		if ((l == 6) || (l == 7)) {
			if(l == 7) {
				i1 = (i1 + 2) & 3;
			}
			if (i1 == 0) {
				if ((j1 == (i + 1)) && (k == j) && ((this.clipData[j1][k] & 0x80) == 0)) {
					return true;
				}
				if ((j1 == i) && (k == (j - 1)) && ((this.clipData[j1][k] & 2) == 0)) {
					return true;
				}
			} else if (i1 == 1) {
				if ((j1 == (i - 1)) && (k == j) && ((this.clipData[j1][k] & 8) == 0)) {
					return true;
				}
				if ((j1 == i) && (k == (j - 1)) && ((this.clipData[j1][k] & 2) == 0)) {
					return true;
				}
			} else if (i1 == 2) {
				if((j1 == (i - 1)) && (k == j) && ((this.clipData[j1][k] & 8) == 0)) {
					return true;
				}
				if ((j1 == i) && (k == (j + 1)) && ((this.clipData[j1][k] & 0x20) == 0)) {
					return true;
				}
			} else if (i1 == 3) {
				if ((j1 == (i + 1)) && (k == j) && ((this.clipData[j1][k] & 0x80) == 0)) {
					return true;
				}
				if ((j1 == i) && (k == (j + 1)) && ((this.clipData[j1][k] & 0x20) == 0)) {
					return true;
				}
			}
		}
		if (l == 8) {
			if ((j1 == i) && (k == (j + 1)) && ((this.clipData[j1][k] & 0x20) == 0)) {
				return true;
			}
			if ((j1 == i) && (k == (j - 1)) && ((this.clipData[j1][k] & 2) == 0)) {
				return true;
			}
			if ((j1 == (i - 1)) && (k == j) && ((this.clipData[j1][k] & 8) == 0)) {
				return true;
			}
			if ((j1 == (i + 1)) && (k == j) && ((this.clipData[j1][k] & 0x80) == 0)) {
				return true;
			}
		}
		return false;
	}

	public boolean method221(int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = (j + j1) - 1;
		int i2 = (i + l) - 1;
		if ((k >= j) && (k <= l1) && (k1 >= i) && (k1 <= i2)) {
			return true;
		}
		if ((k == (j - 1)) && (k1 >= i) && (k1 <= i2) && ((this.clipData[k - this.anInt290][k1 - this.anInt291] & 8) == 0) && ((i1 & 8) == 0)) {
			return true;
		}
		if ((k == (l1 + 1)) && (k1 >= i) && (k1 <= i2) && ((this.clipData[k - this.anInt290][k1 - this.anInt291] & 0x80) == 0) && ((i1 & 2) == 0)) {
			return true;
		}
		return ((k1 == (i - 1)) && (k >= j) && (k <= l1) && ((this.clipData[k - this.anInt290][k1 - this.anInt291] & 2) == 0) && ((i1 & 4) == 0)) || ((k1 == (i2 + 1)) && (k >= j) && (k <= l1) && ((this.clipData[k - this.anInt290][k1 - this.anInt291] & 0x20) == 0) && ((i1 & 1) == 0));
	}

	private int anInt290;
	private int anInt291;
	private int sizeX;
	private int sizeY;
	public int[][] clipData;
}