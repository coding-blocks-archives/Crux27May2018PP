package L21_July1.GenericClass;

import java.util.ArrayList;

import L21_July1.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class GenericClassDemo {
	public static void main(String[] args) throws Exception {

		// Pair<String> pair = new Pair<>();
		// pair.one = "abc";
		//
		// Pair2<Integer, String> pair2 = new Pair2<>();
		// // System.out.println(pair2.two);
		//
		// Pair2<Pair2<Integer, String>, Pair2<Double, String>> pair3 = new Pair2<>();
		// pair3.one = new Pair2<>();
		// pair3.one.one = 10;
		// System.out.println(pair3.one.one);
		// System.out.println(pair3.one.two);
		// pair3.two = new Pair2<>();
		// System.out.println(pair3.two.one);
		// System.out.println(pair3.two.two);
		//
		// ArrayList<ArrayList<String>> list = new ArrayList<>();
		// ArrayList<String> list1 = new ArrayList<>();
		// list1.add("abc");
		// list1.add("def");
		//
		// list.add(list1);
		// ArrayList<String> list2 = new ArrayList<>();
		// list2.add("qwe");
		// list2.add("rty");
		//
		// list.add(list2);
		// System.out.println(list.get(0));
		// System.out.println(list);

		// list.add(new ArrayList<>());
		// list.add(new ArrayList<>());
		// list.get(0).add("abc");
		// list.get(0).add("def");
		// list.get(1).add("ghi");

		LinkedListGeneric<ArrayList<String>> listll = new LinkedListGeneric<>();
		listll.addLast(new ArrayList<>());
		listll.getAt(0).add("abc");
		listll.getAt(0).add("def");
		listll.addLast(new ArrayList<>());
		listll.getAt(1).add("ghi");
		listll.display();

		// null pointer
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<String> list2 = null;
		list.add(list2);
		System.out.println(list.get(0).get(1));
	}

}
