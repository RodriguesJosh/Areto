package com.netty.util.text;

import com.netty.net.packet.Packet;

public class TextInput {

	public static String method525(int i, Packet packet) {
		int j = 0;
		int k = -1;
		for (int l = 0; l < i; l++) {
			int i1 = packet.getUnsignedByte();
			int j1 = (i1 >> 4) & 0xf;
			if (k == -1) {
				if (j1 < 13) {
					TextInput.aCharArray631[j++] = TextInput.validChars[j1];
				} else {
					k = j1;
				}
			} else {
				TextInput.aCharArray631[j++] = TextInput.validChars[((k << 4) + j1) - 195];
				k = -1;
			}
			j1 = i1 & 0xf;
			if (k == -1) {
				if (j1 < 13) {
					TextInput.aCharArray631[j++] = TextInput.validChars[j1];
				} else {
					k = j1;
				}
			} else {
				TextInput.aCharArray631[j++] = TextInput.validChars[((k << 4) + j1) - 195];
				k = -1;
			}
		}
		boolean flag1 = true;
		for (int k1 = 0; k1 < j; k1++) {
			char c = TextInput.aCharArray631[k1];
			if (flag1 && (c >= 'a') && (c <= 'z')) {
				TextInput.aCharArray631[k1] += '\uFFE0';
				flag1 = false;
			}
			if ((c == '.') || (c == '!') || (c == '?')) {
				flag1 = true;
			}
		}
		return new String(TextInput.aCharArray631, 0, j);
	}

	public static void method526(String s, Packet packet) {
		if (s.length() > 80) {
			s = s.substring(0, 80);
		}
		s = s.toLowerCase();
		int i = -1;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			int k = 0;
			for (int l = 0; l < TextInput.validChars.length; l++) {
				if (c != TextInput.validChars[l]) {
					continue;
				}
				k = l;
				break;
			}
			if (k > 12) {
				k += 195;
			}
			if (i == -1) {
				if (k < 13) {
					i = k;
				} else {
					// packet.writeWordBigEndian(k);
				}
			} else if (k < 13) {
				// packet.writeWordBigEndian((i << 4) + k);
				i = -1;
			} else {
				// packet.writeWordBigEndian((i << 4) + (k >> 4));
				i = k & 0xf;
			}
		}
		if (i != -1) {
			// packet.writeWordBigEndian(i << 4);
		}
	}

	public static String processText(String s) {
		TextInput.packet.setPosition(0);
		TextInput.method526(s, TextInput.packet);
		int j = TextInput.packet.getPosition();
		TextInput.packet.setPosition(0);
		String s1 = TextInput.method525(j, TextInput.packet);
		return s1;
	}

	private static char[] aCharArray631 = new char[100];
	private static Packet packet = new Packet(new byte[100]);
	private static char[] validChars = {
		' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r',
		'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p',
		'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2',
		'3', '4', '5', '6', '7', '8', '9', ' ', '!', '?',
		'.', ',', ':', ';', '(', ')', '-', '&', '*', '\\',
		'\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[',
		']'
	};
}