package com.netty.stuff;

public class BZIP2Block {

	public BZIP2Block() {
		this.unzftab = new int[256];
		this.cftab = new int[257];
		this.inUse = new boolean[256];
		this.inUse16 = new boolean[16];
		this.seqToUnseq = new byte[256];
		this.yy = new byte[4096];
		this.mtf16 = new int[16];
		this.selector = new byte[18002];
		this.selectorMtf = new byte[18002];
		this.len = new byte[6][258];
		this.limit = new int[6][258];
		this.base = new int[6][258];
		this.perm = new int[6][258];
		this.minLens = new int[6];
	}

	byte[] input;
	int nextIn;
	int compressedSize;
	int totalInLo32;
	int totalInHi32;
	byte[] output;
	int availOut;
	int decompressedSize;
	int totalOutLo32;
	int totalOutHi32;
	byte stateOutCH;
	int stateOutLen;
	boolean randomized;
	int bsBuff;
	int bsLive;
	int blockSize100k;
	int blockNo;
	int origPtr;
	int nextOut;
	int k0;
	int[] unzftab;
	int nBlockUsed;
	int[] cftab;
	public static int[] ll8;
	int nInUse;
	boolean[] inUse;
	boolean[] inUse16;
	byte[] seqToUnseq;
	byte[] yy;
	int[] mtf16;
	byte[] selector;
	byte[] selectorMtf;
	byte[][] len;
	int[][] limit;
	int[][] base;
	int[][] perm;
	int[] minLens;
	int nBlockPP;
}