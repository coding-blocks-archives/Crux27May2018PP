package L2_May29;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();

		int num = n;

		// no of digits
		int nod = 0;

		while (num != 0) {
			nod++;
			num = num / 10;
		}

		// rotations small -(nod-1) to (nod-1)
		r = r % nod;

		// make -ve as +ve
		if (r < 0) {
			r = r + nod;
		}
		
		// rotation
		int divisor = (int) Math.pow(10, r);

		int rem = n % divisor;
		int quot = n / divisor;

		int ans = rem * (int) Math.pow(10, nod - r) + quot;

		System.out.println(ans);

	}

}
