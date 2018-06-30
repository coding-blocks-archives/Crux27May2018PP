package L20_June30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jun-2018
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 3, 5, 7, 10, 15, 20, 25 };
		BST bst = new BST(in);

		bst.display();

		// System.out.println(bst.max());
		// System.out.println(bst.ht());
		// System.out.println(bst.find(4));
		// System.out.println(bst.size());

		// bst.replaceWithSumOfLarger();

		bst.display();

		bst.add(8);
		bst.display();
		
		bst.remove(10);
		bst.display();

	}

}
