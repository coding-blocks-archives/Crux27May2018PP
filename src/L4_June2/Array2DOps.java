package L4_June2;

import java.util.Scanner;

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] arr = takeInput();
		int[][] array = { { 10, 20, 30, 100 }, { 40, 50, 60, 200 }, { 70, 80, 90, 300 } };
		spiralDisplay(array);
	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();

		int[][] arr = new int[rows][];

		for (int row = 0; row < arr.length; row++) {

			System.out.println("Col for " + row + " ?");
			int cols = scn.nextInt();

			arr[row] = new int[cols];

			for (int col = 0; col < arr[row].length; col++) {
				System.out.println("Value for [" + row + "," + col + "]");
				arr[row][col] = scn.nextInt();
			}
		}

		return arr;

	}

	public static void display(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}

			System.out.println();
		}

	}

	public static void verticalDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			for (int row = 0; row < arr.length; row++) {
				System.out.print(arr[row][col] + " ");
			}

		}
		System.out.println();

	}

	public static void waveDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + " ");
				}
			}

		}
		System.out.println();

	}

	public static void spiralDisplay(int[][] arr) {

		int rmin = 0;
		int rmax = arr.length - 1;
		int cmin = 0;
		int cmax = arr[0].length - 1;

		int nel = arr.length * arr[0].length;
		int counter = 0;

		while (counter < nel) {

			// first col
			for (int row = rmin; counter < nel && row <= rmax; row++) {
				System.out.print(arr[row][cmin] + " ");
				counter++;
			}

			cmin++;
			for (int col = cmin; counter < nel && col <= cmax; col++) {
				System.out.print(arr[rmax][col] + " ");
				counter++;
			}

			rmax--;

			// last col
			for (int row = rmax; counter < nel && row >= rmin; row--) {
				System.out.print(arr[row][cmax] + " ");
				counter++;
			}

			cmax--;

			// top row
			for (int col = cmax; counter < nel && col >= cmin; col--) {
				System.out.print(arr[rmin][col] + " ");
				counter++;
			}

			rmin++;
		}

	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;

		int r2 = two.length;
		int c2 = two[0].length;

		int cd = c1;

		if (c1 != r2) {
			return null;
		}

		int[][] ans = new int[r1][c2];

		for (int row = 0; row < ans.length; row++) {

			for (int col = 0; col < ans[0].length; col++) {

				for (int k = 0; k < cd; k++) {
					ans[row][col] += one[row][k] * two[k][col];
				}

			}

		}

		return ans;

	}

}
