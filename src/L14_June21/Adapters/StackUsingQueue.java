package L14_June21.Adapters;

import L10_June12.DynamicQueue;
import L10_June12.Queue;

// push efficient
public class StackUsingQueue {

	DynamicQueue queue = new DynamicQueue();

	public void push(int item) throws Exception {

		try {
			queue.enqueue(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}
	}

	public int pop() throws Exception {

		try {
			DynamicQueue helper = new DynamicQueue();

			while (queue.size() != 1) {
				int removedValue = queue.dequeue();
				helper.enqueue(removedValue);
			}

			int rv = queue.dequeue();

			queue = helper;

			return rv;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public int top() throws Exception {

		try {
			DynamicQueue helper = new DynamicQueue();

			while (queue.size() != 1) {
				int removedValue = queue.dequeue();
				helper.enqueue(removedValue);
			}

			int rv = queue.dequeue();
			helper.enqueue(rv);
			queue = helper;

			return rv;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public void display() throws Exception {

		reverseDisplay(0);
	}

	private void reverseDisplay(int count) throws Exception {

		if (count == queue.size()) {
			return;
		}

		int temp = queue.dequeue();
		queue.enqueue(temp);
		reverseDisplay(count + 1);

		System.out.println(temp);

	}

}
