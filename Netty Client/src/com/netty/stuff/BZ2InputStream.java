package com.netty.stuff;

public class BZ2InputStream {

	public static int decompressBuffer(byte abyte0[], int i, byte abyte1[], int j, int k) {
		synchronized (BZ2InputStream.block) {
			BZ2InputStream.block.input = abyte1;
			BZ2InputStream.block.nextIn = k;
			BZ2InputStream.block.output = abyte0;
			BZ2InputStream.block.availOut = 0;
			BZ2InputStream.block.compressedSize = j;
			BZ2InputStream.block.decompressedSize = i;
			BZ2InputStream.block.bsLive = 0;
			BZ2InputStream.block.bsBuff = 0;
			BZ2InputStream.block.totalInLo32 = 0;
			BZ2InputStream.block.totalInHi32 = 0;
			BZ2InputStream.block.totalOutLo32 = 0;
			BZ2InputStream.block.totalOutHi32 = 0;
			BZ2InputStream.block.blockNo = 0;
			BZ2InputStream.decompress(BZ2InputStream.block);
			i -= BZ2InputStream.block.decompressedSize;
			return i;
		}
	}

	private static void getNextFileHeader(BZIP2Block bZIP2Block) {
		byte byte4 = bZIP2Block.stateOutCH;
		int i = bZIP2Block.stateOutLen;
		int j = bZIP2Block.nBlockUsed;
		int k = bZIP2Block.k0;
		int ai[] = BZIP2Block.ll8;
		int l = bZIP2Block.nextOut;
		byte abyte0[] = bZIP2Block.output;
		int i1 = bZIP2Block.availOut;
		int j1 = bZIP2Block.decompressedSize;
		int k1 = j1;
		int l1 = bZIP2Block.nBlockPP + 1;
		label0:
			do {
				if (i > 0) {
					do {
						if (j1 == 0) {
							break label0;
						}
						if (i == 1) {
							break;
						}
						abyte0[i1] = byte4;
						i--;
						i1++;
						j1--;
					} while (true);
					if (j1 == 0) {
						i = 1;
						break;
					}
					abyte0[i1] = byte4;
					i1++;
					j1--;
				}
				boolean flag = true;
				while (flag) {
					flag = false;
					if (j == l1) {
						i = 0;
						break label0;
					}
					byte4 = (byte)k;
					l = ai[l];
					byte byte0 = (byte)(l & 0xff);
					l >>= 8;
					j++;
					if (byte0 != k) {
						k = byte0;
						if (j1 == 0) {
							i = 1;
						} else {
							abyte0[i1] = byte4;
							i1++;
							j1--;
							flag = true;
							continue;
						}
						break label0;
					}
					if (j != l1) {
						continue;
					}
					if (j1 == 0) {
						i = 1;
						break label0;
					}
					abyte0[i1] = byte4;
					i1++;
					j1--;
					flag = true;
				}
				i = 2;
				l = ai[l];
				byte byte1 = (byte)(l & 0xff);
				l >>= 8;
				if (++j != l1) {
					if (byte1 != k) {
						k = byte1;
					} else {
						i = 3;
						l = ai[l];
						byte byte2 = (byte)(l & 0xff);
						l >>= 8;
						if (++j != l1) {
							if (byte2 != k) {
								k = byte2;
							} else {
								l = ai[l];
								byte byte3 = (byte)(l & 0xff);
								l >>= 8;
								j++;
								i = (byte3 & 0xff) + 4;
								l = ai[l];
								k = (byte)(l & 0xff);
								l >>= 8;
								j++;
							}
						}
					}
				}
			} while (true);
		int i2 = bZIP2Block.totalOutLo32;
		bZIP2Block.totalOutLo32 += k1 - j1;
		if (bZIP2Block.totalOutLo32 < i2) {
			bZIP2Block.totalOutHi32++;
		}
		bZIP2Block.stateOutCH = byte4;
		bZIP2Block.stateOutLen = i;
		bZIP2Block.nBlockUsed = j;
		bZIP2Block.k0 = k;
		BZIP2Block.ll8 = ai;
		bZIP2Block.nextOut = l;
		bZIP2Block.output = abyte0;
		bZIP2Block.availOut = i1;
		bZIP2Block.decompressedSize = j1;
	}

