package L23_July4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Jul-2018
 */

public class HCClient {

	public static void main(String[] args) {

		HuffmanCoding hc = new HuffmanCoding("aaaaabbbbcccdde");

		System.out.println(hc.encode("abcda"));
		System.out.println(hc.decode("11100001111"));

	}

}
