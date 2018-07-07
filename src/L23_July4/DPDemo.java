package L23_July4;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Jul-2018
 */

public class DPDemo {

	public static void main(String[] args) {

		int n = 3;

		long start = System.currentTimeMillis();
		// System.out.println(Fib(n, new int[n + 1]));
		// System.out.println(FibBU(n));
		// System.out.println(BoardPathTD(0, n, new int[n + 1]));
		// System.out.println(BoardPathBU(n));

		// System.out.println(MazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(MazePathBU(n, n));
		// System.out.println(MazePathBUSE(n, n));
		// System.out.println(MazePathBUSEDiag(n, n));

		// System.out.println(LCSBU("abcdmxchsjdghcsjkudfhcuiwe",
		// "agcfdhjsdgcjhsdcui"));
		// System.out.println(EditDistance("abcdchjxgchsdgcjh",
		// "agcfdcdjbxjhcsjdkvheurk"));
		// System.out.println(EditDistanceBU("abcd", "agcfd"));

		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// System.out.println(MCM(arr, 0, arr.length - 1));
		// System.out.println(MCMTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		// int[] price = { 2, 3, 5, 1, 4 };
		// System.out.println(WineProblem(price, 0, price.length - 1, 1));
		// System.out.println(WineProblemTD(price, 0, price.length - 1, new
		// int[price.length][price.length]));
		// System.out.println(WineProblemBU(price));

		// int[] price = { 1, 4, 5, 7 };
		// int[] weight = { 1, 3, 4, 5 };
		// int cap = 7;
		// System.out.println(KnapsackTD(weight, price, 0, cap, new int[price.length +
		// 1][cap + 1]));
		// System.out.println(KnapsackBU(price, weight, cap));

		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(RodCutTD(prices, prices.length - 1, new int[prices.length]));
		System.out.println(RodCutBU(prices, prices.length - 1));

		int[] arr = { 40, 60, 20 };
		System.out.println(MixturesTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MixturesBU(arr));

		long end = System.currentTimeMillis();
		System.out.println("Duration: " + (end - start));

	}

