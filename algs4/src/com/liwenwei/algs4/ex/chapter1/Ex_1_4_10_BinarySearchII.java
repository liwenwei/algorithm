/****************************************************************
 * 1.4.10 修改二分查找算法，使之总是分会和被查找的键匹配的索引最小的元素（且仍然能够
 * 保证对数级别的运行时间）
 * 
 * 
 ****************************************************************/

package com.liwenwei.algs4.ex.chapter1;

public class Ex_1_4_10_BinarySearchII {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 5, 6, 8, 9, 12, 20, 20, 20, 30 };
		
		System.out.println("Binary Search: " + binarySearch(arr, 20, 0, arr.length - 1));
		System.out.println("Expect valuse: " + 7);
	}

	private static int binarySearch(int[] array, int key, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (array[mid] < key) {
			return binarySearch(array, key, mid + 1, high);
		} else if (array[mid] > key) {
			return binarySearch(array, key, low, mid - 1);
		} else {
			int smallestIndex = binarySearch(array, key, 0, mid - 1);
			if (smallestIndex == -1) {
				return mid;
			} else {
				return smallestIndex;
			}
		}
	}

}
