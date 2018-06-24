package L6_June5;

import java.util.Scanner;

public class StringBuilderDemo {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		StringBuilder sb = new StringBuilder(str);

		System.out.println(sb.charAt(2));
		System.out.println(sb);

		sb.setCharAt(2, 'r');
		System.out.println(sb);

		sb.append('f');
		System.out.println(sb);
		sb.append("hjk");
		System.out.println(sb);

		sb.insert(3, 'k');
		System.out.println(sb);

		sb.insert(3, "abc");
		System.out.println(sb);

		sb.deleteCharAt(4);
		System.out.println(sb);

		sb.delete(2, 3);
		System.out.println(sb);

		sb.replace(2, 4, "o");
		System.out.println(sb);

		String str1 = sb.toString();

		System.out.println(str1);

		System.out.println(ToggleCase(str));
	}

	public static String ToggleCase(String str) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isLowerCase(ch)) {
				sb.append(Character.toUpperCase(ch));
			} else {
				sb.append(Character.toLowerCase(ch));
			}

		}

		return sb.toString();

	}

}
