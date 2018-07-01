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

}
