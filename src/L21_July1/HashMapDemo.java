package L21_July1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		// put
		map.put("UK", 10);
		System.out.println(map);
		map.put("India", 30);
		map.put("SL", 20);
		System.out.println(map);
		map.put("India", 40);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("A"));

		// containsKey
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("B"));

		// remove
		System.out.println(map.remove("India"));
		System.out.println(map);

		// key set
		ArrayList<String> list = new ArrayList<>(map.keySet());
		// for (String val : list) {
		// System.out.println(val);
		// }
		System.out.println(list);

		Set<String> listset = map.keySet();

		maxFreqChar("aaabbddddsssssssssss");

		int[] arr1 = { 10, 10, 2, 6, 1, 8, 3, 2, 2 };
		int[] arr2 = { 30, 40, 2, 1, 2, 3, 10 };

		System.out.println(intersection(arr1, arr2));
		
		int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6} ;
		
		System.out.println(consecutiveSequence(arr));

	}

	public static void maxFreqChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (map.containsKey(ch)) {
				int of = map.get(ch);
				int nf = of + 1;
				map.put(ch, nf);
			} else {
				map.put(ch, 1);
			}
		}

		ArrayList<Character> list = new ArrayList<>(map.keySet());

		int maxfreq = 0;
		char maxchar = ' ';

		for (Character ch : list) {

			int pfreq = map.get(ch);
			if (pfreq > maxfreq) {
				maxfreq = pfreq;
				maxchar = ch;
			}
		}

		System.out.println(maxfreq);
		System.out.println(maxchar);

	}

	public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {

			int val = arr1[i];
			if (map.containsKey(val)) {
				int of = map.get(val);
				int nf = of + 1;
				map.put(val, nf);
			} else {
				map.put(val, 1);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {

			int val = arr2[i];

			if (map.containsKey(val) && map.get(val) > 0) {
				ans.add(val);

				map.put(val, map.get(val) - 1);

			}
		}

		return ans;

	}

	public static ArrayList<Integer> consecutiveSequence(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}
		}

		int maxcount = 0;
		int starting = 0;

		for (int key : map.keySet()) {

			if (map.get(key) == true) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxcount) {
					maxcount = count;
					starting = key;
				}

			}

		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < maxcount; i++) {
			ans.add(starting + i);
		}

		return ans;

	}

}
