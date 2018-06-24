
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern17 {

	public static void main(String[] args) {

		int n = 9;
		int nst = n / 2;

		int nsp = 1;

		// rows
		int row = 1;
		while (row <= n) {

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

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

			if (row <= n / 2) {
				nst = nst - 1;
				nsp = nsp + 2;
			} else {
				nst = nst + 1;
				nsp = nsp - 2;
			}
			System.out.println();

			row = row + 1;
		}

	}

}
