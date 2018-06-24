package L12_June16;

public class TOH {

	public static void main(String[] args) {

		TOH(3, "S", "D", "T");
	}

	public static void TOH(int n, String src, String dst, String temp) {

		if (n == 0) {
			return;
		}

		TOH(n - 1, src, temp, dst);
		System.out.println("Move " + n + " disc from " + src + " to " + dst);
		TOH(n - 1, temp, dst, src);
	}

}
