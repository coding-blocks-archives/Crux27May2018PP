package L11_June14;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		return head.data;

	}

	// O(1)
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return tail.data;

	}

	// O(n)
	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;

	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp;

	}

	// O(1)
	public void addLast(int item) {

		// 1. new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// 2. attach
		if (this.size > 0)
			this.tail.next = nn;

		// 3. summary update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	// O(1)
	public void addFirst(int item) {

		// 1. new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// 2. attach
		nn.next = this.head;

		// 3. summary update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}
	}

	// O(n)
	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {
			// 1. new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// 2. attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;
			nm1.next = nn;
			nn.next = np1;

			// 3. summary update
			this.size++;
		}

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node ln = this.tail;

		// summary update
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sm2 = getNodeAt(this.size - 2);
			this.tail = sm2;
			this.tail.next = null;
			this.size--;

		}

		return ln.data;
	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node fn = this.head;

		// summary update
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			this.head = this.head.next;
			this.size--;

		}

		return fn.data;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}

	}

	public void display() {

		System.out.println("--------------------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("--------------------------");

	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	private Node midNode() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public int kthFromLast(int k) {

		Node fast = this.head;
		Node slow = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;
		LinkedList curr = null;

		while (this.size != 0) {

			curr = new LinkedList();

			for (int i = 1; i <= k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void RDI() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}

	}

	public void RPI() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	public void RPR() {

		RPRH(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	private void RPRH(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		RPRH(curr, curr.next);
		curr.next = prev;

	}

	private class Mover {
		Node left;
	}

	public void RDR() {
		Mover mover = new Mover();
		mover.left = this.head;

		RDRH(mover, this.head, 0);
	}

	private void RDRH(Mover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		RDRH(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;

	}

	public void fold() {

		Mover mover = new Mover();
		mover.left = this.head;

		fold(mover, this.head, 0);
	}

	private void fold(Mover mover, Node right, int count) {

		if (right == null) {
			return;
		}
		fold(mover, right.next, count + 1);

		if (count > this.size / 2) {

			Node temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;

			mover.left = temp;

		}

		if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public void createDummyList() {

		Node n1 = new Node();
		n1.data = 10;
		Node n2 = new Node();
		n2.data = 20;
		Node n3 = new Node();
		n3.data = 30;
		Node n4 = new Node();
		n4.data = 40;
		Node n5 = new Node();
		n5.data = 50;
		Node n6 = new Node();
		n6.data = 60;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n2;

		this.head = n1;
		this.tail = n6;
		this.size = 6;
	}

	public LinkedList mergeTwoSortedLL(LinkedList other) {

		Node temp1 = this.head;
		Node temp2 = other.head;

		LinkedList merged = new LinkedList();

		while (temp1 != null && temp2 != null) {

			if (temp1.data < temp2.data) {
				merged.addLast(temp1.data);
				temp1 = temp1.next;
			} else {
				merged.addLast(temp2.data);
				temp2 = temp2.next;
			}
		}

		if (temp1 == null) {
			while (temp2 != null) {
				merged.addLast(temp2.data);
				temp2 = temp2.next;
			}
		}

		if (temp2 == null) {
			while (temp1 != null) {
				merged.addLast(temp1.data);
				temp1 = temp1.next;
			}
		}

		return merged;

	}

	public void mergeSort() {

		if (this.size == 1) {
			return;
		}

		Node mid = midNode();
		Node midn = mid.next;

		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();
		sh.head = midn;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2;

		fh.mergeSort();
		sh.mergeSort();

		LinkedList merged = fh.mergeTwoSortedLL(sh);

		this.head = merged.head;
		this.tail = merged.tail;
		this.size = merged.size;

	}

}
