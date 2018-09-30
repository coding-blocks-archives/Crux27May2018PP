
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern13 {

	public static void main(String[] args) {

		int n = 5;
		int nr = 2 * n - 1;
		int nst = 1;

		// no of rows
		int row = 1;

		while (row <= nr) {

			// work for stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			System.out.println();
			if (row <= nr / 2) {
				nst = nst + 1;
			} else {
				nst = nst - 1;
			}
			row = row + 1;
		}

	}

}
