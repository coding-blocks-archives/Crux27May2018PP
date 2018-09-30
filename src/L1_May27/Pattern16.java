
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern16 {

	public static void main(String[] args) {

		int n = 5;
		int nst = n;
		int nsp = n - 1;

		// rows
		int row = 1;
		while (row <= 2 * n - 1) {

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			// stars
			int csta = 1;
			while (csta <= nst) {
				System.out.print("*");
				csta = csta + 1;
			}

			// prep

			if (row <= n - 1) {
				nst = nst - 1;
				nsp = nsp - 1;
			} else {
				nst = nst + 1;
				nsp = nsp + 1;
			}
			System.out.println();

			row = row + 1;
		}

	}

}
