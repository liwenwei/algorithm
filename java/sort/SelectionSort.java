package sort;

import java.util.Arrays;

public class SelectionSort {

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 9, 4, 3 };
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
