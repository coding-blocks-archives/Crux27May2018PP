
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern4 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = n - 1;
		// no of rows
		int row = 1;

		while (row <= n) {

			// work for spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			// work for stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			System.out.println();
			nst = nst + 1;
			nsp = nsp - 1;
			row = row + 1;
		}

	}

}
