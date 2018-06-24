package L6_June5;

import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		// String str = scn.nextLine();
		// System.out.println(str);
		String str = "hello";

		System.out.println(str.length());

		System.out.println(str.charAt(1));

		System.out.println(str.charAt(str.length() - 1));
		System.out.println(str.substring(1, 2));
		System.out.println(str.substring(3, 5));
		System.out.println(str.substring(2, 2));
		System.out.println(str.substring(0, 5));
		// System.out.println(str.substring(2, 1));
		System.out.println(str.substring(3));

		String s1 = "he";
		String s2 = "llo";

		String s3 = s1 + s2;
		System.out.println(s3);
		String s4 = s1.concat(s2);
		System.out.println(s4);

		System.out.println(str.startsWith("he"));
		System.out.println(str.startsWith("He"));

		System.out.println(str.indexOf("lo"));
		System.out.println(str.indexOf("qwe"));

		// str = str.replace('l', 'w');
		System.out.println(str.replace('l', 'w'));
		System.out.println(str.replaceFirst("l", "w"));

		s1 = "hello";
		s2 = s1;
		s3 = "hello";
		s4 = new String("hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2)); // true true
		System.out.println((s1 == s3) + ", " + s1.equals(s3)); // true true
		System.out.println((s1 == s4) + ", " + s1.equals(s4));// false true

		String s6 = "aegxyzzz";
		String s7 = "aef";
		System.out.println(s6.compareTo(s7));

		appendString();

		// Character ch = new Character('a') ;
		char ch = 'a';
	}

	public static void appendString() {

		String str = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sb.append(i);
			// str += i;
		}

		// System.out.println(str);
	}

}
