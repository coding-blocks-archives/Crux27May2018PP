package Doubts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class june20doubts {
	static int invert = 0;

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 3, 4, 5 };
		// splitArray(arr, 0, 0, 0, "", "");
		// System.out.println(Coins(48));
		// System.out.println(codes("1125"));
		// LexiLarger("bac", "", "bac");
		int n = 14;
		int input[] = { 3, 1, 1, 1 };
		boolean primes[] = SOE(n);
		int board[] = snakeslader(primes);
		System.out.println(snlad(input, 0, board, 0, n));

		// System.out.println(binary(book, students));
		Schlrship(6, 3, 1, 1);

	}

	public static int[] snakeslader(boolean[] primes) {

		int[] snklad = new int[primes.length];
		int left = 0;
		int right = snklad.length - 1;
		int counter = 0;
		while (left < right) {
			while (primes[left] == false) {
				left++;
			}
			while (primes[right] == false) {
				right--;
			}

			if (left < right) {
				if (counter % 2 == 0) {
					snklad[left] = right;
				} else {
					snklad[right] = left;
				}
				counter++;
				left++;
				right--;
			}

		}
		return snklad;
	}

	public static boolean snlad(int[] input, int vidx, int board[], int curr, int end) {

		if (curr == end) {
			return true;
		}
		if (vidx == input.length) {
			return false;
		}

		if (board[curr] != 0) {
			return snlad(input, vidx, board, board[curr], end);
		} else {
			return snlad(input, vidx + 1, board, curr + input[vidx], end);
		}

	}

	public static void splitArray(int[] arr, int vidx, int sum1, int sum2, String asf1, String asf2) {

		if (vidx == arr.length) {

			if (sum1 == sum2) {
				System.out.println(asf1 + " and " + asf2);

			}
			return;
		}
		splitArray(arr, vidx + 1, sum1 + arr[vidx], sum2, asf1 + " " + arr[vidx], asf2);
		splitArray(arr, vidx + 1, sum1, sum2 + arr[vidx], asf1, asf2 + " " + arr[vidx]);

	}

	public static long Coins(long n) {

		long sum = (n / 2) + (n / 3) + (n / 4);

		if (sum <= n) {
			return n;
		} else {
			return Coins(n / 2) + Coins(n / 3) + Coins(n / 4);
		}

	}

	public static ArrayList<String> codes(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		int one = Integer.parseInt(ques.substring(0, 1));
		char ch1 = (char) (one + 'a' - 1);
		String roq = ques.substring(1);
		ArrayList<String> rr1 = codes(roq);
		for (String rrs : rr1) {
			mr.add(ch1 + rrs);
		}

		if (ques.length() > 1) {
			int two = Integer.parseInt(ques.substring(0, 2));
			if (two <= 26) {
				char ch2 = (char) (two + 'a' - 1);
				String roq2 = ques.substring(2);
				ArrayList<String> rr2 = codes(roq2);
				for (String rrs : rr2) {
					mr.add(ch2 + rrs);
				}

			}

		}

		return mr;
	}

	public static long binary(long[] book, long students) {
		long sum = 0;
		for (int i = 0; i < book.length; i++) {
			sum += book[i];
		}
		long lo = 0;
		long hi = sum;
		long anstilnow = 0;
		while (lo <= hi) {
			long mid = (lo + hi) / 2;

			if (isValid(book, students, mid)) {
				anstilnow = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return anstilnow;

	}

	private static boolean isValid(long[] book, long k, long mid) {
		long students = 1;
		int i = 0;
		long sum = 0;
		while (i < book.length) {
			if (book[i] > mid) {
				return false;
			}
			sum += book[i];
			if (sum > mid) {
				students++;
				sum = book[i];
			}
			if (students > k) {
				return false;
			}

			i++;
		}

		return true;

	}

	public static void Schlrship(int n, int m, int x, int y) {

		int Students_gettingFull = m / x;

		if (Students_gettingFull > n) {
			System.out.println(n);
			return;
		}

		int rem_students = n - Students_gettingFull;
		int coupos_left = m % x;

		while (rem_students > 1) {

			coupos_left += y;
			rem_students--;

			if (coupos_left >= x) {

				int mediator = coupos_left / x;
				if (mediator >= rem_students) {

					Students_gettingFull += rem_students;
					System.out.println(Students_gettingFull);
					return;
				}

				rem_students -= mediator;
				Students_gettingFull += mediator;

			}

		}

		System.out.println(Students_gettingFull);

	}

	public static boolean[] SOE(int n) {

		boolean primes[] = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int multiplier = 2; table * multiplier <= n; multiplier++) {

				primes[table * multiplier] = false;
			}
		}

		return primes;

	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] ans = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else if (two[j] >= one[i]) {
				// Global variable invert to keep track of inversions
				invert += one.length - i;
				ans[k] = two[j];
				j++;
				k++;
			}
		}

		if (i == one.length) {
			while (j < two.length) {
				ans[k] = two[j];
				j++;
				k++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				ans[k] = one[i];
				i++;
				k++;
			}
		}

		return ans;

	}

}
