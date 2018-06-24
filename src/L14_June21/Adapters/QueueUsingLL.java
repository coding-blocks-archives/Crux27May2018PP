package L14_June21.Adapters;

import L11_June14.LinkedList;

public class QueueUsingLL {

	LinkedList list = new LinkedList();

	public void enqueue(int item) throws Exception {

		try {
			list.addLast(item);
		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}
	}

	public int dequeue() throws Exception {

		try {
			return list.removeFirst();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}

	}

	public int getFront() throws Exception {

		try {
			return list.getFirst();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}

	}

	public void display() throws Exception {

		list.display();
	}

}
