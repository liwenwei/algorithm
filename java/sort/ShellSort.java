package sort;

import java.util.Arrays;

public class ShellSort {

	public static void sort(int[] arr) {
		final int len = arr.length;
		int h = 0;
		while (h < len) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			// insertion sort
			for (int i = h; i < len; i += h) {
				for (int j = i; j > 0; j -= h) {
					if (arr[j] < arr[j - 1]) {
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					}
				}
			}
			h /= 3;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 9, 4, 3 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
