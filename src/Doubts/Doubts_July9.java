package Doubts;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Jul-2018
 */

public class Doubts_July9 {

	public static void main(String[] args) {

		// System.out.println(wildCardMatching("aaabac", "**ab*?"));
		uglyNos();
	}

	public static void uglyNos() {

		int n = 20;

		int[] arr = new int[n];
		arr[0] = 1;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		int nm2 = 2;
		int nm3 = 3;
		int nm5 = 5;

		for (int i = 1; i < n; i++) {

			int res = Math.min(nm2, Math.min(nm3, nm5));

			arr[i] = res;

			if (res == nm2) {
				i2 = i2 + 1;
				nm2 = arr[i2] * 2;
			}

			if (res == nm3) {
				i3 = i3 + 1;
				nm3 = arr[i3] * 3;
			}

			if (res == nm5) {
				i5 = i5 + 1;
				nm5 = arr[i5] * 5;
			}

		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static boolean wildCardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pattern.length() != 0) {

			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;

		}

		char srcChar = src.charAt(0);
		char patChar = pattern.charAt(0);
		String srcRos = src.substring(1);
		String patRos = pattern.substring(1);

		if (patChar == '*') {

			boolean fc = wildCardMatching(src, patRos);
			boolean sc = wildCardMatching(srcRos, pattern);

			return fc || sc;
		} else if (patChar == '?' || patChar == srcChar) {
			return wildCardMatching(srcRos, patRos);
		} else {
			return false;
		}
	}

}
