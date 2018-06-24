package L5_June3;

import java.util.ArrayList;

public class ArrayListDEmo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		// add at last
		list.add(10);
		System.out.println(list);
		list.add(20);
		System.out.println(list);
		list.add(30);
		System.out.println(list);

		// add at particular index
		// range of add : 0 -> size
		list.add(list.size(), 12);
		list.add(1, 70);
		System.out.println(list);

		// get the element
		// range of get : 0 -> size - 1
		System.out.println(list.get(list.size() - 1));

		// set the element
		// range of set : 0 -> size - 1
		list.set(list.size() - 1, 200);
		System.out.println(list);

		System.out.println(list.remove(10));
		System.out.println(list);

		System.out.println("----------");
		// print the list
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (int val : list) {
			System.out.println(val);
		}

		int[] one = { 10, 10, 10, 10, 30, 40, 50 };
		int[] two = { 30, 40, 40, 50 };

		System.out.println(intersection(one, two));

		int[] a1 = { 9, 9, 9, 5, 6 };
		int[] a2 = { 9, 9 };

		System.out.println(sumArrays(a1, a2));
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] == two[j]) {
				ans.add(one[i]);
				i++;
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else {
				j++;
			}

		}

		return ans;
	}

	public static ArrayList<Integer> sumArrays(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0)
				sum += one[i];

			if (j >= 0)
				sum += two[j];

			int rem = sum % 10;
			carry = sum / 10;

			ans.add(0, rem);

			i--;
			j--;

		}

		if (carry != 0) {
			ans.add(0, carry);
		}

		return ans;
	}

}
