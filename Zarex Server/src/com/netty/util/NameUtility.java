package com.netty.util;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:02:04 PM
 */
public class NameUtility {

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param l
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static String getLongToName(long l) {
		int i = 0;
		char[] ac = new char[12];
		while (l != 0L) {
			long l1 = l;
			// l /= 37L;
			ac[11 - i++] = Constants.VALID_CHARACTERS[(int) (l1 - (l * 37L))];
		}
		return new String(ac, 12 - i, i);
	}

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static String getFormattedName(String s) {
		return NameUtility.getFixedName(s.replace(" ", "_"));
	}

	/**
	 * 
	 * @param s
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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
		}
		return s;
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static boolean isValidName(String name) {
		return NameUtility.getFormattedName(name).matches("[a-z0-9_]+");
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static String getCapitalizedWord(String name) {
		return new String(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
	}
}