/***********************************************************************
 * 
 * 快速排序（quick sort)， 小数区 基准点 大数区
 * 
 ***********************************************************************/
package sort;

import java.util.Arrays;

public class QuickSort {
	
	private static int partition(int[] arr, int lo, int hi) {
		int pivot = lo;  // pivot
		int i = lo;      // 左边扫描指针（向右扫描）
		int j = hi + 1;  // 右边扫描指针（向左扫描）
		
		while (true) {
			// 左右扫描
			while (arr[pivot] > arr[++i]) if (i == hi) break;
			while (arr[pivot] < arr[--j]) if (j == lo) break;
			if (i >= j) break; // 当左右扫描指针相遇时主循环退出
			swap(arr, i, j);
		}
		swap(arr, pivot, j);
		return j;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int pivot = partition(arr, lo, hi);  // 切分
		sort(arr, lo, pivot - 1);            // 将左半部分arr[lo .. j-1]排序
		sort(arr, pivot + 1, hi);            // 将右半部分arr[j+1 .. hi]排序
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
