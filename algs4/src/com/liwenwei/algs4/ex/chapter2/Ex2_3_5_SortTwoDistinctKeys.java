/*****************************************************************
 * 2.3.5 Give a code fragment that sorts an arrays that is known
 * to consist of items having just two distinct keys
 * 
 * @author liwenwei
 * 
***************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

public class Ex2_3_5_SortTwoDistinctKeys {

	public static void main(String[] args) {
		int[] binaries = {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
		Ex2_3_5_SortTwoDistinctKeys distinctKeys = new Ex2_3_5_SortTwoDistinctKeys();
		distinctKeys.binarySort(binaries);
		System.out.println(Arrays.toString(binaries));
	}
	
	/**
	 * The array just have two distinct keys
	 * p = pivot
	 * |  <p |  =p   |   ??    |  >p  |
	 *       lt->    i->    <-gt
	 * 
	 * Same as Quick with 3-way partitioning
	 * 
	 */
	public void binarySort(int[] arr) {
		int pivot = arr[0];
		int lt = 0, gt = arr.length - 1;
		int i = 0;
		while (i < gt) {
			if (arr[i] > pivot) {
				swap(arr, gt--, i);
			} else if (arr[i] < pivot) {
				swap(arr, lt++, i++);
			} else {
				i++;
			}
		}
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
