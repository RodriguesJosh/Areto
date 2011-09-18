package com.netty.util;

public class NameUtility {

	public static long getNameToLong(String s) {
		long l = 0L;
		for (int i = 0; (i < s.length()) && (i < 12); i++) {
			char c = s.charAt(i);
			l *= 37L;
			if ((c >= 'A') && (c <= 'Z')) {
				l += (1 + c) - 65;
			} else if ((c >= 'a') && (c <= 'z')) {
				l += (1 + c) - 97;
			} else if ((c >= '0') && (c <= '9')) {
				l += (27 + c) - 48;
			}
		}
		while (((l % 37L) == 0L) && (l != 0L)) {
			l /= 37L;
		}
		return l;
	}

	public static String getLongToName(long l) {
		int i = 0;
		char[] ac = new char[12];
		while (l != 0L) {
			long l1 = l;
			l /= 37L;
			ac[11 - i++] = Constants.VALID_CHARACTERS[(int) (l1 - (l * 37L))];
		}
		return new String(ac, 12 - i, i);
	}

	public static String getFormattedName(String s) {
		return NameUtility.getFixedName(s.replace(" ", "_"));
	}

	private static String getFixedName(String s) {
		if (s.length() > 0) {
			final char ac[] = s.toCharArray();
			for (int j = 0; j < ac.length; j++) {
				if (ac[j] == '_') {
					ac[j] = ' ';
					if (((j + 1) < ac.length) && (ac[j + 1] >= 'a') && (ac[j + 1] <= 'z')) {
						ac[j + 1] = (char) ((ac[j + 1] + 65) - 97);
					}
				}
			}
			if ((ac[0] >= 'a') && (ac[0] <= 'z')) {
				ac[0] = (char) ((ac[0] + 65) - 97);
			}
			return new String(ac);
		} else {
			return s;
		}
	}

	public static boolean isValidName(String name) {
		return NameUtility.getFormattedName(name).matches("[a-z0-9_]+");
	}

	public static String getCapitalizedWord(String name) {
		return name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
}