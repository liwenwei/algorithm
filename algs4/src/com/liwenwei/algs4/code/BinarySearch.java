package com.liwenwei.algs4.code;

public class BinarySearch {

	private BinarySearch() { }
	
	public static int indexOf(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < key) {
				high = mid - 1;
			} else if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	@Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }
	
}
