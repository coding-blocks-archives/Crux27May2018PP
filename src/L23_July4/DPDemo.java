package L23_July4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Jul-2018
 */

public class DPDemo {

	public static void main(String[] args) {

		int n = 10;

		long start = System.currentTimeMillis();
		// System.out.println(Fib(n, new int[n + 1]));
		// System.out.println(FibBU(n));
		// System.out.println(BoardPathTD(0, n, new int[n + 1]));
		System.out.println(BoardPathBU(n));

		long end = System.currentTimeMillis();

		System.out.println(end - start);

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

		return strg[0];
	}

}
