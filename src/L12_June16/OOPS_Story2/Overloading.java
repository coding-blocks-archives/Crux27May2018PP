package L12_June16.OOPS_Story2;

public class Overloading {

	public static void main(String[] args) {

		for (String val : args) {
			System.out.println(val);
		}
		int[] arr = { 10, 20 };
		add(10, 20);
		add(10, arr);
		// int sum = add(10, 20);
		// add(2.2, 3.3);

	}

	public static void add(int a, int... args) {

		System.out.println("in var add");
		int sum = 0;

		for (int val : args) {
			sum += val;
		}

		System.out.println(sum);
	}

	public static void add(int a, int b) {
		System.out.println("in 2 add");
		System.out.println(a + b);
	}

	public static void add(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static void add(double a, double b) {
		System.out.println(a + b);
	}

	public static void add(int a) {

		System.out.println(a);
	}

}
