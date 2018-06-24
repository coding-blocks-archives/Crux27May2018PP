package L10_June12;

public class QueueClient {

	public static void main(String[] args) throws Exception {

		Queue queue = new Queue();
		queue.enqueue(10);
		queue.display();
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();

		queue.dequeue();
		queue.enqueue(60);
		queue.enqueue(70);
		queue.display();

		// reverseDisplay(queue, 0);
		// queue.display();
	}

	public static void actualReverse(Queue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();
		actualReverse(q);
		q.enqueue(temp);

	}

	public static void reverseDisplay(Queue q, int count) throws Exception {

		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);
		reverseDisplay(q, count + 1);

		System.out.println(temp);

	}

}