	private static void decompress(BZIP2Block bZIP2Block) {
		int k8 = 0;
		int ai[] = null;
		int ai1[] = null;
		int ai2[] = null;
		bZIP2Block.blockSize100k = 1;
		if (BZIP2Block.ll8 == null) {
			BZIP2Block.ll8 = new int[bZIP2Block.blockSize100k * 0x186a0];
		}
		boolean flag19 = true;
		while (flag19) {
			byte byte0 = BZ2InputStream.readUChar(bZIP2Block);
			if (byte0 == 23) {
				return;
			}
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			bZIP2Block.blockNo++;
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			byte0 = BZ2InputStream.readBit(bZIP2Block);
			bZIP2Block.randomized = byte0 != 0;
			if (bZIP2Block.randomized) {
				System.out.println("PANIC! RANDOMISED BLOCK!");
			}
			bZIP2Block.origPtr = 0;
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			bZIP2Block.origPtr = (bZIP2Block.origPtr << 8) | (byte0 & 0xff);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			bZIP2Block.origPtr = (bZIP2Block.origPtr << 8) | (byte0 & 0xff);
			byte0 = BZ2InputStream.readUChar(bZIP2Block);
			bZIP2Block.origPtr = (bZIP2Block.origPtr << 8) | (byte0 & 0xff);
			for (int j = 0; j < 16; j++) {
				byte byte1 = BZ2InputStream.readBit(bZIP2Block);
				bZIP2Block.inUse16[j] = byte1 == 1;
			}
			for (int k = 0; k < 256; k++) {
				bZIP2Block.inUse[k] = false;
			}
			for (int l = 0; l < 16; l++) {
				if (bZIP2Block.inUse16[l]) {
					for (int i3 = 0; i3 < 16; i3++) {
						byte byte2 = BZ2InputStream.readBit(bZIP2Block);
						if (byte2 == 1) {
							bZIP2Block.inUse[(l * 16) + i3] = true;
						}
					}
				}
			}
			BZ2InputStream.makeMaps(bZIP2Block);
			int i4 = bZIP2Block.nInUse + 2;
			int j4 = BZ2InputStream.getBits(3, bZIP2Block);
			int k4 = BZ2InputStream.getBits(15, bZIP2Block);
			for (int i1 = 0; i1 < k4; i1++) {
				int j3 = 0;
				do {
					byte byte3 = BZ2InputStream.readBit(bZIP2Block);
					if (byte3 == 0) {
						break;
					}
					j3++;
				} while (true);
				bZIP2Block.selectorMtf[i1] = (byte)j3;
			}
			byte abyte0[] = new byte[6];
			for (byte byte16 = 0; byte16 < j4; byte16++) {
				abyte0[byte16] = byte16;
			}
			for (int j1 = 0; j1 < k4; j1++) {
				byte byte17 = bZIP2Block.selectorMtf[j1];
				byte byte15 = abyte0[byte17];
				for (; byte17 > 0; byte17--) {
					abyte0[byte17] = abyte0[byte17 - 1];
				}
				abyte0[0] = byte15;
				bZIP2Block.selector[j1] = byte15;
			}
			for (int k3 = 0; k3 < j4; k3++) {
				int l6 = BZ2InputStream.getBits(5, bZIP2Block);
				for (int k1 = 0; k1 < i4; k1++) {
					do {
						byte byte4 = BZ2InputStream.readBit(bZIP2Block);
						if (byte4 == 0) {
							break;
						}
						byte4 = BZ2InputStream.readBit(bZIP2Block);
						if (byte4 == 0) {
							l6++;
						} else {
							l6--;
						}
					} while (true);
					bZIP2Block.len[k3][k1] = (byte)l6;
				}
			}
			for (int l3 = 0; l3 < j4; l3++) {
				byte byte8 = 32;
				int i = 0;
				for (int l1 = 0; l1 < i4; l1++) {
					if (bZIP2Block.len[l3][l1] > i) {
						i = bZIP2Block.len[l3][l1];
					}
					if (bZIP2Block.len[l3][l1] < byte8) {
						byte8 = bZIP2Block.len[l3][l1];
					}
				}
				BZ2InputStream.createDecodeTables(bZIP2Block.limit[l3], bZIP2Block.base[l3], bZIP2Block.perm[l3], bZIP2Block.len[l3], byte8, i, i4);
				bZIP2Block.minLens[l3] = byte8;
			}
			int l4 = bZIP2Block.nInUse + 1;
			int i5 = -1;
			int j5 = 0;
			for (int i2 = 0; i2 <= 255; i2++) {
				bZIP2Block.unzftab[i2] = 0;
			}
			int j9 = 4095;
			for (int l8 = 15; l8 >= 0; l8--) {
				for (int i9 = 15; i9 >= 0; i9--) {
					bZIP2Block.yy[j9] = (byte)((l8 * 16) + i9);
					j9--;
				}
				bZIP2Block.mtf16[l8] = j9 + 1;
			}
			int i6 = 0;
			if (j5 == 0) {
				i5++;
				j5 = 50;
				byte byte12 = bZIP2Block.selector[i5];
				k8 = bZIP2Block.minLens[byte12];
				ai = bZIP2Block.limit[byte12];
				ai2 = bZIP2Block.perm[byte12];
				ai1 = bZIP2Block.base[byte12];
			}
			j5--;
			int i7 = k8;
			int l7;
			byte byte9;
			for (l7 = BZ2InputStream.getBits(i7, bZIP2Block); l7 > ai[i7]; l7 = (l7 << 1) | byte9) {
				i7++;
				byte9 = BZ2InputStream.readBit(bZIP2Block);
			}
			for (int k5 = ai2[l7 - ai1[i7]]; k5 != l4;) {
				if ((k5 == 0) || (k5 == 1)) {
					int j6 = -1;
					int k6 = 1;
					do {
						if (k5 == 0) {
							j6 += k6;
						} else if (k5 == 1) {
							j6 += 2 * k6;
						}
						k6 *= 2;
						if (j5 == 0) {
							i5++;
							j5 = 50;
							byte byte13 = bZIP2Block.selector[i5];
							k8 = bZIP2Block.minLens[byte13];
							ai = bZIP2Block.limit[byte13];
							ai2 = bZIP2Block.perm[byte13];
							ai1 = bZIP2Block.base[byte13];
						}
						j5--;
						int j7 = k8;
						int i8;
						byte byte10;
						for (i8 = BZ2InputStream.getBits(j7, bZIP2Block); i8 > ai[j7]; i8 = (i8 << 1) | byte10) {
							j7++;
							byte10 = BZ2InputStream.readBit(bZIP2Block);
						}
						k5 = ai2[i8 - ai1[j7]];
					} while ((k5 == 0) || (k5 == 1));
					j6++;
					byte byte5 = bZIP2Block.seqToUnseq[bZIP2Block.yy[bZIP2Block.mtf16[0]] & 0xff];
					bZIP2Block.unzftab[byte5 & 0xff] += j6;
					for (; j6 > 0; j6--) {
						BZIP2Block.ll8[i6] = byte5 & 0xff;
						i6++;
					}
				} else {
					int j11 = k5 - 1;
					byte byte6;
					if (j11 < 16) {
						int j10 = bZIP2Block.mtf16[0];
						byte6 = bZIP2Block.yy[j10 + j11];
						for (; j11 > 3; j11 -= 4) {
							int k11 = j10 + j11;
							bZIP2Block.yy[k11] = bZIP2Block.yy[k11 - 1];
							bZIP2Block.yy[k11 - 1] = bZIP2Block.yy[k11 - 2];
							bZIP2Block.yy[k11 - 2] = bZIP2Block.yy[k11 - 3];
							bZIP2Block.yy[k11 - 3] = bZIP2Block.yy[k11 - 4];
						}
						for (; j11 > 0; j11--) {
							bZIP2Block.yy[j10 + j11] = bZIP2Block.yy[(j10 + j11) - 1];
						}
						bZIP2Block.yy[j10] = byte6;
					} else {
						int l10 = j11 / 16;
						int i11 = j11 % 16;
						int k10 = bZIP2Block.mtf16[l10] + i11;
						byte6 = bZIP2Block.yy[k10];
						for (; k10 > bZIP2Block.mtf16[l10]; k10--) {
							bZIP2Block.yy[k10] = bZIP2Block.yy[k10 - 1];
						}
						bZIP2Block.mtf16[l10]++;
						for (; l10 > 0; l10--) {
							bZIP2Block.mtf16[l10]--;
							bZIP2Block.yy[bZIP2Block.mtf16[l10]] = bZIP2Block.yy[(bZIP2Block.mtf16[l10 - 1] + 16) - 1];
						}
						bZIP2Block.mtf16[0]--;
						bZIP2Block.yy[bZIP2Block.mtf16[0]] = byte6;
						if (bZIP2Block.mtf16[0] == 0) {
							int i10 = 4095;
							for (int k9 = 15; k9 >= 0; k9--) {
								for (int l9 = 15; l9 >= 0; l9--) {
									bZIP2Block.yy[i10] = bZIP2Block.yy[bZIP2Block.mtf16[k9] + l9];
									i10--;
								}
								bZIP2Block.mtf16[k9] = i10 + 1;
							}
						}
					}
					bZIP2Block.unzftab[bZIP2Block.seqToUnseq[byte6 & 0xff] & 0xff]++;
					BZIP2Block.ll8[i6] = bZIP2Block.seqToUnseq[byte6 & 0xff] & 0xff;
					i6++;
					if (j5 == 0) {
						i5++;
						j5 = 50;
						byte byte14 = bZIP2Block.selector[i5];
						k8 = bZIP2Block.minLens[byte14];
						ai = bZIP2Block.limit[byte14];
						ai2 = bZIP2Block.perm[byte14];
						ai1 = bZIP2Block.base[byte14];
					}
					j5--;
					int k7 = k8;
					int j8;
					byte byte11;
					for (j8 = BZ2InputStream.getBits(k7, bZIP2Block); j8 > ai[k7]; j8 = (j8 << 1) | byte11) {
						k7++;
						byte11 = BZ2InputStream.readBit(bZIP2Block);
					}
					k5 = ai2[j8 - ai1[k7]];
				}
			}
			bZIP2Block.stateOutLen = 0;
			bZIP2Block.stateOutCH = 0;
			bZIP2Block.cftab[0] = 0;
			for (int j2 = 1; j2 <= 256; j2++) {
				bZIP2Block.cftab[j2] = bZIP2Block.unzftab[j2 - 1];
			}
			for (int k2 = 1; k2 <= 256; k2++) {
				bZIP2Block.cftab[k2] += bZIP2Block.cftab[k2 - 1];
			}
			for (int l2 = 0; l2 < i6; l2++) {
				byte byte7 = (byte)(BZIP2Block.ll8[l2] & 0xff);
				BZIP2Block.ll8[bZIP2Block.cftab[byte7 & 0xff]] |= l2 << 8;
				bZIP2Block.cftab[byte7 & 0xff]++;
			}
			bZIP2Block.nextOut = BZIP2Block.ll8[bZIP2Block.origPtr] >> 8;
				bZIP2Block.nBlockUsed = 0;
				bZIP2Block.nextOut = BZIP2Block.ll8[bZIP2Block.nextOut];
				bZIP2Block.k0 = (byte) (bZIP2Block.nextOut & 0xff);
				bZIP2Block.nextOut >>= 8;
			bZIP2Block.nBlockUsed++;
			bZIP2Block.nBlockPP = i6;
			BZ2InputStream.getNextFileHeader(bZIP2Block);
			flag19 = (bZIP2Block.nBlockUsed == (bZIP2Block.nBlockPP + 1)) && (bZIP2Block.stateOutLen == 0);
		}
	}

