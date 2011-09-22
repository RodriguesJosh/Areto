package com.netty.net.packet;

import com.netty.stuff.BZ2InputStream;

public class JagexArchive {

	public JagexArchive(byte[] abyte0) {
		Packet packet = new Packet(abyte0);
		int i = packet.getTriBytes();
		int j = packet.getTriBytes();
		if (j != i) {
			byte abyte1[] = new byte[i];
			BZ2InputStream.decompressBuffer(abyte1, i, abyte0, j, 6);
			this.outputData = abyte1;
			packet = new Packet(this.outputData);
			this.isCompressed = true;
		} else {
			this.outputData = abyte0;
			this.isCompressed = false;
		}
		this.dataSize = packet.getUnsignedShort();
		this.myNameIndexes = new int[this.dataSize];
		this.myFileSizes = new int[this.dataSize];
		this.myOnDiskFileSizes = new int[this.dataSize];
		this.myFileOffsets = new int[this.dataSize];
		int k = packet.getPosition() + (this.dataSize * 10);
		for (int l = 0; l < this.dataSize; l++) {
			this.myNameIndexes[l] = packet.getInt();
			this.myFileSizes[l] = packet.getTriBytes();
			this.myOnDiskFileSizes[l] = packet.getTriBytes();
			this.myFileOffsets[l] = k;
			k += this.myOnDiskFileSizes[l];
		}
	}

	public byte[] getDataForName(String s) {
		byte abyte0[] = null;
		int i = 0;
		s = s.toUpperCase();
		for (int j = 0; j < s.length(); j++) {
			i = ((i * 61) + s.charAt(j)) - 32;
		}
		for (int k = 0; k < this.dataSize; k++) {
			if (this.myNameIndexes[k] == i) {
				if (abyte0 == null) {
					abyte0 = new byte[this.myFileSizes[k]];
				}
				if (!this.isCompressed) {
					BZ2InputStream.decompressBuffer(abyte0, this.myFileSizes[k], this.outputData, this.myOnDiskFileSizes[k], this.myFileOffsets[k]);
				} else {
					System.arraycopy(this.outputData, this.myFileOffsets[k], abyte0, 0, this.myFileSizes[k]);
				}
				return abyte0;
			}
		}
		return null;
	}

	private byte[] outputData;
	private int dataSize;
	private int[] myNameIndexes;
	private int[] myFileSizes;
	private int[] myOnDiskFileSizes;
	private int[] myFileOffsets;
	private boolean isCompressed;
}