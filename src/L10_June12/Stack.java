package L10_June12;

public class Stack {

	protected int[] data;
	protected int tos;

	public Stack() {
		this.data = new int[5];
		this.tos = -1;
	}

	public Stack(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public int size() {
		return this.tos + 1;

	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(int item) throws Exception {

		if (this.size() == this.data.length) {
			throw new Exception("Stack is Full.");
		}

		this.tos++;
		this.data[this.tos] = item;

	}

	public int pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}

		int rv = data[tos];
		data[tos] = 0;
		this.tos--;

		return rv;
	}

	public int top() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}

		int rv = data[tos];
		return rv;
	}

	public void display() {

		System.out.println("-------------------------");

		for (int i = this.tos; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println(".");
		System.out.println("-------------------------");
	}

	
}