package L21_July1.GenericClass;

public class LinkedListGeneric<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public T getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		return head.data;

	}

	// O(1)
	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return tail.data;

	}

	// O(n)
	public T getAt(int idx) throws Exception {
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
	public void addLast(T item) {

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
	public void addFirst(T item) {

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
	public void addAt(T item, int idx) throws Exception {

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
	public T removeLast() throws Exception {

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
	public T removeFirst() throws Exception {

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
	public T removeAt(int idx) throws Exception {

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

}
