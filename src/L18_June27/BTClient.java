package L18_June27;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 27, 2018
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
	// false false
	// 10 true 20 true 30 false false true 40 true 50 false false false true 80 true
	// 60 false false true 70 false false
	public static void main(String[] args) {

		String str = "10 true 20 true 40 false false true 50 " + "false false true 30 true 60 false false false";
		BinaryTree bt = new BinaryTree(str);
		bt.display();

		System.out.println(bt.ht());
		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(50));
	}

}
