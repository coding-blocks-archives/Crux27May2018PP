package L3_May31;

public class TestFunctionQ {

	public static int xyz = 1000;

	public static void main(String[] args) {
		fun();
	}

	public static void fun() {

		xyz = 200;
		System.out.println(xyz);
		int xyz = 90;
		System.out.println(xyz);
		xyz = xyz + 1;
		TestFunctionQ.xyz = xyz + 1;

		System.out.println(TestFunctionQ.xyz);
		System.out.println(xyz);
		TestFunctionQ.xyz += 2;
		System.out.println(TestFunctionQ.xyz);
		System.out.println(xyz);
	}
}
