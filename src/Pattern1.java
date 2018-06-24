
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class Pattern1 {

	public static void main(String[] args) {

		int n = 5;

		// no of rows
		int row = 1;

		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {
				System.out.print("*");
				col = col + 1;
			}

			// prep
			System.out.println();
			row = row + 1;
		}

	}

}
