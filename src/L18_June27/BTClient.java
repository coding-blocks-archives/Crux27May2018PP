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
	// 10 true 20 true 30 false false false false
	public static void main(String[] args) {

		String str = "10 true 20 true 30 false false false false";
		// int[] pre = { 10, 20, 40, 50, 60, 80, 30, 70 };
		// int[] in = { 40, 20, 80, 60, 50, 10, 30, 70 };
		int[] pre = { 100, 50, 20, 10, 25, 60, 200, 150, 120, 160, 250, 270, 300 };
		int[] in = { 10, 20, 25, 50, 60, 100, 120, 150, 160, 200, 250, 270, 300 };
		BinaryTree bt = new BinaryTree(pre, in);
		// BinaryTree bt = new BinaryTree(str);
		bt.display();

		System.out.println(bt.ht());
		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(50));

		System.out.println(bt.diameter());
		System.out.println(bt.diameter2());

		System.out.println(bt.treeBalanced());

		bt.preorder();
		System.out.println();
		bt.preorderI();
		
		System.out.println();
		bt.largestBST();
	}

}
