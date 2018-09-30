
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern3 {

	public static void main(String[] args) {

		int n = 5;

		int nst = n;
		// no of rows
		int row = 1;

		while (row <= n) {

			// work
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			System.out.println();
			nst = nst - 1;
			row = row + 1;
		}

	}

}
