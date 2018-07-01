package L21_July1.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class GenericFxnDemo {

	public static void main(String[] args) {

		Integer[] iarr = { 10, 20, 30, 40, 50 };

		String[] sarr = { "abc", "def", "ghi" };
		display(iarr);
		display(sarr);

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 100, "grey");
		cars[1] = new Car(300, 600, "red");
		cars[2] = new Car(700, 400, "black");
		cars[3] = new Car(200, 200, "white");
		cars[4] = new Car(900, 1000, "Black");

		// bubbleSort(cars);
		bubbleSort(cars, new CarSpeedComparator());
		display(cars);

		bubbleSort(cars, new CarPriceComparator());
		display(cars);

		bubbleSort(cars, new CarColorComparator());
		display(cars);

	}

	public static void display(String[] arr) {
		for (String val : arr) {
			System.out.println(val);
		}
	}

	public static <T> void display(T[] arr) {

		System.out.println("-------------------");
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("-------------------");
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (comparator.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

}
