package L11_June14;

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(200);
		list.addLast(30);
		list.addLast(40);
		list.display();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		// System.out.println(list.getAt(0));
		list.addLast(50);
		list.display();
		// System.out.println(list.getAt(3));
		list.addFirst(100);
		// System.out.println(list.removeLast());
		list.display();
		// System.out.println(list.removeFirst());
		// list.display();

		// list.kReverse(3);
		// list.display();
		list.addLast(67);
		// list.display();

		// System.out.println(list.kthFromLast(3));

		list.display();
		// list.RDR();
		list.display();

		// list.fold();
		list.display();
		list.addLast(100);
		list.display();

		list.mergeSort();
		list.display();

		// list.createDummyList();
		// list.display();
		list.cycleRemoval();
		list.display();

	}

}
