package com.netty.util;

public class TextUtility {

	public static String textUnpack(byte packedData[], int size) {
		byte[] decodeBuf = new byte[4096];
		int idx = 0, highNibble = -1;
		for (int i = 0; i < size * 2; i++) {
			int val = packedData[i / 2] >> (4 - 4 * (i % 2)) & 0xf;
		if (highNibble == -1) {
			if (val < 13) {
				decodeBuf[idx++] = (byte) Constants.XLATE_TABLE[val];
			} else {
				highNibble = val;
			}
		} else {
			decodeBuf[idx++] = (byte) Constants.XLATE_TABLE[((highNibble << 4) + val) - 195];
			highNibble = -1;
		}
		}
		return new String(decodeBuf, 0, idx);
	}

	public static String optimizeText(String text) {
		char[] buf = text.toCharArray();
		boolean endMarker = true;
		for (int i = 0; i < buf.length; i++) {
			char c = buf[i];
			if (endMarker && (c >= 'a') && (c <= 'z')) {
				buf[i] -= 0x20;
				endMarker = false;
			}
			if ((c == '.') || (c == '!') || (c == '?')) {
				endMarker = true;
			}
		}
		return new String(buf, 0, buf.length);
	}

	public static String getVowel(String input) {
		char[] vowels = {
				'a', 'e', 'i', 'o', 'u'
		};
		for (int i = 0; i < vowels.length; i++) {
			if (input.toLowerCase().charAt(i) == vowels[i]) {
				return "an" + input;
			}
		}
		return "a" + input;
	}

	public static void textPack(byte packedData[], String text) {
		if (text.length() > 80) {
			text = text.substring(0, 80);
		}
		text = text.toLowerCase();
		int carryOverNibble = -1;
		int ofs = 0;
		for (int idx = 0; idx < text.length(); idx++) {
			char c = text.charAt(idx);
			int tableIdx = 0;
			for (int i = 0; i < Constants.XLATE_TABLE.length; i++) {
				if (c == (byte) Constants.XLATE_TABLE[i]) {
					tableIdx = i;
					break;
				}
			}
			if (tableIdx > 12) {
				tableIdx += 195;
			}
			if (carryOverNibble == -1) {
				if (tableIdx < 13) {
					carryOverNibble = tableIdx;
				} else {
					packedData[ofs++] = (byte) (tableIdx);
				}
			} else if (tableIdx < 13) {
				packedData[ofs++] = (byte) ((carryOverNibble << 4) + tableIdx);
				carryOverNibble = -1;
			} else {
				packedData[ofs++] = (byte) ((carryOverNibble << 4) + (tableIdx >> 4));
				carryOverNibble = tableIdx & 0xf;
			}
		}
		if (carryOverNibble != -1) {
			packedData[ofs++] = (byte) (carryOverNibble << 4);
		}
	}

	public static String filterText(String s) {
		StringBuilder bldr = new StringBuilder();
		for (char c : s.toLowerCase().toCharArray()) {
			boolean valid = false;
			for (char validChar : Constants.XLATE_TABLE) {
				if (validChar == c) {
					valid = true;
				}
			}
			if (valid) {
				bldr.append(c);
			}
		}
		return bldr.toString();
	}
}