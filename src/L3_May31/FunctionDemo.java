package L3_May31;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-May-2018
 * 
 */

public class FunctionDemo {

	static int abc = 1000;

	public static void main(String[] args) {

		System.out.println("hello");

		System.out.println("----------- Part-1 -----------");
		addition();
		subtraction();

		System.out.println("----------- Part-2 -----------");
		additionParams(4, 5);

		System.out.println("----------- Part-3 -----------");
		int x = 9;
		int sum = additionParamsReturn(x, 6);
		System.out.println(sum);
		System.out.println("bye");

		// int one = 10, two = 20;
		// int sum = DemoScopes(one, two);
		// System.out.println(sum);

		System.out.println("----------- Part-4 -----------");
		System.out.println(abc);
		abc = 200;
		System.out.println(abc);
		additionParams(abc, 60);
		System.out.println(abc);

		// Part 5 - Pass by value
		int one = 10, two = 20;
		System.out.println("----------- Part-5 -----------");
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);
	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}
	
	public static int DemoScopes(int one, int another) {

		int sum = one + another;
		return sum;
	}

	public static int additionParamsReturn(int a, int b) {

		int sum = a + b;
		return sum;

	}

	public static int additionParams(int a, int b) {

		int abc = FunctionDemo.abc + 1;
		int sum = abc + b;
		System.out.println(sum);

		return sum;
	}

	public static void addition() {

		int a = 2;
		int b = 3;
		int sum = a + b;

		System.out.println(sum);

		subtraction();

	}

	public static void subtraction() {

		int a = 2;
		int b = 3;
		int sum = a - b;
		System.out.println(sum);
	}

}
