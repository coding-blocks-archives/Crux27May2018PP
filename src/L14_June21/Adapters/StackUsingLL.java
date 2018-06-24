package L14_June21.Adapters;

import L11_June14.LinkedList;

public class StackUsingLL {

	LinkedList list = new LinkedList();

	public void push(int item) throws Exception {

		try {
			list.addFirst(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}
	}

	public int pop() throws Exception {

		try {
			return list.removeFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public int top() throws Exception {

		try {
			return list.getFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public void display() throws Exception {

		list.display();
	}

}
