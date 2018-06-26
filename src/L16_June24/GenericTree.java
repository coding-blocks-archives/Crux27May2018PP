package L16_June24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 24, 2018
 */

public class GenericTree {

	Scanner scn;

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree(String str) {
		scn = new Scanner(str);
		this.root = takeInput(null, -1);
	}

	// ith child of parent
	private Node takeInput(Node parent, int ith) {

		// give prompt to user
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ?");
		}

		// take item input
		int item = scn.nextInt();

		// make a ew node
		Node nn = new Node();
		nn.data = item;

		// take input for no of children
		System.out.println("No of children for " + nn.data);
		int noc = scn.nextInt();

		// loop on children
		for (int i = 0; i < noc; i++) {

			// take input for each child
			Node child = takeInput(nn, i);

			// attach the child with present array list
			nn.children.add(child);
		}

		// return the newly created node
		return nn;

	}

	public void display() {
		System.out.println("-------------------");
		display(this.root);
		System.out.println("-------------------");
	}

	private void display(Node node) {

		// self work
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " ";
		}
		str += ".";
		System.out.println(str);

		// smaller problem
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int count = 0;

		for (Node child : node.children) {
			count += size(child);
		}

		return count + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);
			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find(child, item);
			if (cf)
				return true;

		}

		return false;
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		// smaller problem
		for (Node child : node.children) {
			mirror(child);
		}

		// self work
		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {

			Node ln = node.children.get(left);
			Node rn = node.children.get(right);

			node.children.set(left, rn);
			node.children.set(right, ln);

			left++;
			right--;
		}

	}

	private void mirrorAlternative(Node node) {

		// smaller problem
		for (Node child : node.children) {
			mirrorAlternative(child);
		}

		// self work
		ArrayList<Node> list = new ArrayList<>();

		for (int i = node.children.size() - 1; i >= 0; i--) {
			list.add(node.children.get(i));
		}

		node.children = list;

	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {

		// node print
		System.out.println(node.data);

		// child command
		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		// child command
		for (Node child : node.children) {
			postorder(child);
		}

		// self work of printing
		System.out.println(node.data);

	}

	public void traversal() {
		traversal(this.root);
	}

	private void traversal(Node node) {

		System.out.println("hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {
			System.out.println("going towards " + node.children.get(i).data);
			traversal(node.children.get(i));
			System.out.println("coming from " + node.children.get(i).data);
		}

		System.out.println("bye " + node.data);

	}

	// O(n*h)
	public void levelorderRecursive() {

		int th = this.ht();
		for (int i = 0; i <= th; i++) {
			printAtLevel(0, i, this.root);
		}
		System.out.println();
	}

	public void printAtLevel(int level, int ht, Node node) {

		if (level == ht) {
			System.out.print(node.data + " ");
			return;
		}

		for (Node child : node.children) {
			printAtLevel(level + 1, ht, child);
		}
	}

	// Time : O(n)
	public void levelorderIterative() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();

	}

	public void levelorderlw() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = helper;
				helper = new LinkedList<>();
			}

		}

	}

	public void levelorderzz() {

		int count = 0;
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}
			if (queue.isEmpty()) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				count++;
			}

		}

	}

	public void levelorderzz1() {

		int count = 0;
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> s = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}
			if (queue.isEmpty()) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				count++;
			}

		}

	}

	
}
