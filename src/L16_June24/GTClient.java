package L16_June24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 24, 2018
 */

public class GTClient {

	// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
	// 10 3 20 2 50 2 100 0 110 1 120 0 60 0 30 0 40 1 70 2 80 0 90 0
	public static void main(String[] args) {

		String str = "10 3 20 2 50 2 100 0 110 1 120 0 60 0 30 0 40 1 70 2 80 0 90 0";
		GenericTree gt = new GenericTree(str);
		gt.display();

		// System.out.println(gt.size());
		// System.out.println(gt.max());
		// System.out.println(gt.find(60));
		// System.out.println(gt.ht());

		// gt.mirror();
		// gt.display();
		// gt.preorder();

		// gt.levelorderRecursive();
		// gt.levelorderIterative();
		gt.levelorderlwIteractive();
		gt.levelorderzzIterative();

		// gt.levelorderzzRecursive();

		gt.multiSolver(10);
	}

}
