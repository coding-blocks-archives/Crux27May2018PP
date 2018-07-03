package L22_July3;

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

	}

}
