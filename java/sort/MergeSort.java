package sort;

import java.util.Arrays;

public class MergeSort {

	private static int[] aue;

	private static void merge(int[] arr, int lo, int hi) {
		int mid = (hi - lo) / 2 + lo;
		int i = lo;
		int j = mid + 1;
		// 复制arr[low, high]到aue
		for (int k = lo; k <= hi; k++) {
			aue[k] = arr[k];
		}

		/*
		 * 4个判断条件：
		 * - 左边取完取右边
		 * - 右边取完取左边
		 * - 如果左边当前值大于右边当前值，取右边
		 * - 如果右边当前值大于左边当前值，取左边
		 */
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = aue[j++];
			} else if (j > hi) {
				arr[k] = aue[i++];
			} else if (aue[i] > aue[j]) {
				arr[k] = aue[j++];
			} else {
				arr[k] = aue[i++];
			}
		}
	}

	private static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int mid = (hi - lo) / 2 + lo;
		sort(arr, lo, mid);      // Sort arr[low, mid]
		sort(arr, mid + 1, hi);  // Sott arr[mid+1, high]
		merge(arr, lo, hi);
	}

	public static void sort(int[] arr) {
		aue = new int[arr.length];
		sort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 9, 4, 3, 2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
