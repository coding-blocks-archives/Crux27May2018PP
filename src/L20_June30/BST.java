package L20_June30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jun-2018
 */

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}

		int mid = (ilo + ihi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);

		return nn;
	}

	public void display() {

		System.out.println("-------------");
		display(this.root);
		System.out.println("-------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else {
			return true;
		}
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public void printInRange(int ll, int ul) {
		printInRange(this.root, ll, ul);
	}

	private void printInRange(Node node, int ll, int ul) {

		if (node == null) {
			return;
		}
		if (node.data < ll) {
			printInRange(node.right, ll, ul);
		} else if (node.data > ul) {
			printInRange(node.left, ll, ul);
		} else {

			printInRange(node.left, ll, ul);
			System.out.println(node.data);
			printInRange(node.right, ll, ul);
		}
	}

	public void printDec() {
		printDec(this.root);
	}

	private void printDec(Node node) {

		if (node == null) {
			return;

		}
		printDec(node.right);
		System.out.println(node.data);
		printDec(node.left);

	}

	private class Mover {
		int sum = 0;
	}

	public void replaceWithSumOfLarger() {
		Mover mover = new Mover();
		replaceWithSumOfLarger(this.root, mover);
	}

	private void replaceWithSumOfLarger(Node node, Mover mover) {

		if (node == null) {
			return;
		}

		replaceWithSumOfLarger(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replaceWithSumOfLarger(node.left, mover);

	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {

		if (item <= node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;

				node.left = nn;
			} else {
				add(node.left, item);
			}
		} else {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;

				node.right = nn;
			} else {
				add(node.right, item);
			}

		}

	}

	public void remove(int item) {

		if (root.data == item) {
			if (this.root.left == null && this.root.right != null) {
				this.root = this.root.right;
			} else if (this.root.left != null && this.root.right == null) {
				this.root = this.root.left;
			} else if (this.root.left == null && this.root.right == null) {
				return;
			} else {
				remove(this.root, null, item);
			}
		} else {
			remove(this.root, null, item);
		}
	}

	private void remove(Node node, Node parent, int item) {

		if (item > node.data) {
			remove(node.right, node, item);
		} else if (item < node.data) {
			remove(node.left, node, item);
		} else {

			// case 1
			if (node.left == null && node.right == null) {

				if (node.data < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left != null && node.right == null) {
				if (node.data < parent.data) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}

			} else if (node.left == null && node.right != null) {
				if (node.data < parent.data) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}

			} else {

				int temp = max(node.left);
				remove(node.left, node, temp);
				node.data = temp;
			}

		}

	}

	public void printkfar(int k, int target) {
		printkfar(this.root, k, target);
	}

	private int printkfar(Node node, int k, int target) {

		if (node == null) {
			return -1;
		}

		if (node.data == target) {
			printkdown(node, k);
			return 0;
		}

		int ld = printkfar(node.left, k, target);

		if (ld != -1) {

			if (ld + 1 == k) {
				System.out.println(node.data);
			}

			printkdown(node.right, k - ld - 2);

			return ld + 1;
		}

		int rd = printkfar(node.right, k, target);

		if (rd != -1) {

			if (rd + 1 == k) {
				System.out.println(node.data);
			}

			printkdown(node.left, k - rd - 2);

			return rd + 1;
		}

		return -1;
	}

	private void printkdown(Node node, int k) {

		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
		}

		printkdown(node.left, k - 1);
		printkdown(node.right, k - 1);

	}

}
