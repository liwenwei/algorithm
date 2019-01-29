package sort;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 9, 4, 3 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
