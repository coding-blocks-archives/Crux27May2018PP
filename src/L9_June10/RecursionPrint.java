package L9_June10;

import L7_June7.RecursionGet;

public class RecursionPrint {

	public static void main(String[] args) {
		// System.out.println(printPermutations("abc", ""));
		// lexicoCounting(0, 1000);
		// System.out.println(printBoardPath(0, 10, ""));
		// System.out.println(printMazePath(0, 0, 2, 2, ""));

		int[] arr = { 1, 2, 3, 4 };

		targetSum(arr, 0, 0, "", 6);

	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // ch says no
		printSS(roq, ans + ch); // ch says yes

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}

	}

	public static int printPermutations(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		// System.o
		int count = 0;
		// System.out.println("hii " + ques);
		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			// System.out.println("going " + ch + "way from " + ques);

			count += printPermutations(roq, ans + ch);

			// System.out.println("coming back from " + ch);
		}
		// System.out.println("bye " + ques);
		return count;
	}

	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				lexicoCounting(curr * 10 + i, end);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				lexicoCounting(curr * 10 + i, end);
			}
		}
	}

	public static int printBoardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += printBoardPath(curr + dice, end, ans + dice);
		}

		return count;
	}

	public static int printMazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = printMazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = printMazePath(cr + 1, cc, er, ec, ans + "V");

		return ch + cv;
	}

	public static void targetSum(int[] arr, int vidx, int pSum, String ans, int target) {

		if (vidx == arr.length) {
			if (pSum == target) {
				System.out.println(ans);
			}
			return;
		}

		targetSum(arr, vidx + 1, pSum, ans, target);
		targetSum(arr, vidx + 1, pSum + arr[vidx], ans + " " + arr[vidx], target);
	}

	public static int coin(int n, String ans) {

	}

	public static int coinNoConsecutiveHead(int n, String ans, boolean wasLastHeadIncluded) {

	}

}
