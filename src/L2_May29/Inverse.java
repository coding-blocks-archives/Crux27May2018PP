package L2_May29;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Inverse {

	public static void main(String[] args) {

		// byte b = (byte) 128;
		// System.out.println(b);

		// byte c = 0;
		// while (c <= 127) {
		// System.out.println(c);
		// c++;
		// }

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 1;
		int ans = 0;

		while (n != 0) {

			int rem = n % 10;
			ans = ans + (int) Math.pow(10, rem - 1) * count;
			count++;
			n = n / 10;
		}

		System.out.println(ans);

	}

}
