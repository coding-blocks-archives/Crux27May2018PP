package L6_June5;

public class RecursionDemo {

	public static void main(String[] args) {

		// PDISkips(7);
		// int b = 10;
		// int c = 80;
		// int a = (b) + (b++) + (c);
		//
		// System.out.println(b);
		// System.out.println(a);

		// System.out.println(factorial(5));
		// System.out.println(power(2, 5));

		int[] arr = { 10, 20, 30, 40, 20, 20 };
		// displayarrReverse(arr, 0);
		int[] ans = findAllIndex(arr, 0, 20, 0);
		for (int val : ans) {
			System.out.println(val);
		}
		System.out.println();
	}

	public static void PD(int n) {

		if (n == 0) {
			return;
		}

		// self work
		System.out.println(n);

		// assumption
		PD(n - 1);
	}

	public static void PI(int n) {

		if (n == 0) {
			return;
		}

		PI(n - 1);

		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}
		System.out.println(n);

		PDI(n - 1);

		System.out.println(n);

	}

	public static void PDISkips(int n) {

		if (n == 0) {
			return;
		}
		if (n % 2 != 0)
			System.out.println(n);

		PDISkips(n - 1);

		if (n % 2 == 0)
			System.out.println(n);

	}

	public static int factorial(int n) {

		// base case
		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1);
		int fn = n * fnm1;

		return fn;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);
		int pn = x * pnm1;

		return pn;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void displayarr(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.print(arr[vidx] + " ");
		displayarr(arr, vidx + 1);
	}

	public static void displayArrReverse(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayArrReverse(arr, vidx + 1);
		System.out.print(arr[vidx] + " ");
	}

	public static int max(int[] arr, int vidx) {

		if (arr.length == vidx) {
			return Integer.MIN_VALUE;
		}

		int spmax = max(arr, vidx + 1);

		if (arr[vidx] > spmax) {
			return arr[vidx];
		} else {
			return spmax;
		}
	}

	public static int findFirst(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		return findFirst(arr, vidx + 1, item);

	}

	public static int findLast(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int rr = findLast(arr, vidx + 1, item);

		if (arr[vidx] == item && rr == -1) {
			return vidx;
		} else {
			return rr;
		}
	}

	public static int[] findAllIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] br = new int[count];
			return br;
		}

		if (arr[vidx] == item) {
			int[] rr = findAllIndex(arr, vidx + 1, item, count + 1);
			rr[count] = vidx;
			return rr;
		}

		else {
			int[] rr = findAllIndex(arr, vidx + 1, item, count);
			return rr;
		}

	}

}
