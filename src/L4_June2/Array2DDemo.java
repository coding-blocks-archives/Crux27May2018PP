package L4_June2;

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];

		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr.length);
		System.out.println(arr[0].length);

		System.out.println(arr[1][3]);

		// jagged array
		int[][] jarr = new int[3][];

		System.out.println(jarr);
		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[5];
		jarr[1] = new int[3];
		jarr[2] = new int[2];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		// jarr[0] = arr[0];
		// jarr[1] = arr[1];
		// jarr[2] = arr[2];
		//
		// System.out.println(jarr[0]);
		// System.out.println(jarr[1]);
		// System.out.println(jarr[2]);

		System.out.println(jarr[2][1]);
	}

}
