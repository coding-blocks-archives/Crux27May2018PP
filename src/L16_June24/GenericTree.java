package L16_June24;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 24, 2018
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
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
		display(this.root);
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

}
