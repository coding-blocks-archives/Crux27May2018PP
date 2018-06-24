package L10_June12;

public class Queue {

	protected int size;
	protected int front;
	protected int[] data;

	public Queue() {
		this.size = 0;
		this.front = 0;
		this.data = new int[5];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;

	}

	public void enqueue(int item) throws Exception {

		if (this.size() == this.data.length) {
			throw new Exception("Queue is Full.");
		}

		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;

		this.size++;

	}

	public int dequeue() throws Exception {

		if (this.size() == 0) {
			throw new Exception("Queue is Empty.");
		}

		int rv = this.data[this.front];

		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;

	}

	public int getFront() throws Exception {

		if (this.size() == 0) {
			throw new Exception("Queue is Empty.");
		}

		int rv = this.data[this.front];
		return rv;

	}

	public void display() {
		System.out.println("---------------------------");

		for (int i = 0; i < this.size; i++) {
			int idx = (i + this.front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
		System.out.println(".");
		System.out.println("---------------------------");
	}

}
