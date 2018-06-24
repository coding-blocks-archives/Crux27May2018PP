package Doubts;

public class AssignmentDoubts1 {

	public static void main(String[] args) {
		String s = Integer.toString(12345);

		String[] arr = { "123", "67", "45", "886", "88", "877", "889" };

		// 2336 2335 233 23
		bubbleSort(arr);

		for (String val : arr) {
			System.out.print(val + " ");
		}

		System.out.println();
		System.out.println(wildCard("codingblocks", "c*k?"));

		System.out.println(compression("aaabbcdffaa"));

		s = "1234";
		// s.replace('1', ' ');
		System.out.println(s.length());
		s.replaceAll("1", "");
		System.out.println(s.length());
	}

	public static void bubbleSort(String[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (compare(arr[j], arr[j + 1]) > 0) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

	// +ve value then swap
	public static int compare(String str1, String str2) {

		int i = 0;
		int j = 0;

		while (i < str1.length() && j < str2.length()) {

			if (str1.charAt(i) != str2.charAt(j)) {
				return str2.charAt(i) - str1.charAt(j);
			} else {

				i++;
				j++;
			}
		}

		if (i == str1.length() && j < str2.length()) {
			char lc = str2.charAt(j);
			char ls = str2.charAt(j - 1);

			if (lc > ls) {
				return 1;
			} else {
				return -1;
			}
		}

		if (j == str2.length() && i < str1.length()) {
			char lc = str1.charAt(i);
			char ls = str1.charAt(i - 1);

			if (lc > ls) {
				return -1;
			} else {
				return 1;
			}
		}

		return 0;
	}

	public static void waterTrapping(int[] arr) {

		int[] left = new int[arr.length];

		left[0] = arr[0];

		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		int[] right = new int[arr.length];

		right[right.length - 1] = arr[arr.length - 1];

		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

	}

	public static boolean wildCard(String src, String pat) {

		int i = 0;
		int j = 0;

		int starindex = -1;
		int charindex = -1;

		while (i < src.length()) {

			if (j < pat.length() && (pat.charAt(j) == '?' || pat.charAt(j) == src.charAt(i))) {
				i++;
				j++;
			} else if (j < pat.length() && pat.charAt(j) == '*') {

				starindex = j;
				charindex = i;

				j++;
			} else if (starindex != -1) {
				i = charindex + 1;
				j = starindex + 1;

				charindex++;
			} else {
				return false;
			}
		}

		while (j < pat.length() && pat.charAt(j) == '*') {
			j++;
		}

		return j == pat.length();

	}

	public static String compression(String str) {

		int count = 1;
		String ans = "";
		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				ans += str.charAt(i);

				if (count != 1)
					ans += count;
				count = 1;
			}
		}

		ans += str.charAt(str.length() - 1);
		if (count != 1)
			ans += count;

		return ans;
	}

}