	private static byte readUChar(BZIP2Block bZIP2Block) {
		return (byte) BZ2InputStream.getBits(8, bZIP2Block);
	}

	private static byte readBit(BZIP2Block bZIP2Block) {
		return (byte) BZ2InputStream.getBits(1, bZIP2Block);
	}

	private static int getBits(int i, BZIP2Block bZIP2Block) {
		int j;
		do {
			if (bZIP2Block.bsLive >= i) {
				int k = (bZIP2Block.bsBuff >> (bZIP2Block.bsLive - i)) & ((1 << i) - 1);
				bZIP2Block.bsLive -= i;
				j = k;
				break;
			}
			bZIP2Block.bsBuff = (bZIP2Block.bsBuff << 8) | (bZIP2Block.input[bZIP2Block.nextIn] & 0xff);
			bZIP2Block.bsLive += 8;
			bZIP2Block.nextIn++;
			bZIP2Block.compressedSize--;
			bZIP2Block.totalInLo32++;
			if (bZIP2Block.totalInLo32 == 0) {
				bZIP2Block.totalInHi32++;
			}
		} while (true);
		return j;
	}

	private static void makeMaps(BZIP2Block bZIP2Block) {
		bZIP2Block.nInUse = 0;
		for (int i = 0; i < 256; i++) {
			if (bZIP2Block.inUse[i]) {
				bZIP2Block.seqToUnseq[bZIP2Block.nInUse] = (byte) i;
				bZIP2Block.nInUse++;
			}
		}
	}

	private static void createDecodeTables(int[] ai, int[] ai1, int[] ai2, byte[] abyte0, int i, int j, int k) {
		int l = 0;
		for (int i1 = i; i1 <= j; i1++) {
			for (int l2 = 0; l2 < k; l2++) {
				if (abyte0[l2] == i1) {
					ai2[l] = l2;
					l++;
				}
			}
		}
		for (int j1 = 0; j1 < 23; j1++) {
			ai1[j1] = 0;
		}
		for (int k1 = 0; k1 < k; k1++) {
			ai1[abyte0[k1] + 1]++;
		}
		for (int l1 = 1; l1 < 23; l1++) {
			ai1[l1] += ai1[l1 - 1];
		}
		for (int i2 = 0; i2 < 23; i2++) {
			ai[i2] = 0;
		}
		int i3 = 0;
		for (int j2 = i; j2 <= j; j2++) {
			i3 += ai1[j2 + 1] - ai1[j2];
			ai[j2] = i3 - 1;
			i3 <<= 1;
		}
		for (int k2 = i + 1; k2 <= j; k2++) {
			ai1[k2] = ((ai[k2 - 1] + 1) << 1) - ai1[k2];
		}
	}

	private static BZIP2Block block = new BZIP2Block();
}