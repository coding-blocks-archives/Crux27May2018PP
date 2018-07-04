package L22_July3;

import java.util.ArrayList;

import L21_July1.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Jul-2018
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();

		// for (int i = 1; i <= 5; i++) {
		// heap.add(10 * i);
		// }

		heap.add(10);
		heap.add(100);
		heap.add(30);
		heap.add(70);
		heap.add(1);

		for (int i = 1; i <= 5; i++) {
			System.out.println(heap.remove());
		}

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 100, "grey");
		cars[1] = new Car(300, 600, "red");
		cars[2] = new Car(700, 400, "black");
		cars[3] = new Car(200, 200, "white");
		cars[4] = new Car(900, 1000, "Black");

		HeapGeneric<Car> heapg = new HeapGeneric<>();

		for (int i = 0; i <= 4; i++) {
			heapg.add(cars[i]);
		}

		for (int i = 1; i <= 5; i++) {
			System.out.println(heapg.remove());
		}

		HeapGeneric<Integer> heapgi = new HeapGeneric<>();

		heapgi.add(10);
		heapgi.add(100);
		heapgi.add(30);
		heapgi.add(70);
		heapgi.add(1);

		for (int i = 1; i <= 5; i++) {
			System.out.println(heapgi.remove());
		}

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(10);
		list1.add(15);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(15);
		list2.add(100);
		list2.add(200);
		list2.add(300);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(8);
		list3.add(9);
		list3.add(10);

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		System.out.println(mergeKSortedList(lists));

		ArrayList<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(100);
		list.add(20);
		list.add(30);
		list.add(5);

		System.out.println(kLargestElements(list, 3));
		
		list.clear();

	}

	private static class Pair implements Comparable<Pair> {

		int data;
		int listNo;
		int itemNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists) {

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.itemNo = 0;
			np.listNo = i;

			heap.add(np);
		}

		ArrayList<Integer> ans = new ArrayList<>();

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			rp.itemNo++;

			if (rp.itemNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.itemNo);
				heap.add(rp);
			}

		}

		return ans;

	}

	public static ArrayList<Integer> kLargestElements(ArrayList<Integer> list, int k) {

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {

			int tp = heap.get();

			if (list.get(i) > tp) {
				heap.remove();
				heap.add(list.get(i));
			}

		}

		ArrayList<Integer> ans = new ArrayList<>();

		while (!heap.isEmpty()) {
			ans.add(heap.remove());
		}

		return ans;
	}

}
