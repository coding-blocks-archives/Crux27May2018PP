import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class SumN {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int sum = 0;

		int counter = 1;

		while (counter <= n) {

			sum = sum + counter;

			counter = counter + 1;
		}
		
		System.out.println(sum);
	}

}
