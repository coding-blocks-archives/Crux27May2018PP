package L16_June24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 24, 2018
 */

public class GTClient {

	// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
	public static void main(String[] args) {

		// GenericTree gt = new GenericTree();
		// gt.display();
		//
		// System.out.println(gt.size());
		// System.out.println(gt.max());
		// System.out.println(gt.find(60));
		// System.out.println(gt.ht());

		nknights(new boolean[4][4], 0, 0, "", 0);
	}

	public static void nknights(boolean[][] board, int row, int col, String asf, int kpsf) {

		if (kpsf == board.length) {
			System.out.println(asf);
			return;
		}

		for (int c = col; c < board[0].length; c++) {

			board[row][c] = true;
			nknights(board, row, c + 1, asf + "{" + row + "-" + c + "}", kpsf + 1);
			board[row][c] = false;

		}

		for (int r = row + 1; r < board.length; r++) {

			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = true;
				nknights(board, r, c + 1, asf + "{" + r + "-" + c + "}", kpsf + 1);
				board[r][c] = false;
			}
		}

	}

}
