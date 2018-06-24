package L6_June5;

public class StringOps {

	public static void main(String[] args) {

		String str = "abc def ghi";

		String[] arr = str.split(" ");
		for (String val : arr) {
			System.out.println(val);
		}
		
		// printChars("abcdef");
		// System.out.println(reverseExpression("300+90-800"));
		// printPalindromicSubstrings("nitin");
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println(Character.isLowerCase(ch));
		}
	}

	public static String reverse(String str) {

		String ans = "";

		for (int i = str.length() - 1; i >= 0; i--) {

			// ans += str.charAt(i);
			ans = ans.concat(str.charAt(i) + "");
		}

		return ans;

	}

	// O(n)
	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void printSubstrings(String str) {

		for (int si = 0; si < str.length(); si++) {
			for (int ei = si + 1; ei <= str.length(); ei++) {
				String ss = str.substring(si, ei);
				System.out.println(ss);
			}
		}
	}

	public static void printPalindromicSubstrings(String str) {
		for (int si = 0; si < str.length(); si++) {
			for (int ei = si + 1; ei <= str.length(); ei++) {
				String ss = str.substring(si, ei);
				if (isPalindrome(ss))
					System.out.println(ss);
			}
		}
	}

	public static String reverseExpression(String str) {

		String sa = "";
		String ta = "";

		for (int i = str.length() - 1; i >= 0; i--) {

			char ch = str.charAt(i);

			if (ch == '*' || ch == '+' || ch == '-') {
				ta += sa + ch;
				sa = "";
			} else {
				sa = ch + sa;
			}

		}

		ta += sa;

		return ta;

	}
}
