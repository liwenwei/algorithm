/*****************************************************************
 * 2.2.14 归并有序队列
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

public class Ex2_2_14_MergeSortedQueues {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7, 9};
		int[] arr2 = {2, 4, 6, 8, 10};
		int[] merged = mergeSortedQueues(arr1, arr2);
		System.out.println(Arrays.toString(merged));
	}
	
	/**
	 * 将两个有序的队列归并为一个有序队列
	 * 具体的合并算法类似{@link com.liwenwei.algs4.code.Merge#sort(Comparable[])}
	 * @param arr1 有序队列1
	 * @param arr2 有序队列1
	 * @return 归并后的有序队列
	 */
	public static int[] mergeSortedQueues(int[] arr1, int[] arr2) {
		int len1 = arr1.length, len2 = arr2.length;
		int i = 0, j = 0;
		int len = len1 + len2;
		int[] mergedArr = new int[len];
		for (int k = 0; k < len; k++) {
			if (i > len1 - 1)             mergedArr[k] = arr2[j++];
			else if (j > len2 - 1)        mergedArr[k] = arr1[i++];
			else if (arr1[i] > arr2[j])   mergedArr[k] = arr2[j++];
			else                          mergedArr[k] = arr1[i++];
		}
		return mergedArr;
	}
	
}
