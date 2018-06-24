package L10_June12;

public class DQClient {

	public static void main(String[] args) throws Exception {

		DynamicQueue queue = new DynamicQueue();
		queue.enqueue(10);
		queue.display();
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		queue.enqueue(60);
		queue.enqueue(70);
		queue.display();
	}

}
