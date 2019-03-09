/*****************************************************************
 * 三向切分的快速排序（熵最优的排序）
 * 
 * <p>实际应用中经常会出现大量重复元素的数组，例如我们可能需要将大量人员资料按照生日排序，或是按照性别区分开来。
 * 在这些情况下，我们事先的快速排序的性能尚可，但还有巨大的改进空间。例如，一个元素全部全部重复的子数组就不需要
 * 继续排序了，但我们的算法还会继续将它切分为更小的数组。</p>
 * 
 * <p>一个简单的想法就是将数组切分为三部分，分别对应小于、等于和大于切分元素的数组元素。</p>
 * 
 * <p>Dijkstra的三向切分的快速排序。它从做到右遍历数组一次，维护一个指针lt使得a[lo..lt-1]中的元
 * 素都小于v，一个指针gt使得a[gt+1..hi]中的元素都大于v，一个指针i使得a[lt-i-1]中的元素都等于v，
 * a[i..gt]中的元素都还未确定
 * <ul>
 * <li>a[i]小于v，将a[lt]和a[i]交换，将lt和i加一</li>
 * <li>a[i]大于v，将a[gt]和a[i]交换，将gt和i加一</li>
 * <li>a[i]等于v，将i加一</li>
 * </ul>
 * </p>
 * 
 * <p>
 *      ________________________________________
 * 切分前：|v|                                   |v|
 *      ________________________________________
 *      low                                   hi
 *    
 *      ________________________________________
 * 切分中：|  <v  |  =v  |               |   >v   |
 *      ________________________________________
 *             lt     i               gt   
 * 
 *      ________________________________________
 * 切分后：|       <v        |  =v  |     >v      |
 *      ________________________________________
 *      lo                lt     gt            hi
 * </p>
 * 
 * @author liwenwei
 * 
***************************************************************/

package com.liwenwei.algs4.code;

import java.util.Arrays;

/**
 * Quicksort with 3-way partitioning
 * 
 * @author liwenwei
 *
 */
public class Quick3Way {

	public static void main(String[] args) {
		int[] a = { 6, 4, 10, 9, 7, 7, 8, 10, 8, 9, 10 };
		Quick3Way quick3Way = new Quick3Way();
		quick3Way.sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	
	public void sort(int[] a, int low, int high) {
		if (low >= high) return;
		int lt = low, gt = high;
		int i = low;
		int pivot = a[low];
		while (i <= gt) {
			if (a[i] < pivot) swap(a, lt++, i++);
			else if (a[i] > pivot) swap(a, i, gt--);
			else i++;
		} // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
		sort(a, low, lt - 1);
		sort(a, gt + 1, high);
	}
	
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
