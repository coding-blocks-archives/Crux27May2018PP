package L3_May31;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-May-2018
 * 
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] array = takeInput();
		// int[] array = { 50, 60, 10, 80, 30 };
		int[] array = new int[100000];

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		// Arrays.sort(array);
		// display(array);
		// System.out.println(linearSearch(array, 600));
		// System.out.println(binarySearch(array, 40));
		//
		// bubbleSort(array);
		long start = System.currentTimeMillis();
		bubbleSort(array);

		long end = System.currentTimeMillis();
		System.out.println(end - start);
		// display(array);

	}

	public static int[] takeInput() {

		System.out.println("Size  ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " th value ?");
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i <= arr.length - 1; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;

	}

	public static int[] rotate(int[] arr, int r) {

		r = r % arr.length;

		if (r < 0) {
			r = r + arr.length;
		}
		int[] finalArray = new int[arr.length];

		for (int i = 0; i < finalArray.length; i++) {

			if (i < r) {
				finalArray[i] = arr[i + arr.length - r];
			} else {
				finalArray[i] = arr[i - r];
			}
		}

		return finalArray;

	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;
		boolean flag = true;
		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (arr[j] > arr[j + 1]) {
					flag = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

			if (flag)
				break;

		}

	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			int min = counter;

			for (int j = counter + 1; j <= n - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			// swap
			int temp = arr[counter];
			arr[counter] = arr[min];
			arr[min] = temp;
		}

	}

	public static void insertionSort(int[] arr) {

		int n = arr.length;
		for (int counter = 1; counter <= n - 1; counter++) {

			int temp = arr[counter];

			int j = counter - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;
		}

	}

}
