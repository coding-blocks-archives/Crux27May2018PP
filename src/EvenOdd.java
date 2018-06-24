import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class EvenOdd {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int num = scn.nextInt();
		if (num % 2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}

	}

}