	public static int Fib(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = Fib(n - 1, strg);
		int fnm2 = Fib(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn;
		return fn;

	}

	public static int FibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int FibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i < n; i++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}
		return strg[1];
	}

	public static int BoardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += BoardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;
		return count;
	}

	public static int BoardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int BoardPathBUSE(int n) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}
		return strg[0];
	}

	public static int MazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = MazePathTD(cr, cc + 1, er, ec, strg);
		int cv = MazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;
		return ch + cv;
	}

	public static int MazePathBU(int er, int ec) {

		int[][] strg = new int[er + 1][ec + 1];

		for (int row = strg.length - 1; row >= 0; row--) {

			for (int col = strg[0].length - 1; col >= 0; col--) {

				if (row == strg.length - 1 || col == strg[0].length - 1) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int MazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int row = strg.length - 2; row >= 0; row--) {

			for (int col = strg.length - 1; col >= 0; col--) {

				if (col == strg.length - 1) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}

		return strg[0];
	}

	public static int MazePathBUSEDiag(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		int diag = 0;

		for (int row = strg.length - 2; row >= 0; row--) {

			for (int col = strg.length - 1; col >= 0; col--) {

				if (col == strg.length - 1) {
					strg[col] = 1;
					diag = 1;
				} else {
					int sum = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = sum;
				}
			}
		}

		return strg[0];
	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(ros1, s2);
			int o2 = LCS(s1, ros2);

			ans = Math.max(o1, o2);
		}

		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {

					int o1 = strg[row][col + 1];
					int o2 = strg[row + 1][col];

					strg[row][col] = Math.max(o1, o2);
				}
			}
		}

		return strg[0][0];

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);

			ans = Math.min(r, Math.min(i, d)) + 1;

		}

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
				}
				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];

					strg[row][col] = Math.min(r, Math.min(i, d)) + 1;
				}

			}
		}

		return strg[0][0];

	}

	public static int MCM(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(arr, si, k);
			int sp = MCM(arr, k, ei);
			int sw = arr[si] * arr[k] * arr[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
		}

		return min;

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(arr, si, k, strg);
			int sp = MCMTD(arr, k, ei, strg);
			int sw = arr[si] * arr[k] * arr[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
		}

		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (si + 1 == ei) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si + 1; k <= ei - 1; k++) {

						int fp = strg[si][k];
						int sp = strg[k][ei];
						int sw = arr[si] * arr[k] * arr[ei];

						int sum = fp + sp + sw;

						if (sum < min) {
							min = sum;
						}
					}

					strg[si][ei] = min;
				}
			}

		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int[] price, int si, int ei, int yr) {

		if (si == ei) {
			return price[si] * yr;
		}

		int sc = WineProblem(price, si + 1, ei, yr + 1) + price[si] * yr;
		int ec = WineProblem(price, si, ei - 1, yr + 1) + price[ei] * yr;

		int ans = Math.max(sc, ec);

		return ans;

	}

	public static int WineProblemTD(int[] price, int si, int ei, int[][] strg) {

		int yr = price.length - (ei - si);

		if (si == ei) {
			return price[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int sc = WineProblemTD(price, si + 1, ei, strg) + price[si] * yr;
		int ec = WineProblemTD(price, si, ei - 1, strg) + price[ei] * yr;

		int ans = Math.max(sc, ec);

		strg[si][ei] = ans;
		return ans;

	}

	public static int WineProblemBU(int[] price) {

		int n = price.length;
		int[][] strg = new int[price.length][price.length];

		for (int slide = 1; slide <= n; slide++) {

			for (int si = 0; si <= n - slide; si++) {

				int ei = si + slide - 1;

				int yr = n - (ei - si);

				if (si == ei) {
					strg[si][ei] = price[si] * yr;
				} else {
					int sc = strg[si + 1][ei] + price[si] * yr;
					int ec = strg[si][ei - 1] + price[ei] * yr;

					int ans = Math.max(sc, ec);

					strg[si][ei] = ans;

				}
			}

		}

		return strg[0][n - 1];

	}

	public static int KnapsackTD(int[] weight, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == weight.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int include = 0;
		if (cap >= weight[vidx]) {
			include = KnapsackTD(weight, price, vidx + 1, cap - weight[vidx], strg) + price[vidx];
		}

		int exclude = KnapsackTD(weight, price, vidx + 1, cap, strg);

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;
		return ans;
	}

	public static int KnapsackBU(int[] price, int[] weight, int cap) {

		int nr = price.length + 1;
		int nc = cap + 1;
		int[][] strg = new int[nr][nc];

		for (int row = 0; row < nr; row++) {

			for (int col = 0; col < nc; col++) {

				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {

					int include = 0;

					if (col >= weight[row - 1]) {
						include = price[row - 1] + strg[row - 1][col - weight[row - 1]];
					}

					int exclude = strg[row - 1][col];

					strg[row][col] = Math.max(include, exclude);

				}
			}

		}

		return strg[nr - 1][nc - 1];
	}

	public static int RodCutTD(int[] prices, int n, int[] strg) {

		if (n == 0) {
			return 0;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int max = prices[n];

		int left = 1;
		int right = n - 1;

		while (left <= right) {

			int fh = RodCutTD(prices, left, strg);
			int sh = RodCutTD(prices, right, strg);

			int ans = fh + sh;

			if (ans > max) {
				max = ans;
			}
			left++;
			right--;
		}

		strg[n] = max;
		return max;

	}

	public static int RodCutBU(int[] prices, int n) {

		int[] strg = new int[n + 1];

		for (int i = 1; i <= n; i++) {

			int max = prices[i];

			int left = 1;
			int right = i - 1;

			while (left <= right) {

				int fh = strg[left];
				int sh = strg[right];

				int ans = fh + sh;

				if (ans > max) {
					max = ans;
				}
				left++;
				right--;
			}

			strg[i] = max;

		}

		return strg[n];

	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;

		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}

	public static int MixturesTD(int[] arr, int si, int ei, int[][] strg) {

		if (si == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fh = MixturesTD(arr, si, k, strg);
			int sh = MixturesTD(arr, k + 1, ei, strg);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int ans = fh + sh + sw;

			if (ans < min) {
				min = ans;
			}
		}

		strg[si][ei] = min;
		return min;

	}

	public static int MixturesBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int fh = strg[si][k];
					int sh = strg[k + 1][ei];

					int sw = color(arr, si, k) * color(arr, k + 1, ei);

					int ans = fh + sh + sw;

					if (ans < min) {
						min = ans;
					}
				}

				strg[si][ei] = min;

			}
		}

		return strg[0][n - 1];

	}

}
