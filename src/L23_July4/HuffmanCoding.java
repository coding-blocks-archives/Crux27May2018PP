package L23_July4;

import java.util.HashMap;

import L22_July3.HeapGeneric;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Jul-2018
 */

public class HuffmanCoding {

	private class Node implements Comparable<Node> {

		char ch;
		int cost;
		Node left;
		Node right;

		public Node(char ch, int freq) {
			this.ch = ch;
			this.cost = freq;
		}

		public Node() {

		}

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}

	}

	HashMap<Character, String> encoder = new HashMap<>();
	HashMap<String, Character> decoder = new HashMap<>();

	public HuffmanCoding(String str) {

		// 1. create a fmap
		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (fmap.containsKey(ch)) {
				int of = fmap.get(ch);
				int nf = of + 1;
				fmap.put(ch, nf);
			} else {
				fmap.put(ch, 1);
			}
		}

		// 2. make nodes and put in heap
		HeapGeneric<Node> heap = new HeapGeneric<>();

		for (char key : fmap.keySet()) {

			Node nn = new Node(key, fmap.get(key));
			heap.add(nn);
		}

		// 3. take out two nodes and merge them and put back in heap
		while (heap.size() != 1) {

			Node one = heap.remove();
			Node two = heap.remove();

			Node merged = new Node();
			merged.cost = one.cost + two.cost;
			merged.left = one;
			merged.right = two;

			heap.add(merged);
		}

		Node rp = heap.remove();
		fillEncoderDecoder(rp, "");

		System.out.println(encoder);
	}

	private void fillEncoderDecoder(Node node, String ans) {

		if (node.left == null && node.right == null) {

			encoder.put(node.ch, ans);
			decoder.put(ans, node.ch);

			return;
		}
		fillEncoderDecoder(node.left, ans + "0");
		fillEncoderDecoder(node.right, ans + "1");

	}

	public String encode(String str) {

		String ans = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			ans += encoder.get(ch);
		}

		return ans;
	}

	public String decode(String str) {

		String ans = "";

		String key = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			key += ch;
			if (decoder.containsKey(key)) {
				ans += decoder.get(key);
				key = "";
			}

		}

		return ans;
	}

}
