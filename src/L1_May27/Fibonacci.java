import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int a = 0;
		int b = 1;

		int counter = 1;

		System.out.println(a);
		System.out.println(b);

		while (counter <= n - 1) {

			int sum = a + b;
			System.out.println(sum);

			a = b;
			b = sum;
			counter = counter + 1;
		}

	}

}
