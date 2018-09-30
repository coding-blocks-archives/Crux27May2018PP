import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class IsPrime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int flag = 0;

		int n = scn.nextInt();

		int div = 2;

		while (div <= n/2) {

			if (n % div == 0) {
				flag = 1;
				break ;
			}

			div = div + 1;
		}

		if (flag == 0) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}

}
