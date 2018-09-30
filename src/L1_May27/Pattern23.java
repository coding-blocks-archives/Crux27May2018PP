
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern23 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = n - 1;
		// no of rows
		int row = 1;

		int val = 1;

		while (row <= n) {

			val = 1;

			// work for stars
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			// work for stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}

				cst = cst + 1;
			}

			// prep
			System.out.println();
			nst += 2;
			nsp--;
			row = row + 1;
		}

	}

}
